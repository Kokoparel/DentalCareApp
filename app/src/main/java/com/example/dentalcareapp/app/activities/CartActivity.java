package com.example.dentalcareapp.app.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dentalcareapp.app.R;
import com.example.dentalcareapp.app.adapters.CartAdapter;
import com.example.dentalcareapp.app.utils.CartManager;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView totalPriceText, emptyText;
    private Button btnCheckout;
    private CartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initViews();
        setupRecyclerView();
        updateTotalPrice();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.cartRecyclerView);
        totalPriceText = findViewById(R.id.totalPriceText);
        emptyText = findViewById(R.id.emptyText);
        btnCheckout = findViewById(R.id.btnCheckout);

        btnCheckout.setOnClickListener(v -> {
            if (CartManager.getCartItems().isEmpty()) {
                Toast.makeText(this, "Keranjang kosong!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Checkout Berhasil!", Toast.LENGTH_LONG).show();
                CartManager.clearCart(); // Kosongkan
                finish(); // Tutup halaman
            }
        });
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Cek kosong atau tidak
        if (CartManager.getCartItems().isEmpty()) {
            emptyText.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            emptyText.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }

        // Pasang Adapter
        adapter = new CartAdapter(this, CartManager.getCartItems(), new Runnable() {
            @Override
            public void run() {
                updateTotalPrice(); // Update harga saat ada item dihapus
                if (CartManager.getCartItems().isEmpty()) {
                    emptyText.setVisibility(View.VISIBLE);
                }
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void updateTotalPrice() {
        double total = CartManager.getTotalPrice();
        totalPriceText.setText("Rp " + String.format("%,.0f", total));
    }
}