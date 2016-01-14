package com.nctu.nctuplus.nctuplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by cober on 2015/12/5.
 */
public class BaseActivity extends AppCompatActivity {
    protected final String LOG_TAG=getClass().getSimpleName();
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            new UserPreference(this).clearAll();
            startActivity(new Intent(BaseActivity.this, LandingActivity.class));
            this.finish();
            return true;
        }
        if (id == R.id.action_current_course) {
            startActivity(new Intent(BaseActivity.this, RollCallActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
