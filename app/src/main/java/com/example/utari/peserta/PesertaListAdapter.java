package com.example.utari.peserta;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class PesertaListAdapter extends RecyclerView.Adapter<PesertaListAdapter.PesertaHolder> {

    ArrayList<PesertaItem> daftarPeserta = new ArrayList<>();
    OnPesertaItemClicked clickHandler;

    public void setDaftarPeserta(ArrayList<PesertaItem> pesertapeserta){
        daftarPeserta = pesertapeserta;
        notifyDataSetChanged();
    }

    public void setDaftarPeserta(List<PesertaItem> pesertapeserta){
        daftarPeserta = new ArrayList<>(pesertapeserta);
        notifyDataSetChanged();
    }

    public void setClickHandler(OnPesertaItemClicked clickHandler) {
        this.clickHandler = clickHandler;
    }

    @NonNull
    @Override
    public PesertaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.peserta_row, viewGroup, false );
        return new PesertaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PesertaHolder pesertaHolder, int i) {
        PesertaItem pesertaItem = daftarPeserta.get(i);
        pesertaHolder.textNama.setText(pesertaItem.getNama());
        pesertaHolder.textInstansi.setText(
                String.valueOf(pesertaItem.getInstansi())
        );

        String url = "http://pendaftaran-sbmptn.herokuapp.com" + pesertaItem.getFoto();
        Glide.with(pesertaHolder.itemView)
                .load(url)
                .into(pesertaHolder.imgFoto);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PesertaHolder extends RecyclerView.ViewHolder{

        ImageView imgFoto;
        TextView textNama;
        TextView textInstansi;

        public PesertaHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.idIvFoto);
            textNama = itemView.findViewById(R.id.idTvNama);
            textInstansi = itemView.findViewById(R.id.idTvInstansi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PesertaItem pesertaItem = daftarPeserta.get(getAdapterPosition());
                    clickHandler.pesertaItemClicked(pesertaItem);
                }
            });
        }
    }

    public interface OnPesertaItemClicked{
        void pesertaItemClicked(PesertaItem pesertaItem);
    }
}
