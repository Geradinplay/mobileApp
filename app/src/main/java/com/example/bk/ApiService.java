package com.example.bk;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("customer/hello")
    Call<HelloObject> helloObject();

    @GET("customer/{index}")
    Call<Customer> getSubjects();

}

