package HWTelegram.HW6;

public class GooSearchResult {
    private final String url;

    public GooSearchResult(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String parseDomain(){
        String domain = null;
        int beginIndex = this.url.indexOf("//")+2;
        int endIndex;
        //endIndex = this.url.indexOf("/",beginIndex);
        endIndex = this.url.indexOf("/",beginIndex) == -1 ? this.url.length() : this.url.indexOf("/",beginIndex);
        domain = this.url.substring(beginIndex, endIndex);
        return domain;
    }
}
class GooSearchResultTest {
    public static void main(String[] args) {
        //test.com
        System.out.println(new GooSearchResult("https://test.com/").parseDomain());

        //apple.in.mars
        System.out.println(new GooSearchResult("http://apple.in.mars").parseDomain());
    }
}