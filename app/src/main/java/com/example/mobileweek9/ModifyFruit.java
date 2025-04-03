package com.example.mobileweek9;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ModifyFruit extends AppCompatActivity {
    private EditText et_keybenefit;
    private int position;
    private Fruit fruit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_modify_fruit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        et_keybenefit = findViewById(R.id.et_keybenefit);

        position = getIntent().getIntExtra("position", -1);
        if (position != -1) {
            fruit = MainActivity.itemList.get(position);
            et_keybenefit.setText(fruit.getKeyBenefit());
            TextView tv_keybenefit = findViewById(R.id.tv_keybenefit);
            tv_keybenefit.setText("Key Benefit of "+fruit.getName());
        }

    }

    public void update(View v)
    {
        fruit.setKeyBenefit(et_keybenefit.getText().toString());
        finish();
    }
}