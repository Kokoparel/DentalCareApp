package com.example.dentalcareapp.app.utils;

import com.example.dentalcareapp.app.models.Product;
import java.util.ArrayList;
import java.util.List;

public class CartManager {
    // List statis: Bisa diakses dari mana saja tanpa new CartManager()
    private static List<Product> cartItems = new ArrayList<>();

    // Tambah barang ke keranjang
    public static void addToCart(Product product) {
        cartItems.add(product);
    }

    // Ambil semua barang di keranjang
    public static List<Product> getCartItems() {
        return cartItems;
    }

    // Hitung total harga belanjaan
    public static double getTotalPrice() {
        double total = 0;
        for (Product p : cartItems) {
            total += p.getPrice();
        }
        return total;
    }

    // Kosongkan keranjang (misal setelah bayar)
    public static void clearCart() {
        cartItems.clear();
    }
}