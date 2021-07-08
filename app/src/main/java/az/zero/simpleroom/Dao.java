package az.zero.simpleroom;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Query("SELECT * FROM user ORDER BY id")
    List<User> getUser();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

}
