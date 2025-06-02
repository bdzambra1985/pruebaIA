package com.example.backpackstore;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button viewProductButton = findViewById(R.id.button_view_product_1);
        viewProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
                // We can pass data to ProductDetailActivity here if needed
                // For example: intent.putExtra("PRODUCT_ID", "backpack_alpha");
                startActivity(intent);
            }
        });
    }
}
