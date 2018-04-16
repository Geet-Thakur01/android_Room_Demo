package com.example.geet_pc.roomsdemo.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by geet-pc on 11/4/18.
 */
@Database(entities = User.class,version = 1)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase INSTANCE;
    public abstract UserDao userModel();

    public static AppDataBase getInMemoryDatabase(Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context,AppDataBase.class,"demodatabase")
                    // To simplify the codelab, allow queries on the main thread.
                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                    .allowMainThreadQueries()
//                    .addMigrations(MIGRATION_1_2)
//                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
//    static final Migration MIGRATION_1_2=new Migration(1,2) {
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            database.execSQL("ALTER TABLE User "
//                    + " ADD COLUMN mobile TEXT");
//        }
//    };
}
