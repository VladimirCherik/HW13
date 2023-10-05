package org.example.Task_1;

import java.util.Objects;

public class Geo {
    private double lat;
    private double lng;

    public Geo(double lat, double  lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }


}
