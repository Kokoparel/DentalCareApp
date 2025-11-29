package com.example.dentalcareapp.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dentalcareapp.app.R;
import com.example.dentalcareapp.app.utils.SharedPrefManager;

public class SignUpActivity extends AppCompatActivity {

    private EditText nameInput, emailInput, phoneInput, passwordInput, confirmPasswordInput;
    private Button signUpButton;
    private TextView loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initViews();
        setupListeners();
    }

    private void initViews() {
        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        phoneInput = findViewById(R.id.phoneInput);
        passwordInput = findViewById(R.id.passwordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        signUpButton = findViewById(R.id.signUpButton);
        loginLink = findViewById(R.id.loginLink);
    }

    private void setupListeners() {
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSignUp();
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void handleSignUp() {
        String name = nameInput.getText().toString().trim();
        String email = emailInput.getText().toString().trim();
        String phone = phoneInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();
        String confirmPassword = confirmPasswordInput.getText().toString().trim();

        if (name.isEmpty()) {
            nameInput.setError("Nama harus diisi");
            return;
        }

        if (email.isEmpty()) {
            emailInput.setError("Email harus diisi");
            return;
        }

        if (phone.isEmpty()) {
            phoneInput.setError("Nomor telepon harus diisi");
            return;
        }

        if (password.isEmpty()) {
            passwordInput.setError("Password harus diisi");
            return;
        }

        if (password.length() < 6) {
            passwordInput.setError("Password minimal 6 karakter");
            return;
        }

        if (!password.equals(confirmPassword)) {
            confirmPasswordInput.setError("Password tidak cocok");
            return;
        }

        // Dummy registration
        String userId = "USER" + System.currentTimeMillis();
        SharedPrefManager prefManager = SharedPrefManager.getInstance(this);
        prefManager.login(userId, name, email, password);

        Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}