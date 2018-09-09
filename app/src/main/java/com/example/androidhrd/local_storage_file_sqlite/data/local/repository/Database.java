package com.example.androidhrd.local_storage_file_sqlite.data.local.repository;

public class Database {

    private static UserInMemoryRepository repository;
    public static  UserInMemoryRepository getUserInMemoryRepository(){
        if(repository==null)
            repository=new UserInMemoryRepository();
        return repository;
    }


}
