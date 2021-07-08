package az.zero.simpleroom;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
abstract public class UserDatabase extends RoomDatabase {
    abstract public Dao userDao();
}