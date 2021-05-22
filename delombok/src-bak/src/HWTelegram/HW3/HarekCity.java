package HWTelegram.HW3;

import java.util.*;

public class HarekCity {
    public String[] createEmptyNameArray() {
        String[] result = new String[0];
        return result;
    }

    public int[] createAgeArray(int age1, int age2, int age3, int age4) {
        return new int[] {age1, age2, age3, age4};
    }

    public void fixNames(String[] names, String[] toReplace){
        names[1] = toReplace[0];
        names[3] = toReplace[1];
    }

    public String firstAndLastTogether(String[] names){
        return (names[0] + " AND " + names[9] + " TOGETHER");
    }

    public void changeElectResult(String[] results){
        if (results.length>1){
            String tmp = results[0];
            results[0] = results[results.length-1];
            results[results.length-1] = tmp;
        }
    }

    public String[] changeElectResultAgain(String[] results){
        String [] newRes = new String[3];
        System.arraycopy(results,2,newRes,0,3);
        return newRes;
    }

    public char[][] createKeyboard(){
        char [] [] keyboard = {{'1','2','3'},{'4','5','6'},{'7','8','9'},{'*','0','#'}};
        return keyboard;
    }

    public void printKeyboard(){
        char [][] keyboard = createKeyboard();
        for (int i=0; i<keyboard.length; i++) System.out.println(Arrays.toString(keyboard[i]));
    }

    public String[] makeCopy(String[] names){
        System.out.println("Copied!");
        return Arrays.copyOf(names,names.length);
    }

    public static void main(String[] args) {
        /*String[] names = new String[]{"mixa", "ukio", "barek", "krou", "fiha"};
        String[] toReplace = new String[]{"lopr", "boki"};
        new HarekCity().fixNames(names, toReplace);
        System.out.println(Arrays.toString(names));*/

       /* String[] results = new String[]{"miho", "hut"};
        new HarekCity().changeElectResult(results);
        System.out.println(Arrays.toString(results));*/

        /*String[] results = new String[]{"mix", "max", "pex", "fux", "rox"};
        String[] changedResults = new HarekCity().changeElectResultAgain(results);
        System.out.println(Arrays.toString(changedResults));*/

        /*char[][] keyboard = new HarekCity().createKeyboard();
        for (int i = 0; i < keyboard.length; i++) {
            System.out.println(Arrays.toString(keyboard[i]));
        }*/

        new HarekCity().printKeyboard();
    }
}
