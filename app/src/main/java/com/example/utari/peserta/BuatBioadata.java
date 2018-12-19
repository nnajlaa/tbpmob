package com.example.utari.peserta;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class BuatBioadata  { //extends AppCompatActivity implements BuatBiodata
//    protected Cursor cursor;
//    DataHelper dbHelper;
//    Button ton1;
//    EditText text, text2, text3, text4, text5, text6, text10, text9;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_buat_biodata);
//
//        dbHelper=new DataHelper(this);
//        text = (EditText) findViewById(R.id.editText);
//        text2 = (EditText) findViewById(R.id.editText2);
//        text3 = (EditText) findViewById(R.id.editText3);
//        text4 = (EditText) findViewById(R.id.editText4);
//        text5 = (EditText) findViewById(R.id.editText5);
//        text6 = (EditText) findViewById(R.id.editText6);
//        text10 = (EditText) findViewById(R.id.editText10);
//        text9 = (EditText) findViewById(R.id.editText9);
//        ton1 = (Button) findViewById(R.id.button_add);
//
//        ton1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                db.execSQL("insert into biodata(id, nama, jk, ttl, alamat, instansi, nohp , email) values('" +
//                        text.getText().toString() + "','" +
//                        text2.getText().toString() + "','" +
//                        text3.getText().toString() + "','" +
//                        text4.getText().toString() + "','" +
//                        text5.getText().toString() + "','" +
//                        text6.getText().toString() + "','" +
//                        text9.getText().toString() + "','" +
//                        text10.getText().toString() + "')");
//                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
//                MainActivity.ma.RefreshList();
//                finish();
//            }
//        });
//    }
}
