package com.example.mobileweek9;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private MyCustomAdapter adapter;
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
        listView = findViewById(R.id.listView);
        itemList = FruitsFactory.getFruits();


        // Set the adapter
        adapter = new MyCustomAdapter(this, itemList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((a, b, position, d) -> procces_update(position));
    }

    private void procces_update(int position) {
        Intent intent = new Intent(this, ModifyFruit.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}