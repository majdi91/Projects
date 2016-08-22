package com.example.thelasthackermher.el_jaw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.thelasthackermher.el_jaw.adapater.VilleAdapter;
import com.example.thelasthackermher.el_jaw.entites.Ville;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    List<Ville> villes;


@Bind(R.id.listView1)
ListView listView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);


        ButterKnife.bind(this);
        villes = new ArrayList<Ville>();

                        villes.add(new Ville("Sousse", 35.825603, 10.608394999999973, R.drawable.img_sousse));
        villes.add(new Ville ("Tunis",36.8064948,10.1815316,R.drawable.tunisville));

        villes.add(new Ville("Sfax", 34.7478469, 10.766163000000006, R.drawable.img_sfax));

                villes.add(new Ville("Ben Guerdan",33.1431887,11.218378099999995,R.drawable.img_ben));

                        villes.add(new Ville("Gafsa",34.4311398,8.775655599999936,R.drawable.img_gafsa));
        villes.add(new Ville("Chebba",35.23369,11.11078539999994,R.drawable.img_chebba));








        VilleAdapter adapter = new VilleAdapter(this,villes);

       listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int positon, long id) {
                //Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
                Ville ville = villes.get(positon);
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("obj",ville);
                startActivity(intent);




            }
            });
    }}