package com.idreamo.rrtoyewx.smipledemo;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.idreamo.rrtoyewx.smipledemo.adapter.LeftMenuAdapter;


public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private DrawerLayout mDrawLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private ListView mLeftMenu;
    private LeftMenuAdapter mLeftMenuAdapter;

    private static final SparseArray<Integer> titles = new SparseArray<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        bind();
    }



    public static void start(Context context){
        if(context!=null){
            Intent intent = new Intent(context,MainActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    private void initView(){
        mToolbar = (Toolbar) this.findViewById(R.id.main_toolbar);
        mToolbar.setTitle(getResources().getString(R.string.SimleDemo));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawLayout = (DrawerLayout) this.findViewById(R.id.main_drawerlayout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,mDrawLayout,mToolbar,R.string.open,R.string.close){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                setToolbarTitle(R.string.SimleDemo);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }
        };
        mActionBarDrawerToggle.syncState();
        mLeftMenu = (ListView) this.findViewById(R.id.main_left_menu);

    }
    private void initData() {
        titles.clear();
        titles.put(0, R.string.news);
        titles.put(1, R.string.photo);
        titles.put(2, R.string.video);
        titles.put(3,R.string.music);
        mLeftMenuAdapter = new LeftMenuAdapter(this,titles);
        mLeftMenu.setAdapter(mLeftMenuAdapter);
    }

    @Override
    protected void onResume() {
        mLeftMenu.deferNotifyDataSetChanged();
        super.onResume();
    }

    private void bind() {
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        mDrawLayout.setDrawerListener(mActionBarDrawerToggle);
        mLeftMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        mDrawLayout.closeDrawer(Gravity.LEFT);
                        setToolbarTitle(R.string.News);
                        break;
                    case 1:
                        mDrawLayout.closeDrawer(Gravity.LEFT);
                        setToolbarTitle(R.string.Photo);
                        break;
                    case 2:
                        mDrawLayout.closeDrawer(Gravity.LEFT);
                        setToolbarTitle(R.string.Video);
                        break;
                    case 3:
                        mDrawLayout.closeDrawer(Gravity.LEFT);
                        setToolbarTitle(R.string.Music);
                        break;
                    default:
                }
            }
        });
    }
    private void setToolbarTitle(int Rsd){
        getSupportActionBar().setTitle(Rsd);
    }

    private void setToolbarTitle(String string){
        getSupportActionBar().setTitle(string);
    }

}
