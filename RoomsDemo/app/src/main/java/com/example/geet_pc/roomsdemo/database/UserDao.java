package com.example.geet_pc.roomsdemo.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;
/**
 * Created by geet-pc on 11/4/18.
 */
@Dao
public interface UserDao {
    @Insert(onConflict = IGNORE)
    void insertUser(User user);

    @Query("select * from User")
    List<User> getUserlist();

    @Query("delete from User where firstname like :name OR lastname like :name")
    int deleteUsersByName(String name);

}
