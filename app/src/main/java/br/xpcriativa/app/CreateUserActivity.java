package br.xpcriativa.app;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreateUserActivity extends AppCompatActivity {

    private String email;
    private String password;
    private String password2;
    private DatabaseConnection dbWrite;
    private SQLiteDatabase dbRead;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);


        Button createUser = findViewById(R.id.buttonCreateUser);

        createUser.setOnClickListener(v -> {
            email = ((TextView) findViewById(R.id.editTextEmail_CreateUser)).getText().toString();
            password = ((TextView) findViewById(R.id.editTextFirstPassword_CreateUser)).getText().toString();
            password2 = ((TextView) findViewById(R.id.editTextSecondPassword_CreateUser)).getText().toString();

            User user = new User();
            dbRead = n
            if (!isPasswordEqual(password, password2))
                Toast.makeText(CreateUserActivity.this, "Senhas não coincidem", Toast.LENGTH_SHORT).show();
            else if (email.isEmpty() || password.isEmpty() || password2.isEmpty())
                Toast.makeText(CreateUserActivity.this, "Peencha todos os campos", Toast.LENGTH_SHORT).show();
            else if(logins.hasLogin(email))
                Toast.makeText(CreateAccountActivity.this, "Email já existe", Toast.LENGTH_SHORT).show();
            else{
                dbWrite = new DatabaseConnection(this);
                logins.insertLogin(email, password);
                Toast.makeText(CreateAccountActivity.this, "Conta criada com Sucesso", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, PostLoginActivity.class);
                startActivity(intent);
            }

            user.setEmail(email);
            user.setPassword(password);

        });




    }

    private boolean isPasswordEqual(String pwd, String pwd2){
        return pwd.equals(pwd2);
    }
}
