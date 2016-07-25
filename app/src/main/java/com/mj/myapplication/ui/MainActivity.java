package com.mj.myapplication.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mj.core.util.L;
import com.mj.myapplication.App;
import com.mj.myapplication.R;
import com.mj.myapplication.net.entity.Message;
import com.mj.myapplication.net.entity.Shops;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends Activity {

    @InjectView(R.id.text)
    TextView text;
    @InjectView(R.id.btn_request)
    Button btnRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_opc);
        ButterKnife.inject(this);
        //getMsg("wFaGSijGMsFEI5oxcnS0zFmPosPTG6eB");
        getShops("1");
    }

    Message message;

    List<Shops> shopsList;
    @OnClick({R.id.btn_request})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_request:
                text.setText(shopsList.toString());
                break;
        }
    }

    public void getShops(String str) {
        Call<List<Shops>> call = App.getNetService().getShops(str);
        call.enqueue(new Callback<List<Shops>>() {
            @Override
            public void onResponse(Call<List<Shops>> call, Response<List<Shops>> response) {
                shopsList=response.body();
                L.e("whq --- "+shopsList);
            }

            @Override
            public void onFailure(Call<List<Shops>> call, Throwable t) {
                L.e("whq --- "+t.getMessage());
            }

        });
    }

    public void getMsg(String ak) {
        Call<Message> call = App.getNetService().getMsg(ak);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                message= (Message) call;
                L.e("whq --- "+message);
                if (response.isSuccess()){

                }else {

                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                L.e("whq ---- "+t.getMessage());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
