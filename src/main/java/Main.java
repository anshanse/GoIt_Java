import com.google.gson.GsonBuilder;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Main {

    static String url = "https://jsonplaceholder.typicode.com";


    public static void main(String[] args) throws IOException {

        User myUser = new User.Builder()
                //.id(11)
                .name("Vasya")
                .username("bigboss")
                .email("fikole@grin.com")
                .phone("+9379992")
                .website("www.www.www/www")
                .address(new Address.Builder()
                        .city("Nico")
                        .suite("FEFSDF")
                        .zipcode(54000)
                        .street("Central avenue")
                        .geo(new Geo.Builder()
                                .lat(+52.5648f)
                                .lng(-53.6584f)
                                .build())
                        .build())
                .company(new Company.Builder()
                        .nameCompany("Facecontrol")
                        .bs("dfsdfsvs")
                        .catchPhrase("dsfavwef3333333")
                        .build())
                .build();
        String body = new GsonBuilder().setPrettyPrinting().create().toJson(myUser);

        Connection.Response response = Jsoup.connect(url+"/users")
                //.ignoreContentType(true)
                //.followRedirects(true)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                .header("Accept", "application/json")
                .method(Connection.Method.POST)
                .requestBody(body)
                .execute();

        System.out.println(response.statusCode());
    }
}


