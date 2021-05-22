package lectionHW.WebProtocol;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;



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
        return "Address: " +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", ciy='" + ciy + '\'' +
                ", zip='" + zip + '\'' +
                ", geo=" + geo +
                '}';
    }

    public Address(String street, String suite, String ciy, String zip, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.ciy = ciy;
        this.zip = zip;
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCiy() {
        return ciy;
    }

    public String getZip() {
        return zip;
    }

    public Geo getGeo() {
        return geo;
    }
}
