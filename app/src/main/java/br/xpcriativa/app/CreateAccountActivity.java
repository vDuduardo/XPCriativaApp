package br.xpcriativa.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

public class CreateAccountActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Button createAccountButton = findViewById(R.id.buttonCreateAccount);

        createAccountButton.setOnClickListener(v -> {

        });
    }
}
