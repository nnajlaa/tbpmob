package com.example.utari.peserta;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
        implements PesertaListAdapter.OnPesertaItemClicked{

    private static final String TAG = "MainActivity";
    ArrayList<PesertaItem> daftarPeserta = new ArrayList<>();
    RecyclerView rvPeserta;
    ProgressBar progressBar;
    PesertaListAdapter pesertaListAdapter;

//    String[] daftar;
//    ListView ListView1;
//    Menu menu;
//    protected Cursor cursor;
//    DataHelper dbcenter;
//    public static MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, String.valueOf(daftarPeserta.size()));

        pesertaListAdapter = new PesertaListAdapter();
        pesertaListAdapter.setDaftarPeserta(daftarPeserta);
        pesertaListAdapter.setClickHandler(this);

        rvPeserta = findViewById(R.id.idRvPeserta);
        rvPeserta.setAdapter(pesertaListAdapter);
        rvPeserta.setLayoutManager(new LinearLayoutManager(this));

        Button btn = (Button) findViewById(R.id.button_add);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, BuatBiodata.class);
                startActivity(intent);
            }
        });

//        ma = this;
//        dbcenter = new DataHelper(this);
//        RefreshList();
    }

//    public void RefreshList() {
//        SQLiteDatabase db = dbcenter.getReadableDatabase();
//        cursor = db.rawQuery("SELECT * FROM biodata", null);
//        daftar = new String[cursor.getCount()];
//        cursor.moveToFirst();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.refresh, menu);
        return super.onCreateOptionsMenu( menu );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText( this, "Refresh", Toast.LENGTH_SHORT ).show();
        //SharedPreferences preferences = getPreferences( Context.MODE_PRIVATE );
        return super.onOptionsItemSelected( item );
    }

    private void getPeserta(){
        String API_BASE_URL = "http://pendaftaran-sbmptn.herokuapp.com/apipendaftar";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BuatBiodata client =  retrofit.create(BuatBiodata.class);

        Call<PesertaList> call = client.getPeserta("http://pendaftaran-sbmptn.herokuapp.com/apipendaftar");

        call.enqueue(new Callback<PesertaList>() {
            @Override
            public void onResponse(Call<PesertaList> call, Response<PesertaList> response) {
                Toast.makeText(MainActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                PesertaList movieList = response.body();
                List<PesertaItem> listMovieItem = movieList.results;
                pesertaListAdapter.setDaftarPeserta(listMovieItem);
            }

            @Override
            public void onFailure(Call<PesertaList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void pesertaItemClicked(PesertaItem pesertaItem) {

    }
}

