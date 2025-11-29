package com.example.dentalcareapp.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dentalcareapp.app.R;
import com.example.dentalcareapp.app.utils.SharedPrefManager;

public class LoginActivity extends AppCompatActivity {

    private EditText emailInput, passwordInput;
    private Button loginButton;
    private TextView signUpLink, forgotPasswordLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Cek apakah user sudah login
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            navigateToMainActivity();
            return;
        }

        initViews();
        setupListeners();
    }

    private void initViews() {
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        signUpLink = findViewById(R.id.signUpLink);
        forgotPasswordLink = findViewById(R.id.forgotPasswordLink);
    }

    private void setupListeners() {
        loginButton.setOnClickListener(v -> handleLogin());

        signUpLink.setOnClickListener(v ->
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class))
        );

        forgotPasswordLink.setOnClickListener(v ->
                Toast.makeText(LoginActivity.this,
                        "Fitur reset password akan segera hadir", Toast.LENGTH_SHORT).show()
        );
    }

    private void handleLogin() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (email.isEmpty()) {
            emailInput.setError("Email harus diisi");
            return;
        }

        if (password.isEmpty()) {
            passwordInput.setError("Password harus diisi");
            return;
        }

        SharedPrefManager prefManager = SharedPrefManager.getInstance(this);

        // Cek apakah ada user yang sudah terdaftar
        String savedEmail = prefManager.getUserEmail();
        String savedPassword = prefManager.getUserPassword();

        Log.d("LoginActivity", "=== LOGIN DEBUG ===");
        Log.d("LoginActivity", "Input Email: " + email);
        Log.d("LoginActivity", "Input Password: " + password);
        Log.d("LoginActivity", "Saved Email: " + savedEmail);
        Log.d("LoginActivity", "Saved Password: " + savedPassword);
        Log.d("LoginActivity", "Email Match: " + (savedEmail != null && savedEmail.equals(email)));
        Log.d("LoginActivity", "Password Match: " + (savedPassword != null && savedPassword.equals(password)));
        Log.d("LoginActivity", "==================");


        // Login dengan akun yang terdaftar
        if (savedEmail != null && savedEmail.equals(email)) {
            if (savedPassword != null && savedPassword.equals(password)) {
                // Email dan password cocok
                Toast.makeText(this, "Login berhasil! Selamat datang kembali", Toast.LENGTH_SHORT).show();
                navigateToMainActivity();
                return;
            } else {
                // Email cocok tapi password salah
                Toast.makeText(this, "Password salah!", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        // Login dengan akun demo (fallback)
        if (email.equals("user@dental.com") && password.equals("123456")) {
            prefManager.login("USER001", "Demo User", email, password);
            Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show();
            navigateToMainActivity();
            return;
        }

        // Jika tidak cocok
        Toast.makeText(this, "Email tidak terdaftar. Silakan daftar terlebih dahulu.", Toast.LENGTH_LONG).show();
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}