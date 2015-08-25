package com.idreamo.rrtoyewx.smipledemo.network;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.cache.BitmapImageCache;
import com.android.volley.cache.SimpleImageLoader;
import com.android.volley.error.AuthFailureError;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Created by rrtoyewx on 15/8/21.
 */
public class ServerApi {
    /**
     * total news
     */
    public static final String TotalNews = "http://zhbj.qianlong.com/static/api/news/new_category.json";

    private static RequestQueue mRequestQueue = null;
    private static SimpleImageLoader mSimpleImageLoader = null;

    public static void init(Context context){
        mRequestQueue = Volley.newRequestQueue(context);
        mSimpleImageLoader = new SimpleImageLoader(mRequestQueue,BitmapImageCache.getInstance(null));
    }





    public static void getTotalNews(final Response.Listener<String> listener, final Response.ErrorListener errorListener){
        Request request = buildGetRequest(ServerApi.TotalNews,null,listener,errorListener);
        mRequestQueue.add(request);
    }
    public static Request buildGetRequest(final String url,final Map<String,String>params,final Response.Listener<String> listener, final Response.ErrorListener errorListener){
        final StringRequest request = new StringRequest(Request.Method.GET,url,null,null){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if(params==null){
                    return super.getParams();
                }else{
                    return params;
                }
            }
        };
        request.setListener(new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                listener.onResponse(response);
            }
        });

        request.setErrorListener(new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (request == null) {

                }

                Cache.Entry entry = mRequestQueue.getCache().get(request.getCacheKey());

                if (entry != null) {
                    byte[] data = entry.data;
                    if (data != null) {
                        String response = null;
                        try {
                            response = new String(data, "UTF_8");
                            listener.onResponse(response);
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                }

                errorListener.onErrorResponse(error);
            }
        });
        request.setParams(params);
        request.setShouldCache(true);
        request.setForceRequest(true);
        return request;
    }

}
