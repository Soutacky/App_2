package jp.co.meijou.android.s221205099;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import jp.co.meijou.android.s221205099.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PrefDataStore prefDataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}