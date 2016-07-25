package com.mj.myapplication.net;

import com.mj.myapplication.net.entity.Message;
import com.mj.myapplication.net.entity.Shops;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by huaqiang
 * on 2016-07-20.
 */
public interface NetService {
    @POST("/detail")
    Call<Message> getMsg(@Query("ak") String ak);

    //http://127.0.0.1:8080/system_03/servlet/Hq
    @POST("/system_03/servlet/Hq")
    Call<List<Shops>> getShops(@Query("sid") String sid);

}
