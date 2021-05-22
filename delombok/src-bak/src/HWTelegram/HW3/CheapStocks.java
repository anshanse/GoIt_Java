package HWTelegram.HW3;

public class CheapStocks {
    public String getCheapStocks(String[] stocks){
        String result="";
        for (int i = 0; i < stocks.length; i++) {
            String [] tmpArray = stocks[i].split(" ");
            if (Integer.valueOf(tmpArray[1])<200) {
                if (result.equals("")) result += tmpArray[0];
                else result += " " + tmpArray[0];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CheapStocks stock = new CheapStocks();
        //должен возвращать rep Xo romy Vasu Jo hiz ohh
        System.out.println(stock.getCheapStocks(new String[] {"rep 156", "Xo 21", "ivg 319", "romy 111", "Xel 254", "wuo 933", "La 644", "Vasu 190", "Jo 91", "hiz 35", "Go 376", "ohh 98"}));
    }
}
