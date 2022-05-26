package br.xpcriativa.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import java.util.HashMap;

import br.xpcriativa.app.database.Accounts;

public class LoginActivity extends Activity {


    private TextView createAccount;
    private TextView forgotPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Accounts logins = new Accounts();
        Button loginButton = findViewById(R.id.buttonLogin);

        loginButton.setOnClickListener(v -> {
            String email = ((TextView) findViewById(R.id.textBoxEmailLogin)).getText().toString();
            String password = ((TextView) findViewById(R.id.passwordField)).getText().toString();

            if(email.isEmpty() || password.isEmpty())
                Toast.makeText(LoginActivity.this, "Insira um login ou senha válidos", Toast.LENGTH_SHORT).show();
            else if(logins.isValidLogin(email, password)){
                Toast.makeText(LoginActivity.this, "Login Bem Sucedido", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, PostLoginActivity.class);
                startActivity(intent);
            }
            else
                Toast.makeText(LoginActivity.this, "Email ou Senha Incorretos", Toast.LENGTH_SHORT).show();
        });

        createAccount = findViewById(R.id.textViewCreateAccount);

        createAccount.setOnClickListener(v -> {
            Intent intent = new Intent(this, CreateAccountActivity.class);
            startActivity(intent);
        });

        forgotPassword = findViewById(R.id.textViewRecoverAccount);

        forgotPassword.setOnClickListener(v -> {
            Intent intent = new Intent(this, ForgotPasswordActivity.class);
            startActivity(intent);
        });
    }
}
