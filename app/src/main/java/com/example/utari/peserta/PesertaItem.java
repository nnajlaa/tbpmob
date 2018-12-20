package com.example.utari.peserta;

import android.os.Parcel;
import android.os.Parcelable;

public class PesertaItem implements Parcelable {
    int id;
    String nama;
    String jk;
    String ttl;
    String alamat;
    String instansi;
    Long nohp;
    String email;
    String foto;

    public PesertaItem(int id, String nama, String jenis_kelamin, String ttl, String alamat, String instansi, Long nohp, String email, String Foto){
        this.id = id;
        this.nama = nama;
        this.jk = jk;
        this.ttl = ttl;
        this.alamat = alamat;
        this.instansi = instansi;
        this.nohp = nohp;
        this.email = email;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJk() {
        return jk;
    }

    public String getTtl() {
        return ttl;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getInstansi() {
        return instansi;
    }

    public Long getNohp() {
        return nohp;
    }

    public String getEmail() {
        return email;
    }

    public String getFoto() {
        return foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt( this.id );
        dest.writeString( this.nama );
        dest.writeString( this.jk );
        dest.writeString( this.ttl );
        dest.writeString( this.alamat );
        dest.writeString( this.instansi );
        dest.writeLong( this.nohp );
        dest.writeString( this.email );
        dest.writeString( this.foto );
    }

    protected PesertaItem(Parcel in){
        this.id = in.readInt();
        this.nama = in.readString();
        this.jk = in.readString();
        this.ttl = in.readString();
        this.alamat = in.readString();
        this.instansi = in.readString();
        this.nohp = in.readLong();
        this.email = in.readString();
        this.foto = in.readString();
    }

    public static final Parcelable.Creator<PesertaItem> CREATOR = new Parcelable.Creator<PesertaItem>() {
        @Override
        public PesertaItem createFromParcel(Parcel source) {
            return new PesertaItem(source);
        }

        @Override
        public PesertaItem[] newArray(int size) {
            return new PesertaItem[size];
        }
    };
}
