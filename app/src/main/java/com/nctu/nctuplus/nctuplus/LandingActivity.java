package com.nctu.nctuplus.nctuplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.nctu.nctuplus.nctuplus.api.LoginRestClientUsage;


public class LandingActivity extends AppCompatActivity {
    private EditText accountEditText, passwordEditText;
    private Button loginSubmitBtn;
    private LoginRestClientUsage loginRestClientUsage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        findViews();
        loginRestClientUsage = new LoginRestClientUsage(this, new LoginRestClientUsage.LoginListener() {
            @Override
            public void afterSuccess() {
                startActivity(new Intent(LandingActivity.this,AccountActivity.class));
            }
        });
        loginSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginRestClientUsage.postUser(accountEditText.getText().toString(), passwordEditText.getText().toString());
            }
        });
    }

    private void findViews() {
        accountEditText = (EditText) findViewById(R.id.e3_account);
        passwordEditText = (EditText) findViewById(R.id.e3_password);
        loginSubmitBtn = (Button) findViewById(R.id.login_submit);
    }
}
