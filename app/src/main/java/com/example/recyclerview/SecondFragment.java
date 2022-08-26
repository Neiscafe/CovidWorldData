package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

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

        if (!dadosEnviados.getLastUpdate().equals("") && dadosEnviados.getLastUpdate()!=null) {
            tvNomePais.setText(dadosEnviados.getCountryText());
        } else {
            binding.textviewSecondNome.setVisibility(View.GONE);
        }
        if (!dadosEnviados.getActiveCasesText().equals("") && dadosEnviados.getActiveCasesText()!=null) {
            tvCasosAtivos.setText("Casos ativos:\n" + dadosEnviados.getActiveCasesText());
        } else {
            binding.textviewSecondCasosAtivos.setVisibility(View.GONE);
        }
        if (!dadosEnviados.getLastUpdate().equals("")&& dadosEnviados.getLastUpdate()!=null) {
            tvUltimaAtualizacao.setText("Ultima atualização:\n" + dadosEnviados.getLastUpdate());
        } else {
            binding.textviewSecondUltimaAtualizacao.setVisibility(View.GONE);
        }
        if (!dadosEnviados.getNewCasesText().equals("")&& dadosEnviados.getNewCasesText()!=null) {
            tvNovosCasos.setText("Novos casos:\n" + dadosEnviados.getNewCasesText());
        } else {
            binding.textviewSecondNovosCasos.setVisibility(View.GONE);
        }
        if (!dadosEnviados.getNewDeathsText().equals("")&& dadosEnviados.getNewDeathsText()!=null) {
            tvNovasMortes.setText("Novas mortes:\n" + dadosEnviados.getNewDeathsText());
        } else {
            binding.textviewSecondNovasMortes.setVisibility(View.GONE);
        }
        if (!dadosEnviados.getTotalCasesText().equals("")&& dadosEnviados.getTotalCasesText()!=null) {
            tvCasosTotais.setText("Casos totais:\n" + dadosEnviados.getTotalCasesText());
        } else {
            binding.textviewSecondCasosTotais.setVisibility(View.GONE);
        }
        if (!dadosEnviados.getTotalDeathsText().equals("")&& dadosEnviados.getTotalDeathsText()!=null) {
            tvMortesTotais.setText("Mortes totais:\n" + dadosEnviados.getTotalDeathsText());
        } else {
            binding.textviewSecondMortesTotais.setVisibility(View.GONE);
        }
        if (!dadosEnviados.getTotalRecoveredText().equals("")&& dadosEnviados.getTotalRecoveredText()!=null) {
            tvRecuperadosTotais.setText("Recuperados totais:\n" + dadosEnviados.getTotalRecoveredText());
        } else {
            binding.textviewSecondRecuperadosTotais.setVisibility(View.GONE);
        }
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