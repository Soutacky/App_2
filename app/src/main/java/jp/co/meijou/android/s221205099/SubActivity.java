package jp.co.meijou.android.s221205099;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Optional;

import jp.co.meijou.android.s221205099.databinding.ActivityMain2Binding;
import jp.co.meijou.android.s221205099.databinding.ActivitySubBinding;

public class SubActivity extends AppCompatActivity {

    private ActivitySubBinding binding;
    private PrefDataStore prefDataStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Optional.ofNullable(getIntent().getStringExtra("text"))
                .ifPresent(text -> binding.textView.setText(text));

        binding.button5.setOnClickListener(view -> {
            var intent = new Intent();
            intent.putExtra("ret", "OK");
            setResult(RESULT_OK, intent);
            finish();
        });

        binding.button6.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }


}