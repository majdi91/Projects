package com.example.thelasthackermher.el_jaw;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.thelasthackermher.el_jaw.entites.Ville;
import com.example.thelasthackermher.el_jaw.entites.WeatherState;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONArray;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {


    Ville ville;
    FloatingActionButton fab;

    @Bind(R.id.img_weather)
    ImageView imgWeather;
    @Bind(R.id.tv_temp)
    TextView tvTemp;
    @Bind(R.id.tv_desc)
    TextView tvDesc;

    String desc,temp,icon;

    FloatingActionButton FabMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .showImageOnFail(R.drawable.logo_weather)
                .showImageOnLoading(R.drawable.logo_weather)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(defaultOptions).build();
        ImageLoader.getInstance().init(config);


        ville = (Ville) getIntent().getSerializableExtra("obj");

        getWeather();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Weather State Saved", Snackbar.LENGTH_LONG)
                        .setAction("Save", null).show();
                WeatherState state = new WeatherState(ville, desc, Double.parseDouble(temp), icon);
                state.save();
            }
        });

        FabMap = (FloatingActionButton) findViewById(R.id.fab_map);
        FabMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DetailsActivity.this, MapsActivity.class);
                intent.putExtra("ln", ville.getLng());
                intent.putExtra("lat", ville.getLat());


                startActivity(intent);
            }


        });
    }

    public void getWeather() {
        String url =
                "http://api.openweathermap.org/data" +
                        "/2.5/weather?lat=" + ville.getLat() +
                        "&lon=" + ville.getLng() +
                        "&units=metric&APPID=b92bff27c4f161d8b90e9933ba891f38";

        Volley.newRequestQueue(this).add(
                new JsonObjectRequest(Request.Method.GET, url,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                System.out.println(response.toString());
                                JSONArray json = response.optJSONArray("weather");
                                JSONObject jsonMain = response.optJSONObject("main");
                                desc = json.optJSONObject(0).optString("main");
                                icon = json.optJSONObject(0).optString("icon");
                                temp = jsonMain.optString("temp");



                                String urlImg
                                        = "http://openweathermap.org/img/w/" + icon + ".png";

                                ImageLoader.getInstance()
                                        .displayImage(urlImg, imgWeather);
                                tvDesc.setText(desc);
                                tvTemp.setText(temp+ "°C");
                                fab.setVisibility(View.VISIBLE);
                                FabMap.setVisibility(View.VISIBLE);

                            }
                        }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
        );


    }}
