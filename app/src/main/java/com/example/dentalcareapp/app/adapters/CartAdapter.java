package com.example.dentalcareapp.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dentalcareapp.app.R;
import com.example.dentalcareapp.app.models.Product;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private Context context;
    private List<Product> cartItems;
    private Runnable onCartChangedListener; // Agar Activity tahu kalau ada harga berubah

    public CartAdapter(Context context, List<Product> cartItems, Runnable onCartChangedListener) {
        this.context = context;
        this.cartItems = cartItems;
        this.onCartChangedListener = onCartChangedListener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Product product = cartItems.get(position);

        holder.name.setText(product.getName());
        holder.price.setText(product.getFormattedPrice());
        holder.image.setImageResource(R.mipmap.ic_launcher);

        // Logic Tombol Hapus
        holder.btnRemove.setOnClickListener(v -> {
            cartItems.remove(position); // Hapus dari list
            notifyItemRemoved(position); // Hapus animasinya
            notifyItemRangeChanged(position, cartItems.size()); // Rapikan urutan

            // Hitung ulang total harga di Activity
            if (onCartChangedListener != null) {
                onCartChangedListener.run();
            }

            Toast.makeText(context, "Dihapus dari keranjang", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, price;
        ImageButton btnRemove;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.cartItemImage);
            name = itemView.findViewById(R.id.cartItemName);
            price = itemView.findViewById(R.id.cartItemPrice);
            btnRemove = itemView.findViewById(R.id.btnRemove);
        }
    }
}