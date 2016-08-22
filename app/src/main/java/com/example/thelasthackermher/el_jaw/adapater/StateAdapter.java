package com.example.thelasthackermher.el_jaw.adapater;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thelasthackermher.el_jaw.R;
import com.example.thelasthackermher.el_jaw.entites.Ville;
import com.example.thelasthackermher.el_jaw.entites.WeatherState;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by thelasthackermher on 25/11/15.
 */
public class StateAdapter extends BaseAdapter {


    List<WeatherState> states;
    Activity context;
    private LayoutInflater inflater = null;
    /**
     * Constructor
     * c: context
     * depense: list of depenses
     **/
    public StateAdapter(Activity c, List<WeatherState> states ){
        context = c;
        this.states = states;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return states.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {

        @Bind(R.id.image_ville2)
        CircleImageView img;


        @Bind(R.id.tv_ville2)
        TextView tv_name;

        @Bind(R.id.tv_ville_position2)
        TextView tv_position;

        public Holder(View view){
            ButterKnife.bind(this, view);
        }

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView = inflater.inflate(R.layout.item_ville, null);

        final Holder holder = new Holder(rowView);

        WeatherState weather = states.get(position);
        holder.tv_name.setText(String.valueOf(weather.getTemp()));
        holder.tv_position.setText(

                "("+String.valueOf(weather.getLat()) +","+String.valueOf(weather.getLng())+")"
        );

        return rowView;
    }


}
