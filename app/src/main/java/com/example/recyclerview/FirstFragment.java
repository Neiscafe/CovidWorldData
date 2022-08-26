package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.data.CountryCovidData;
import com.example.recyclerview.data.GetCovidDataListFromJson;
import com.example.recyclerview.data.OnItemClickListener;
import com.example.recyclerview.databinding.FragmentFirstBinding;
import com.example.recyclerview.databinding.FragmentSecondBinding;

import java.io.Serializable;
import java.util.List;
import java.util.zip.Inflater;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private Adapter adapter;
    List<CountryCovidData> pegaDados;
    private OnItemClickListener onItemClickListener;


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
            public void click(CountryCovidData pais, int i) {;
                Toast.makeText(getContext().getApplicationContext(), "asdasdasdasdasdasd", Toast.LENGTH_SHORT).show();
                Fragment fragment = new SecondFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("nomeDoPais", (Serializable) pegaDados);
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