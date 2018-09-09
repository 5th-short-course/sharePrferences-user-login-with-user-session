package com.example.androidhrd.local_storage_file_sqlite.data.local.repository;

import com.example.androidhrd.local_storage_file_sqlite.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserInMemoryRepository {

    List<User> users;
    public UserInMemoryRepository(){
        users=new ArrayList<>();
        users.add(new User(1,"admin","admin"));
    }

    public  void save(User user){
        users.add(user);
    }

    public User getUser(int id){
        for(User user: users){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return users;
    }
}
