package org.example.entities.user.address;

public class Geo {
    private double lat;
    private double lng;

    public Geo(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public String toString() {
        return  '{' +
                "\n         \"lat\": " + lat +
                "\n         \"lng\": " + lng +
                "\n     }";
    }
}
