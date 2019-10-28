package com.example.recycleview_losoweliczby;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.recycleview_losoweliczby.adapter.RecyclerView_Adapter;

public class MainActivity extends AppCompatActivity implements RecyclerView_Adapter.ItemClickListener{
    private Button button;
    private List<Integer> Itemvalue = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView_Adapter recyclerViewAdapter;

    private final int max = 100;
    private final int amount = 40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewAdapter = new RecyclerView_Adapter(this, Itemvalue);
        recyclerViewAdapter.setClickListener(this);

        genNumbers();
    }

    public void genNumbers() {
        for (int i = 0; i < amount; i++) {
            Random randomGen = new Random();

            int randomvalue = randomGen.nextInt(max) + 1; //Random value

            Itemvalue.add(randomvalue);
        }
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    public void random(View view) {
        Itemvalue.clear(); //Clear
        genNumbers();
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "Wybrano liczbę  " + recyclerViewAdapter.getItem(position), Toast.LENGTH_SHORT).show();
    }
}
