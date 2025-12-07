package com.example.dentalcareapp.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dentalcareapp.app.R;
import com.example.dentalcareapp.app.adapters.ProductAdapter;
import com.example.dentalcareapp.app.utils.DummyData;

public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // PASTIKAN NAMA XML INI SESUAI DENGAN TEMPAT KAMU NARUH TOMBOL MELAYANG TADI
        // Kalau kamu naruh tombolnya di 'fragment_product.xml', biarkan ini:
        setContentView(R.layout.fragment_product);

        // 1. Setup RecyclerView
        RecyclerView recyclerView = findViewById(R.id.productRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProductAdapter adapter = new ProductAdapter(this, DummyData.getProducts());
        recyclerView.setAdapter(adapter);

        // 2. Logic Tombol Keranjang (Melayang)
        ImageButton btnCart = findViewById(R.id.btnCart);

        if (btnCart != null) {
            btnCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ShopActivity.this, "Membuka Keranjang...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ShopActivity.this, CartActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}