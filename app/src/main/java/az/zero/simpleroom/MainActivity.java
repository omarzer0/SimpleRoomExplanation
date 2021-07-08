package az.zero.simpleroom;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String DATABASE_NAME = "user_db";

    TextView textView;
    Button buttonAdd, buttonShow, buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv_text);
        buttonAdd = findViewById(R.id.btn_button_add);
        buttonShow = findViewById(R.id.btn_button_show);
        buttonDelete = findViewById(R.id.btn_button_delete);

        UserDatabase database = Room.databaseBuilder(getApplicationContext(),
                UserDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries()
                .build();


        buttonAdd.setOnClickListener(v -> {
            User user = new User("abdo\t", "khaled");
            database.userDao().insertUser(user);
        });


        buttonDelete.setOnClickListener(v -> {
            database.userDao().deleteUser(new User(2, "abdo", "khaled"));
        });

        buttonShow.setOnClickListener(v -> {
            List<User> userList = database.userDao().getUser();

            StringBuilder s = new StringBuilder();
            for (User user : userList) {
                s.append(user.getId()).append("\t").append(user.getFirstName()).append("\t").append(user.getLastName()).append("\n");
            }
            textView.setText(s.toString());

        });
    }
}