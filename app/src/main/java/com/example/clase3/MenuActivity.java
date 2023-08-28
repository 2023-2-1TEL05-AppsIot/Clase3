package com.example.clase3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.clase3.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {

    ActivityMenuBinding binding;
    public static String TAG = "msg-test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(view -> {
            Log.d(TAG,"clic en botón");
        });

        binding.imageView.setOnClickListener(view -> {
            Log.d(TAG,"clic en imageview");
        });


    }
}