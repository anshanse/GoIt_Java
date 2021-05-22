package HWTelegram.HW3;

public class ArlanHelper {

    public String drawQuad(int n) {
        int i = 0;
        while (i < n) {
            int j = 0;
            while (j<n) {
                System.out.print("*");
                j++;
            }
            i++;
            System.out.println();
        }
        return "";
    }

    public String drawRect(int width, int height, char c){
        int i = 0;
        while (i < height) {
            int j = 0;
            while (j<width) {
                System.out.print(c);
                j++;
            }
            i++;
            System.out.println();
        }
        return "";
    }

    public String drawLine(int length){
        int i=0;
        String line ="";
        while (i<length){
            while (i%2==0 && i<length){
                line+="*";
                i++;
            }
            while (i%2!=0 && i<length){
                line+="#";
                i++;
            }
        }
        return line;
    }

    public String drawPattern(char[] pattern, int repeatCount){
        String elPattern = new String(pattern);
        String result="";
        int count=0;
        while (count<repeatCount){
            result+=elPattern;
            count++;
        }
        return result;
    }

    //Test output
    public static void main(String[] args) {
        ArlanHelper helper = new ArlanHelper();
        //Should be:
        //**
        //**
        //System.out.println(helper.drawQuad(2));

        //Should be:
        //XX
        //XX
        //XX
        //System.out.println(helper.drawRect(2, 3, 'X'));

        //Should be:
        //*#*#*
        //System.out.println(helper.drawLine(5));

        //Should be:
        //JavaJavaJavaJava
        System.out.println(helper.drawPattern(new char[] {'J', 'a', 'v', 'a'}, 3));
    }
}

