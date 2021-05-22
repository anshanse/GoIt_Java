package HWTelegram;

public class ExonNames {
    public boolean areNamesEqual(String name1, String name2) {
        return name1.equals(name2);
    }

    public String makeFullName(String firstName, String lastName) {
        return firstName.toLowerCase() + " " + lastName.toUpperCase();
    }

    public boolean isNameLucky(String name) {
        String lowerCaseName = name.toLowerCase();
        return lowerCaseName.contains("a") || lowerCaseName.contains("o");
    }

    public String getNameCode(String name){
        String upperCaseName = name.toUpperCase();
        int nameLength = name.length();
        String firstLetter = upperCaseName.substring(0,1);
        String lastLetter = upperCaseName.substring(nameLength-1);
        return firstLetter+lastLetter;
    }
    public String makeNamePositive(String name){
        if (name.contains("No")){
            name = name.replace("No", "Yes");
        }
        else if (name.contains("no")){
            name = name.replace("no", "yes");
        }
        else if (name.contains("nO")){
            name = name.replace("nO", "yes");
        }
        else if (name.contains("NO")){
            name = name.replace("NO", "YES");
//            name = name.replace("e","1").replace(/*/*/)
        }
        return name;
    }

    public String encode(String name){
        name = name.replace("e","1").replace("u","2").replace("i","3").replace("o","4").replace("a","5");
        return "NOTFORYOU"+name+"YESNOTFORYOU";
    }

    public String decode(String name){
        name = name.replace("YESNOTFORYOU","").replace("NOTFORYOU","").replace("1","e").replace("2","u").replace("3","i").replace("4","o").replace("5","a");
        return name;
    }

    //Test output
    public static void main(String[] args) {
        ExonNames names = new ExonNames();

        //Should be true
        boolean namesEqual = names.areNamesEqual("nm", "nm");
        System.out.println("names.areNamesEqual(\"nm\", \"nm\") = " + namesEqual);

        //Should be "exor BIGO"
        String fullName = names.makeFullName("exor", "bigo");
        System.out.println("names.makeFullName(\"exor\", \"bigo\") = " + fullName);

        //Should be true
        boolean isNameLucky = names.isNameLucky("Bigo");
        System.out.println("names.isNameLucky(\"Bigo\") = " + isNameLucky);

        //Should be BA
        String nameCode = names.getNameCode("boRA");
        System.out.println("names.getNameCode(\"boRA\") = " + nameCode);

        //Should be YesMont
        String positive = names.makeNamePositive("NOr");
        System.out.println("names.makeNamePositive(\"Nomajorue\") = " + positive);

        System.out.println(names.decode("NOTFORYOUh2s1l3dy2YESNOTFORYOU"));
    }
}
