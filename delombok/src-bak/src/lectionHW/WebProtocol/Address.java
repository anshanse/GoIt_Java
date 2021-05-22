package lectionHW.WebProtocol;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
class Address {
    @SerializedName("street")
    private String street;

    @SerializedName("suite")
    private String suite;

    @SerializedName("city")
    private String ciy;

    @SerializedName("zipcode")
    private String zip;

    @SerializedName("geo")
    private Geo geo;

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", ciy='" + ciy + '\'' +
                ", zip='" + zip + '\'' +
                ", geo=" + geo +
                '}';
    }
}
