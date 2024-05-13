package com.example.trafficapp;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.GET;
public class ApiService {
    private static final String BASE_URL = "https://api.jamesdecelis.com/api/v1/";
    private static final Moshi moshi = new Moshi.Builder().add(new KotlinJsonAdapterFactory()).build();
    private static final Retrofit retrofit = new Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).build();
    public interface Service {
        @GET("streetname")
        Call<List<News>> getAllData();
    }
    public static Service getService() {
        return retrofit.create(Service.class);
    }
}
