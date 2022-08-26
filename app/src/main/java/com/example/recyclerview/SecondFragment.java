package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.recyclerview.data.CountryCovidData;
import com.example.recyclerview.data.GetCovidDataListFromJson;
import com.example.recyclerview.databinding.FragmentSecondBinding;

import java.io.Serializable;
import java.util.List;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private List<CountryCovidData> pegaDados;
    private int posicao;
    private List<CountryCovidData> ListaPaises;
    private Bundle bundle;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);

        bundle = getArguments();
        CountryCovidData dadosEnviados = (CountryCovidData) bundle.getSerializable("nomeDoPais");

        TextView tvNomePais = binding.textviewSecondNome;
        TextView tvCasosAtivos = binding.textviewSecondCasosAtivos;
        TextView tvUltimaAtualizacao = binding.textviewSecondUltimaAtualizacao;
        TextView tvNovosCasos = binding.textviewSecondNovosCasos;
        TextView tvNovasMortes = binding.textviewSecondNovasMortes;
        TextView tvCasosTotais = binding.textviewSecondCasosTotais;
        TextView tvMortesTotais = binding.textviewSecondMortesTotais;
        TextView tvRecuperadosTotais = binding.textviewSecondRecuperadosTotais;

        if(!dadosEnviados.getLastUpdate().equals("")){
            tvNomePais.setText(dadosEnviados.getCountryText());
        }else{
            binding.textviewSecondNome.setVisibility(View.GONE);
        }
        if (!dadosEnviados.getActiveCasesText().equals("")){
            tvCasosAtivos.setText("Casos ativos:\n"+dadosEnviados.getActiveCasesText());
        }else{
            binding.textviewSecondCasosAtivos.setVisibility(View.GONE);
        }
        if(!dadosEnviados.getLastUpdate().equals("")){
            tvUltimaAtualizacao.setText("Ultima atualização:\n"+dadosEnviados.getLastUpdate());
        }else{
            binding.textviewSecondUltimaAtualizacao.setVisibility(View.GONE);
        }
        if (!dadosEnviados.getNewCasesText().equals("")){
            tvNovosCasos.setText("Novos casos:\n"+dadosEnviados.getNewCasesText());
        }else{
            binding.textviewSecondNovosCasos.setVisibility(View.GONE);
        }
        if (!dadosEnviados.getNewDeathsText().equals("")){
            tvNovasMortes.setText("Novas mortes:\n"+dadosEnviados.getNewDeathsText());
        }else{
            binding.textviewSecondNovasMortes.setVisibility(View.GONE);
        }
        if (!dadosEnviados.getTotalCasesText().equals("")){
            tvCasosTotais.setText("Casos totais:\n"+dadosEnviados.getTotalCasesText());
        }else{
            binding.textviewSecondCasosTotais.setVisibility(View.GONE);
        }
        if (!dadosEnviados.getTotalDeathsText().equals("")){
            tvMortesTotais.setText("Mortes totais:\n"+dadosEnviados.getTotalDeathsText());
        }else{
            binding.textviewSecondMortesTotais.setVisibility(View.GONE);
        }
        if (!dadosEnviados.getTotalRecoveredText().equals("")){
            tvRecuperadosTotais.setText("Recuperados totais:\n"+dadosEnviados.getTotalRecoveredText());
        }else{
            binding.textviewSecondRecuperadosTotais.setVisibility(View.GONE);
        }
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}