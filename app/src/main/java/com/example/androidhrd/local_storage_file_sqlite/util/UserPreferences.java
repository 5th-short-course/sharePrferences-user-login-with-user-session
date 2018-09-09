package com.example.androidhrd.local_storage_file_sqlite.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.androidhrd.local_storage_file_sqlite.entity.User;

public class UserPreferences {
    private static final String ID="ID";
    private static final String NAME="NAME";
    private static final String PASSWORD="PASSWORD";

    private static final String USER_PREFERENCES="USER_PREFERENCES";

    private static SharedPreferences getPreferences(Context context){
        return context.getSharedPreferences(USER_PREFERENCES,Context.MODE_PRIVATE);
    }
    public static void save(Context context, User user){
        SharedPreferences.Editor editor=getPreferences(context).edit();
        editor.putInt(ID,user.getId());
        editor.putString(NAME,user.getName());
        editor.putString(PASSWORD,user.getPassword());
        editor.commit();
    }

    public static User getUser(Context context){
        SharedPreferences preferences=getPreferences(context);
        User user =new User(preferences.getInt(ID,0),
                preferences.getString(NAME,null),
                preferences.getString(PASSWORD,null));
        return user;
    }

    public static void remove(Context context){
        SharedPreferences.Editor editor= getPreferences(context).edit();
        editor.putInt(ID,0);
        editor.putString(NAME,null);
        editor.putString(PASSWORD,null);
        editor.commit();
    }

    public static boolean isLogin(Context context){
        SharedPreferences preferences=getPreferences(context);
        if(preferences.getInt(ID,0)>=0){
            return false;
        }else
            return true;
    }
}