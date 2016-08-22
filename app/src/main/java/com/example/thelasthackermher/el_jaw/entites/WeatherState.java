package com.example.thelasthackermher.el_jaw.entites;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by thelasthackermher on 25/11/15.
 */

@Table(name="WeatherState")
public class WeatherState extends Model {

    @Column()
    private  String villeName;
    @Column()
    private Double lat;
    @Column()
    private Double lng;
    @Column()
    private String desc;
    @Column()
    private String icon;
    @Column()
    private double temp;


    public WeatherState(Ville ville, String desc, double temp,String icon) {
        this.villeName = ville.getName();
        this.lat = ville.getLat();
        this.lng = ville.getLng();
        this.icon=icon;

        this.desc = desc;
        this.temp = temp;
    }

    public WeatherState(){};

    public String getVilleName() {
        return villeName;
    }

    public void setVilleName(String villeName) {
        this.villeName = villeName;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

