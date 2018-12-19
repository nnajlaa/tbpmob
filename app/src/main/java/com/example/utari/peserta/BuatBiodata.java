package com.example.utari.peserta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BuatBiodata {

    @GET("/api/pendaftar")
    Call<PesertaList> getPeserta();

}
