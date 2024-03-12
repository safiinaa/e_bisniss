package com.example.e_binis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.e_binis.databinding.ActivityDetailBinding;

public class Activity_detail extends AppCompatActivity {

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            String alamat = intent.getStringExtra("alamat");
            String desktipsi = intent.getStringExtra("deskripsi");
            String caraorder = intent.getStringExtra("caraorder");
            int image = intent.getIntExtra("image", R.drawable.kripca);
            binding.detailName.setText(name);
            binding.deskripsi.setText(desktipsi);
            binding.alamat.setText(alamat);
            binding.caraorder.setText(caraorder);
            binding.detailImage.setImageResource(image);
        }
    }
}