package HWTelegram.HW3;

public  class NumberTranslator {
    public static int translate(String romanNumber){
        romanNumber = romanNumber.replaceAll(" ", "").toUpperCase();
        int number=0;
            switch (romanNumber){
                case "I":
                    number = 1;
                    break;
                case "II":
                    number = 2;
                    break;
                case "III":
                    number = 3;
                    break;
                case "IV":
                    number = 4;
                    break;
                case "V":
                    number = 5;
                    break;
                case "VI":
                    number = 6;
                    break;
                case "VII":
                    number = 7;
                    break;
                case "VIII":
                    number = 8;
                    break;
                case "IX":
                    number = 9;
                    break;
                case "X":
                    number = 10;
                    break;
                case "XI":
                    number = 11;
                    break;
                case "XII":
                    number = 12;
                    break;
                default:
                    number = -1;
                    break;
            }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(translate("I"));
        System.out.println(translate("  X  I"));
        System.out.println(translate("iX  "));
        System.out.println(translate("XX"));
    }
}
