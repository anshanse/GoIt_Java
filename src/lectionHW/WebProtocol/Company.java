package lectionHW.WebProtocol;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Builder
public class Company {

    @SerializedName("name")
    private String companyName;

    @SerializedName("catchPhrase")
    private String catchPhrase;

    @SerializedName("bs")
    private String bs;

    public Company(String companyName, String catchPhrase, String bs) {
        this.companyName = companyName;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    @Override
    public String toString() {
        return "Company: " +
                "companyName='" + companyName + '\'' +
                ", catchPhrase='" + catchPhrase + '\'' +
                ", bs='" + bs + '\'' +
                '}';
    }
}
