package com.example.geet_pc.roomsdemo;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.geet_pc.roomsdemo.database.AppDataBase;
import com.example.geet_pc.roomsdemo.database.User;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputLayout firstname, lastname, id;
    Button save, show, delete;
    AppDataBase mdb;
    TextView usernames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        id = findViewById(R.id.id);
        save = findViewById(R.id.save);
        show = findViewById(R.id.show);
        usernames = findViewById(R.id.usernames);
        delete = findViewById(R.id.delete);
        delete.setOnClickListener(this);
        save.setOnClickListener(this);
        show.setOnClickListener(this);
        mdb = AppDataBase.getInMemoryDatabase(getApplicationContext());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save:
                String first = firstname.getEditText().getText().toString();
                String last = lastname.getEditText().getText().toString();
                String mobile=id.getEditText().getText().toString();
                addUser(first, last, mobile,Calendar.getInstance().getTime());
                break;
            case R.id.show:
                List<User> userlist = mdb.userModel().getUserlist();
                StringBuffer sb = new StringBuffer();
                for (User user : userlist) {
                    sb.append(user.firstname);
                    sb.append(" ");
                    sb.append(user.lastname);
                    sb.append(" ");
                    sb.append(user.mobile);
                    sb.append("\n");
                }
                usernames.setText(sb);
                break;
            case R.id.delete:
                String first1 = firstname.getEditText().getText().toString();
                mdb.userModel().deleteUsersByName(first1);
                break;
        }
    }

    private void addUser(String first, String last,String mobile, Date time) {
        User user = new User();
        user.firstname = first;
        user.lastname = last;
        user.date = time;
        user.mobile=mobile;
        try {
            mdb.userModel().insertUser(user);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
