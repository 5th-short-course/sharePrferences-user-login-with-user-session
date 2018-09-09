package com.example.androidhrd.local_storage_file_sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidhrd.local_storage_file_sqlite.data.local.repository.Database;
import com.example.androidhrd.local_storage_file_sqlite.data.local.repository.UserInMemoryRepository;
import com.example.androidhrd.local_storage_file_sqlite.entity.User;

public class RegisterActivity extends AppCompatActivity {
    private EditText userId, userName,userPassword;
    private TextView btnLogin;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userId=findViewById(R.id.id);
        userName=findViewById(R.id.name);
        userPassword=findViewById(R.id.password);
        btnLogin=findViewById(R.id.login);
        btnRegister=findViewById(R.id.btnRegister);

        // goto Login screen
        btnLogin.setOnClickListener(v->{
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        });

        //save user
        btnRegister.setOnClickListener(v->{
            // TODO: 09/09/2018
            //save data to storage
            User user =new User(
                    Integer.parseInt(userId.getText().toString()),
                    userName.getText().toString(),
                    userPassword.getText().toString()
            );
            //save data to user repository
            UserInMemoryRepository repository= Database.getUserInMemoryRepository();
            repository.save(user);
            //after create a user. go to login then.
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        });


    }
}
