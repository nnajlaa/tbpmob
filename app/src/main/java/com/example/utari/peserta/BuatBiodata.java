package com.example.utari.peserta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface BuatBiodata {

    @GET("/3/movie/now_playing")
    Call<PesertaList> getPeserta(@Query("api_key") String api_key);

}
