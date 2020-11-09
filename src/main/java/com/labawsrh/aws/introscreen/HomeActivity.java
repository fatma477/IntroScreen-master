package com.labawsrh.aws.introscreen;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.support.annotation.NonNull;
import android.widget.Switch;
import android.widget.Toast;




public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
                switch (Item.getItemId()) {
                    case R.id.action_recents:
                        Toast.makeText(HomeActivity.this, "noussa", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_favorites:
                        Toast.makeText(HomeActivity.this, "brain", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_nearby:
                        Toast.makeText(HomeActivity.this, "wiwi", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
    public void OnReserve(View view) {
        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
        startActivity(intent);
    }
    public void OnProfil(View view) {
        Intent intent = new Intent(getApplicationContext(), Profil.class);
        startActivity(intent);
    }
}
