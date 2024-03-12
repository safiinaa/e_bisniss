package com.example.e_binis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.e_binis.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        int[] imageList = {R.drawable.kripca, R.drawable.basreng, R.drawable.kerupuk};
        int[] deskripsilist = {R.string.Kripca, R.string.Basreng,R.string.kerupuk};
        int[] alamatlist = {R.string.alamat1, R.string.alamat2, R.string.alamat3};
        int[] caraorder = {R.string.caraorder1, R.string.caraorder2,R.string.caraorder3};
        String[] nameList = {"Kripik Kaca", "Baso Goreng", "Kerupuk seblak"};
        for (int i = 0; i < imageList.length; i++){
            listData = new ListData(nameList[i], alamatlist[i], deskripsilist[i], imageList[i], caraorder[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(MainActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Activity_detail.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("image", imageList[i]);
                intent.putExtra("deskripsi", deskripsilist[i]);
                intent.putExtra("alamat", alamatlist[i]);
                intent.putExtra("caraorder", caraorder[i]);
                startActivity(intent);
            }
        });
    }
}