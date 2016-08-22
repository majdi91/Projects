package com.example.thelasthackermher.el_jaw;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.activeandroid.query.Select;
import com.example.thelasthackermher.el_jaw.entites.WeatherState;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FetchActivity extends AppCompatActivity {

    @Bind(R.id.listView2)

    ListView listeView2;

    List<WeatherState> states;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);

        ButterKnife.bind(this);



    }
    }

