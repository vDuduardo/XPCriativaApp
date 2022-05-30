package br.xpcriativa.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;

import br.xpcriativa.app.DAO.UserDAO;

public class LoginActivity extends Activity {

    private TextView createAccount;
    private TextView forgotPassword;
    private UserDAO userDAO;
    private boolean isBackPressed = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.buttonLogin);

        userDAO = new UserDAO(this);

        loginButton.setOnClickListener(v -> {
            String email = ((TextView) findViewById(R.id.textBoxEmailLogin)).getText().toString();
            String password = ((TextView) findViewById(R.id.passwordField)).getText().toString();

            if(email.isEmpty() || password.isEmpty())
                Toast.makeText(this, "Insira um login ou senha válidos", Toast.LENGTH_SHORT).show();
            else if(userDAO.isValidLogin(email, password)){
                Toast.makeText(this, "Login Bem Sucedido", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, PostLoginActivity.class));
            }
            else
                Toast.makeText(LoginActivity.this, "Email ou Senha Incorretos", Toast.LENGTH_SHORT).show();
        });

        createAccount = findViewById(R.id.textViewCreateAccount);
        try{
            createAccount.setOnClickListener(v -> {
                startActivity(new Intent(this, CreateUserActivity.class));
            });

        }catch(Exception e){
            System.out.println("EXCEPTION: " + e);
        }

        forgotPassword = findViewById(R.id.textViewRecoverAccount);

        forgotPassword.setOnClickListener(v -> startActivity(new Intent(this, ForgotPasswordActivity.class)));
    }

    @Override
    public void onBackPressed() {
        if(isBackPressed){
            super.onBackPressed();
            finish();
        }
        Toast.makeText(this, "Pressione novamente para sair", Toast.LENGTH_SHORT).show();
        isBackPressed = true;

        new Handler(Looper.getMainLooper()).postDelayed(() -> isBackPressed = false, 2000);
    }
}
