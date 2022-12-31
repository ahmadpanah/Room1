package ir.shariaty.room1;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;


@Dao
public interface MainDao {
    // Insert Query
    @Insert(onConflict = REPLACE)
    void insert(MainData mainData);

    // Delete Query
    @Delete
    void delete (MainData mainData);

    // Delete All Query
    @Delete
    void reset(List<MainData> mainData);

    //Update Query
    @Query("UPDATE contact SET text = :sText WHERE ID = :sID")
    void update(int sID, String sText);

    //Get All Data Query
    @Query("SELECT * FROM contact")
    List<MainData> getAll();
}
