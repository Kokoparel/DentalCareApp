package com.example.dentalcareapp.app.activities;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dentalcareapp.app.R;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail); // Sesuai nama XML detail produk kamu

        // 1. Inisialisasi View
        TextView nameTxt = findViewById(R.id.detailName);
        TextView priceTxt = findViewById(R.id.detailPrice);
        TextView catTxt = findViewById(R.id.detailCategory);
        TextView descTxt = findViewById(R.id.detailDesc);
        Button btnBuy = findViewById(R.id.btnBuy);

        // 2. Tangkap Data dari Adapter
        String name = getIntent().getStringExtra("p_name");
        String price = getIntent().getStringExtra("p_price");
        String category = getIntent().getStringExtra("p_category");
        String desc = getIntent().getStringExtra("p_desc");

        // 3. Tampilkan Data
        nameTxt.setText(name);
        priceTxt.setText(price);
        catTxt.setText(category);

        if (desc != null) {
            descTxt.setText(desc);
        } else {
            descTxt.setText("Deskripsi produk belum tersedia.");
        }

        // 4. Aksi Tombol Beli
        findViewById(R.id.btnBuy).setOnClickListener(v -> {
            // 1. Bersihkan harga
            double hargaAsli = 0;
            try {
                String cleanPrice = price.replace("Rp ", "").replace(".", "").replace(",", ".");
                hargaAsli = Double.parseDouble(cleanPrice);
            } catch (Exception e) {
                hargaAsli = 0;
            }

            float ratingAsli = getIntent().getFloatExtra("p_rating", 0f);

            // 2. Buat Produk Baru & Masukkan ke CartManager
            com.example.dentalcareapp.app.models.Product barang = new com.example.dentalcareapp.app.models.Product(
                    "", name, category, hargaAsli, ratingAsli, ""
            );
            com.example.dentalcareapp.app.utils.CartManager.addToCart(barang);

            // 3. Beri info singkat
            Toast.makeText(this, "Produk ditambahkan!", Toast.LENGTH_SHORT).show();

            // --- PERUBAHAN DI SINI ---
            // Jangan cuma finish(), tapi Pindah ke CartActivity!
            android.content.Intent intent = new android.content.Intent(ProductDetailActivity.this, CartActivity.class);
            startActivity(intent);

            // Opsional: Tutup halaman detail agar pas di-back dari keranjang langsung ke Toko
            finish();
        });
    }
}