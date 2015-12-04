package com.nctu.nctuplus.nctuplus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        loginRestClientUsage = new LoginRestClientUsage(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_account, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
