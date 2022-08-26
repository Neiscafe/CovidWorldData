package com.example.recyclerview;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.recyclerview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); //pega o LayoutInflater da
        // ActivityMain, para poder bindar os fragments
        setContentView(binding.getRoot());//seta a view referenciando a view raiz de binding

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        //inicializa o nav que vai trocar entre firstfragment e secondfragment
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        //instancia um appBarConfiguration para colocar no navController
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //implementa o appBarConfiguration e o nav
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}