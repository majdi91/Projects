package com.example.thelasthackermher.el_jaw.adapater;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thelasthackermher.el_jaw.R;
import com.example.thelasthackermher.el_jaw.entites.Ville;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by thelasthackermher on 24/11/15.
 */

public class VilleAdapter extends BaseAdapter {

    List<Ville> villes;
    Activity context;
    private LayoutInflater inflater = null;
    /**
     * Constructor
     * c: context
     * depense: list of depenses
     **/
    public VilleAdapter(Activity c, List<Ville> villes ){
        context = c;
        this.villes = villes;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return villes.size();
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

        @Bind(R.id.image_ville)
        CircleImageView img;


        @Bind(R.id.tv_ville_name)
        TextView  tv_name;

        @Bind(R.id.tv_ville_position)
        TextView tv_position;

        public Holder(View view){
            ButterKnife.bind(this,view);
        }

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView = inflater.inflate(R.layout.item_ville, null);

        final Holder holder = new Holder(rowView);

        Ville ville = villes.get(position);
        holder.img.setImageResource(ville.getImgRes());
        holder.tv_name.setText(ville.getName());
        holder.tv_position.setText(

                "("+ville.getLat()+","+ville.getLng()+")"
        );

        return rowView;
    }





}

