package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        https://pheptinhonline.herokuapp.com/chia/4/0

        // 1 : Cau hinh moi truong retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pheptinhonline.herokuapp.com/")
                .build();

        //3 : Khoi tao interface request
        RequestApi requestApi = retrofit.create(RequestApi.class);
        //4 : Gui request api muon thuc thi
        Call<String> callbackApiCong = requestApi.apiCong();
        // 5 : Goi enqueue cho viec lay thong tin request
        callbackApiCong.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String chuoi = response.body();
                Log.d("BBB",chuoi);
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
                Log.d("BBB",throwable.getMessage());
            }
        });
    }
}