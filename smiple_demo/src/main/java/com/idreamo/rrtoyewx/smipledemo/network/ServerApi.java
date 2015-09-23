package com.idreamo.rrtoyewx.smipledemo.network;

import android.content.Context;
import android.widget.Toast;

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
import com.fasterxml.jackson.databind.JavaType;
import com.idreamo.rrtoyewx.smipledemo.utils.JsonUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;
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
    private static Context mContext;

    public static void init(Context context){
        mRequestQueue = Volley.newRequestQueue(context);
        mSimpleImageLoader = new SimpleImageLoader(mRequestQueue,BitmapImageCache.getInstance(null));
        mContext = context;
    }

    //getSimpleImageLoader
    public static SimpleImageLoader getImageLoader() {
        return mSimpleImageLoader;
    }

    //get total news
    public static void getTotalNews(final Response.Listener<String> listener, final Response.ErrorListener errorListener){
        Request request = buildRequest(ServerApi.TotalNews, null, listener, errorListener);
        mRequestQueue.add(request);
    }
    //get total detail news
    public static void getDetailsNews(final String url,final Response.Listener<String> listener, final Response.ErrorListener errorListener){
        Request request = buildRequest(url,null,listener,errorListener);
        mRequestQueue.add(request);
    }


    public static Request buildRequest(final String url,final Map<String,String>params,final Response.Listener<String> listener, final Response.ErrorListener errorListener){
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
                    return ;
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

    public static Object deserialize(String json, String containerType, Class cls) throws Exception {
        try {
            if ("List".equals(containerType)) {
                JavaType typeInfo = JsonUtil.getJsonMapper().getTypeFactory().constructCollectionType(List.class, cls);
                List response = (List<?>) JsonUtil.getJsonMapper().readValue(json, typeInfo);
                return response;
            } else if (String.class.equals(cls)) {
                if (json != null && json.startsWith("\"") && json.endsWith("\"") && json.length() > 1)
                    return json.substring(1, json.length() - 2);
                else
                    return json;
            } else {
                return JsonUtil.getJsonMapper().readValue(json, cls);
            }
        } catch (IOException e) {
            throw e;
        }
    }

    private static String serialize(Object obj) throws Exception {
        try {
            if (obj != null)
                return JsonUtil.getJsonMapper().writeValueAsString(obj);
            else
                return null;
        } catch (Exception e) {
            throw e;
        }
    }


}
