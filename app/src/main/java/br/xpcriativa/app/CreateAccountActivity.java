package br.xpcriativa.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import br.xpcriativa.app.database.Accounts;

public class CreateAccountActivity extends Activity {

    private TextView signIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Accounts logins = new Accounts();
        Button createAccountButton = findViewById(R.id.buttonCreateAccount);

        createAccountButton.setOnClickListener(v -> {
            String email = ((TextView) findViewById(R.id.textBoxEmailCreateAccount)).getText().toString();
            String password = ((TextView) findViewById(R.id.passwordFieldCreateAccount)).getText().toString();
            String password2 = ((TextView) findViewById(R.id.passwordFieldCreateAccount2)).getText().toString();

            if (!isPasswordEqual(password, password2))
                Toast.makeText(CreateAccountActivity.this, "Senhas não coincidem", Toast.LENGTH_SHORT).show();
            else if (email.isEmpty() || password.isEmpty() || password2.isEmpty())
                Toast.makeText(CreateAccountActivity.this, "Peencha todos os campos", Toast.LENGTH_SHORT).show();
            else if(logins.hasLogin(email))
                Toast.makeText(CreateAccountActivity.this, "Email já existe", Toast.LENGTH_SHORT).show();
            else{
                logins.insertLogin(email, password);
                Toast.makeText(CreateAccountActivity.this, "Conta criada com Sucesso", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, PostLoginActivity.class);
                startActivity(intent);
            }

            signIn = findViewById(R.id.textViewDoLogin);

            signIn.setOnClickListener(v1 -> {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            });
        });
    }

    private boolean isPasswordEqual(String pwd, String pwd2){
        return pwd.equals(pwd2);
    }
}
