package lectionHW.WebProtocol;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Geo {
    @SerializedName("lat")
    private String lat;

    @SerializedName("lng")
    private String lng;

    @Override
    public String toString() {
        return "Geo: " +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }

    public Geo(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
}
