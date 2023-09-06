package jp.co.meijou.android.s221205099;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import jp.co.meijou.android.s221205099.databinding.ActivityMain2Binding;
import jp.co.meijou.android.s221205099.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;
    private PrefDataStore prefDataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //binding.textView4.setVisibility(View.GONE);
    }
}