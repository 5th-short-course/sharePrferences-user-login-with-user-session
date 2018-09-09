package com.example.androidhrd.local_storage_file_sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.androidhrd.local_storage_file_sqlite.entity.User;
import com.example.androidhrd.local_storage_file_sqlite.util.UserPreferences;
import com.example.androidhrd.local_storage_file_sqlite.util.timer.AppTimeTask;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogout=findViewById(R.id.logout);

        //check user session
        /*if(!UserPreferences.isLogin(this)){
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        }*/

        //release user session
        new Timer("check-user-session").schedule(
                new AppTimeTask(this),
                10000
        );

        if(UserPreferences.getUser(this).getId()==0){
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        }

        btnLogout.setOnClickListener(v->{
            UserPreferences.remove(this);
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        });
    }
}
