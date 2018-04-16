package com.example.geet_pc.roomsdemo.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;
import java.util.Date;

/**
 * Created by geet-pc on 11/4/18.
 */
@Entity(indices = {@Index(value = "firstname",unique = true)}) // check user first name is not repeat.
@TypeConverters(DateConverter.class)
public class User {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;
    public String firstname;
    public String lastname;
    public Date date;
    public String mobile;
}
