package com.mj.myapplication;

import android.app.Application;

import com.mj.myapplication.net.NetService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by huaqiang
 * on 2016-07-20.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    private static NetService mNetService;

    public static NetService getNetService() {
        /*HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.SHIPPING_API_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mNetService = retrofit.create(NetService.class);
        return mNetService;
    }
    /**
     * //请求数据
     private static ShippingLineNet sShippingLineNet;

     public static ShippingLineNet getShippingLineNet() {
     if (null != sShippingLineNet)
     return sShippingLineNet;

     RestAdapter restAdapter = new RestAdapter.Builder()
     .setEndpoint(Config.SHIPPING_API_URL)
     .setLogLevel(RestAdapter.LogLevel.FULL)
     .build();
     sShippingLineNet = restAdapter.create(ShippingLineNet.class);
     return sShippingLineNet;
     }
     */
}
