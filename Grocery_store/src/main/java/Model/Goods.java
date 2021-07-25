package Model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Goods implements BaseGoods<String>{

    @SerializedName("name")
    private String id;
    @SerializedName("price")
    private Double price;
    @SerializedName("saleable")
    private Boolean saleable;
    @SerializedName("discountQty")
    private Integer discountQty;
    @SerializedName("discountPrice")
    private Double discountPrice;

}
