package ir.shariaty.room1;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {MainData.class} , version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    // Create Database Instance
    private static  RoomDB database;

    //Define Database Name
    private static String DATABASE_NAME = "database";

    public synchronized static RoomDB getInstance(Context context){
        // Check Condition
        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext()
            , RoomDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }

    // Create DAO

    public abstract MainDao mainDao();

}
