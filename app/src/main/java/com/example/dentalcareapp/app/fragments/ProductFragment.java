package com.example.dentalcareapp.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dentalcareapp.app.R;
import com.example.dentalcareapp.app.adapters.ProductAdapter;
import com.example.dentalcareapp.app.models.Product;
import com.example.dentalcareapp.app.utils.DummyData;
import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends Fragment {

    private RecyclerView productRecyclerView;
    private ProductAdapter adapter;
    private SearchView searchView;
    private List<Product> allProducts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        productRecyclerView = view.findViewById(R.id.productRecyclerView);
        searchView = view.findViewById(R.id.productSearchView);

        setupRecyclerView();
        setupSearchView();

        return view;
    }

    private void setupRecyclerView() {
        productRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        allProducts = DummyData.getProducts();
        adapter = new ProductAdapter(getContext(), allProducts);
        productRecyclerView.setAdapter(adapter);
    }

    private void setupSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterProducts(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterProducts(newText);
                return false;
            }
        });
    }

    private void filterProducts(String query) {
        List<Product> filteredList = new ArrayList<>();
        for (Product product : allProducts) {
            if (product.getName().toLowerCase().contains(query.toLowerCase()) ||
                    product.getCategory().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(product);
            }
        }
        adapter = new ProductAdapter(getContext(), filteredList);
        productRecyclerView.setAdapter(adapter);
    }
}