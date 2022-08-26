package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.data.CountryCovidData;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.PaisViewHolder> {
    private final Context context;
    List<CountryCovidData> listaDePaises;

    public Adapter(List<CountryCovidData> listaDePaises, Context context) {
        this.listaDePaises = listaDePaises;
        this.context = context;
    }

    @NonNull
    @Override
    public PaisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_lista_paises, parent, false);
        return new PaisViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull PaisViewHolder holder, int position) {
        CountryCovidData pais = listaDePaises.get(position);
        holder.inclui(pais);
    }

    @Override
    public int getItemCount() {
        return listaDePaises.size();
    }

    class PaisViewHolder extends RecyclerView.ViewHolder{

        private final TextView nome;
        private CountryCovidData pais;

        public PaisViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.tv_nome_pais_item);
        }
        public void inclui(CountryCovidData pais){
            this.pais = pais;
            nome.setText(pais.getCountryText());
        }
    }
}
