package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.recyclerview.data.CountryCovidData;
import com.example.recyclerview.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private Bundle bundle;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);

        bundle = getArguments();
        CountryCovidData dadosEnviados = (CountryCovidData) bundle.getSerializable("nomeDoPais");


        inicializacaoDeCampos(dadosEnviados);

        return binding.getRoot();

    }

    private void inicializacaoDeCampos(CountryCovidData dadosEnviados) {

        TextView tvNomePais = binding.textviewSecondNome;
        TextView tvCasosAtivos = binding.textviewSecondCasosAtivos;
        TextView tvUltimaAtualizacao = binding.textviewSecondUltimaAtualizacao;
        TextView tvNovosCasos = binding.textviewSecondNovosCasos;
        TextView tvNovasMortes = binding.textviewSecondNovasMortes;
        TextView tvCasosTotais = binding.textviewSecondCasosTotais;
        TextView tvMortesTotais = binding.textviewSecondMortesTotais;
        TextView tvRecuperadosTotais = binding.textviewSecondRecuperadosTotais;

        if (dadosEnviados.getCountryText() != null && !dadosEnviados.getCountryText().equals("")) {
            tvNomePais.setText(dadosEnviados.getCountryText());
        } else {
            binding.textviewSecondNome.setVisibility(View.GONE);
        }
        if (dadosEnviados.getActiveCasesText() != null && !dadosEnviados.getActiveCasesText().equals("")) {
            tvCasosAtivos.setText("Casos ativos:\n" + dadosEnviados.getActiveCasesText());
        } else {
            binding.textviewSecondCasosAtivos.setVisibility(View.GONE);
        }
        if (dadosEnviados.getLastUpdate() != null && !dadosEnviados.getLastUpdate().equals("")) {
            tvUltimaAtualizacao.setText("Ultima atualização:\n" + dadosEnviados.getLastUpdate());
        } else {
            binding.textviewSecondUltimaAtualizacao.setVisibility(View.GONE);
        }
        if (dadosEnviados.getNewCasesText() != null && !dadosEnviados.getNewCasesText().equals("")) {
            tvNovosCasos.setText("Novos casos:\n" + dadosEnviados.getNewCasesText());
        } else {
            binding.textviewSecondNovosCasos.setVisibility(View.GONE);
        }
        if (dadosEnviados.getNewDeathsText() != null && !dadosEnviados.getNewDeathsText().equals("")) {
            tvNovasMortes.setText("Novas mortes:\n" + dadosEnviados.getNewDeathsText());
        } else {
            binding.textviewSecondNovasMortes.setVisibility(View.GONE);
        }
        if (dadosEnviados.getTotalCasesText() != null && !dadosEnviados.getTotalCasesText().equals("")) {
            tvCasosTotais.setText("Casos totais:\n" + dadosEnviados.getTotalCasesText());
        } else {
            binding.textviewSecondCasosTotais.setVisibility(View.GONE);
        }
        if (dadosEnviados.getTotalDeathsText() != null && !dadosEnviados.getTotalDeathsText().equals("")) {
            tvMortesTotais.setText("Mortes totais:\n" + dadosEnviados.getTotalDeathsText());
        } else {
            binding.textviewSecondMortesTotais.setVisibility(View.GONE);
        }
        if (dadosEnviados.getTotalRecoveredText() != null && !dadosEnviados.getTotalRecoveredText().equals("")) {
            tvRecuperadosTotais.setText("Recuperados totais:\n" + dadosEnviados.getTotalRecoveredText());
        } else {
            binding.textviewSecondRecuperadosTotais.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}