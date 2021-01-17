package com.example.second.service;

import com.example.second.model.Coffee;
import com.example.second.model.User;

import java.util.List;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestService {

//    public static String URL = "http://192.168.100.225:8081/rest/";
//    public static String URL = "http://192.168.100.225:8081/admin/";
    public static String URL = "http://192.168.43.136:8081/rest/";

    private RestApi restApi;

    public RestService() {
        Retrofit retrofit = createRetrofit();
        restApi = retrofit.create(RestApi.class);
    }

    public Single<List<User>> findAll() {
        return restApi.findAll();
    }

    public Single<List<Coffee>> findAllCoffees() {
        return restApi.findAllCoffees();
    }

    private OkHttpClient createOkHttpClient() {
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);

        return httpClient.build();
    }

    private Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
