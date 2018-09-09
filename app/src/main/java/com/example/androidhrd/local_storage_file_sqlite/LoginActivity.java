package com.example.androidhrd.local_storage_file_sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidhrd.local_storage_file_sqlite.data.local.repository.Database;
import com.example.androidhrd.local_storage_file_sqlite.entity.User;
import com.example.androidhrd.local_storage_file_sqlite.util.UserPreferences;
import com.example.androidhrd.local_storage_file_sqlite.util.timer.AppTimeTask;

import java.util.List;
import java.util.Timer;

public class LoginActivity extends AppCompatActivity {

    private EditText userName,userPassword;
    private TextView btnRegister;
    private Button btnLogin;

    private static final String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName=findViewById(R.id.name);
        userPassword=findViewById(R.id.password);
        btnLogin=findViewById(R.id.btnLogin);
        btnRegister=findViewById(R.id.register);

        btnRegister.setOnClickListener(v->{
            startActivity(new Intent(this,RegisterActivity.class));
            finish();
        });

        btnLogin.setOnClickListener(v->{
            // TODO: 09/09/2018
            //1. get data for db
            // 2. data from use input
            User userInput=new User(
                    userName.getText().toString(),
                    userPassword.getText().toString()
            );

            //data from server site
            List<User> users= Database.getUserInMemoryRepository().getUsers();
            User userSession =null;
            for(User user: users){
                if(userInput.getName().equals(user.getName()) &&
                        userInput.getPassword().equals(user.getPassword())){
                    //save data to user Preferences or user sesesion
                    //Log.e(TAG, "onCreate: "+user);
                    userSession =user;
                    break;
                }
            }

            if(userSession!=null){
                Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
                UserPreferences.save(this,userSession);
                startActivity(new Intent(this,MainActivity.class));
                finish();
                //create timer
               /* new Timer("check-user-session").schedule(
                        new AppTimeTask(this),
                        10000
                );*/

            }else{
                Toast.makeText(this, "Login fail", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
