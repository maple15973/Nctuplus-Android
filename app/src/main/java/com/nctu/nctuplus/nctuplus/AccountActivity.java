package com.nctu.nctuplus.nctuplus;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;


public class AccountActivity extends BaseActivity {
    private UserPreference userPreference;
    private TextView accountTextView,emailTextView;
    private ImageView profileImage;
    private Button webButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        userPreference = new UserPreference(this);
        findViews();
        setViews();
    }

    private void setViews() {
        accountTextView.setText(userPreference.getName());
        emailTextView.setText(userPreference.getEmail());
        Picasso.with(this).load("https://graph.facebook.com/"+userPreference.getFbId()+"/picture?type=large").
                placeholder(getResources().getDrawable(android.R.drawable.ic_btn_speak_now)).into(profileImage);
    }

    private void findViews() {
        accountTextView =(TextView)findViewById(R.id.account_name);
        emailTextView =(TextView)findViewById(R.id.account_email);
        profileImage = (ImageView)findViewById(R.id.account_image);
        webButton =(Button)findViewById(R.id.web_btn);
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(new Intent(AccountActivity.this,WebActivity.class));
            }
        });
    }
}
