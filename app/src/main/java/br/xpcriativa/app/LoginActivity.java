package br.xpcriativa.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class LoginActivity extends Activity {

    HashMap<String, String> logins = new HashMap<>();
    private TextView createAccout;
    private TextView forgotPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        createLogins();
        Button loginButton = (Button) findViewById(R.id.buttonLogin);

        loginButton.setOnClickListener(v -> {
            String email = ((TextView) findViewById(R.id.textBoxEmailLogin)).getText().toString();
            String password = ((TextView) findViewById(R.id.passwordField)).getText().toString();
            String pwd = logins.getOrDefault(email, "");

            if(email.isEmpty() || password.isEmpty())
                Toast.makeText(LoginActivity.this, "Insira um login ou senha válidos", Toast.LENGTH_SHORT).show();
            else if(logins.containsKey(email) && password.equals(pwd)){
                Toast.makeText(LoginActivity.this, "Login Bem Sucedido", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            else
                Toast.makeText(LoginActivity.this, "Email ou Senha Incorretos", Toast.LENGTH_SHORT).show();
        });

        createAccout = findViewById(R.id.textViewCreateAccount);

        createAccout.setOnClickListener(v -> {
//            Intent intent = new Intent(this, CreateAccountActivity.class);
            Toast.makeText(LoginActivity.this, "Ainda n tem tela de criar conta", Toast.LENGTH_SHORT).show();
        });

        forgotPassword = findViewById(R.id.textViewRecoverAccount);

        forgotPassword.setOnClickListener(v -> {
//            Intent intent = new Intent(this, CreateAccountActivity.class);
            Toast.makeText(LoginActivity.this, "Ainda n tem tela de recuperar senha", Toast.LENGTH_SHORT).show();
        });


    }

    private void createLogins(){
        logins.put("felipe@gmail.com", "123");
        logins.put("dudu@gmail.com", "123");
        logins.put("ulissera@gmail.com", "123");
        logins.put("marco@gmail.com", "123");
        logins.put("adm", "adm");
    }
}
