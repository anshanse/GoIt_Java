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
        return "Geo{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
