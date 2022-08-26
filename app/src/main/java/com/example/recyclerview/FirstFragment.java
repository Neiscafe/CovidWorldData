package com.example.recyclerview;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.data.CountryCovidData;
import com.example.recyclerview.data.GetCovidDataListFromJson;
import com.example.recyclerview.data.OnItemClickListener;
import com.example.recyclerview.databinding.FragmentFirstBinding;

import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private Adapter adapter;
    List<CountryCovidData> pegaDados;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        RecyclerView listaRecyclerView = realizaBinds(inflater, container);
        criaLista(listaRecyclerView);

        return binding.getRoot();

    }

    @NonNull
    private RecyclerView realizaBinds(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        RecyclerView listaRecyclerView = binding.listaPaisesFragmentFirst;
        return listaRecyclerView;
    }

    private void criaLista(RecyclerView listaRecyclerView) {
        criaLista();
        configuraAdapter(listaRecyclerView);
        configuraManager(listaRecyclerView);
    }

    private void configuraManager(RecyclerView listaRecyclerView) {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        listaRecyclerView.setLayoutManager(manager);
    }

    private void configuraAdapter(RecyclerView listaRecyclerView) {
        adapter = new Adapter(pegaDados, getContext());
        listaRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void click(CountryCovidData pais, int i) {
                ;
                Fragment fragment = new SecondFragment();
                Bundle bundle = new Bundle();
                CountryCovidData dados = pegaDados.get(i);
                Log.i(TAG, dados.toString());
                bundle.putSerializable("nomeDoPais", dados);
                fragment.setArguments(bundle);
                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
            }
        });
    }

    private void criaLista() {
        pegaDados = new GetCovidDataListFromJson().execute(getContext().getApplicationContext());
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}