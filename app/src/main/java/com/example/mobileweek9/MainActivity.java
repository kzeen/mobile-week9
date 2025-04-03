package com.example.mobileweek9;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter adapter;
    public static List<Fruit> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView tv = new TextView(this);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.recyclerView);
        itemList = FruitsFactory.getFruits();


        // Set the adapter
        adapter = new MyRecyclerViewAdapter(this, itemList);
        recyclerView.setAdapter(adapter);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE)
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        else
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}