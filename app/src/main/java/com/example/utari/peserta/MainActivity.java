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
    RecyclerView recyclerView;
    ProgressBar progressBar;
    PesertaListAdapter pesertaListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, String.valueOf(daftarPeserta.size()));

        pesertaListAdapter = new PesertaListAdapter();
        pesertaListAdapter.setDaftarPeserta(daftarPeserta);
        pesertaListAdapter.setClickHandler(this);

        recyclerView = findViewById(R.id.idRvPeserta);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(pesertaListAdapter);



        getPeserta();

        //Button btn = (Button) findViewById(R.id.button_add);

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                Intent intent = new Intent(MainActivity.this, BuatBiodata.class);
//                startActivity(intent);
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.refresh, menu);
        return super.onCreateOptionsMenu( menu );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Toast.makeText( this, "Refresh", Toast.LENGTH_SHORT ).show();
        //SharedPreferences preferences = getPreferences( Context.MODE_PRIVATE );
        if (item.getItemId() == R.id.idRefresh) {
            Toast.makeText(this, "Refreshing data", Toast.LENGTH_SHORT).show();

            getPeserta();
        }
        return super.onOptionsItemSelected( item );
    }

    private void getPeserta(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pendaftaran-sbmptn.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BuatBiodata client =  retrofit.create(BuatBiodata.class);

        Call<PesertaList> call = client.getPeserta();

        call.enqueue(new Callback<PesertaList>() {
            @Override
            public void onResponse(Call<PesertaList> call, Response<PesertaList> response) {

                PesertaList pesertaList = response.body();
                List<PesertaItem> listPesertaItem = pesertaList.data;
                pesertaListAdapter.setDaftarPeserta( new ArrayList<PesertaItem>(listPesertaItem ) );
                recyclerView.setAdapter(pesertaListAdapter);

                Toast.makeText(MainActivity.this, String.valueOf(listPesertaItem.get(0).nama), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PesertaList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void pesertaItemClicked(PesertaItem pesertaItem) {

//        Toast.makeText(
//                this,
//                "Item yang diklik adalah : " + pesertaItem.getNama(),
//                Toast.LENGTH_SHORT).show();
//
//        Intent detailPesertaIntent = new Intent(this, DetailActivity.class);
//        detailPesertaIntent.putExtra("key_movie_parcelable", pesertaItem);
//        startActivity(detailPesertaIntent);

    }
}

