package lectionHW.WebProtocol;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
public class Company {

    @SerializedName("name")
    private String companyName;

    @SerializedName("catchPhrase")
    private String catchPhrase;

    @SerializedName("bs")
    private String bs;

    protected boolean canEqual(final Object other) {
        return other instanceof Company;
    }

}
