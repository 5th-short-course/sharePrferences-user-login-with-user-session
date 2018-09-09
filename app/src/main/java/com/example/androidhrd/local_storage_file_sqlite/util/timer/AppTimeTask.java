package com.example.androidhrd.local_storage_file_sqlite.util.timer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.androidhrd.local_storage_file_sqlite.LoginActivity;
import com.example.androidhrd.local_storage_file_sqlite.util.UserPreferences;

import java.util.TimerTask;

public class AppTimeTask extends TimerTask{

    private AppCompatActivity activity;
    public AppTimeTask(AppCompatActivity activity){
        this.activity=activity;
    }

    @Override
    public void run() {
        UserPreferences.remove(activity);
        activity.startActivity(new Intent(activity, LoginActivity.class));
        activity.finish();
    }

    public interface DisableCurrentScreen{
        void finishScreen();
    }
}
