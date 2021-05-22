package HWTelegram.HW6;

public class WordDeleter {
    public String remove(String phrase, String[] words){
        String[] tempArr = phrase.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tempArr.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (tempArr[i].equals(words[j])) tempArr[i] = "";
            }
            result.append(tempArr[i]).append(" ");
        }

        return result.toString().replaceAll("[\\s]{2,}", " ").trim();
    }
}

class WordDeleterTest {
    public static void main(String[] args) {
        WordDeleter wordDeleter = new WordDeleter();

        //Hello
        System.out.println(wordDeleter.remove("Hello Java", new String[] {"Java"}));

        //This Sparta
        System.out.println(wordDeleter.remove("This is Sparta", new String[] {"is"}));
    }
}