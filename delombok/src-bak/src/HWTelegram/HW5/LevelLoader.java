/*
package HWTelegram.HW5;

*/
/*class LevelLoaderTest {
    public static void main(String[] args) {
        LevelLoader levelLoader = new LevelLoader();

        //Loading level Startlevel ...
        //System.out.println(levelLoader.load("StartLevel"));

        //Loading level Startlevel ...
        System.out.println(LevelLoader.getInstance().load("StartLevel"));
    }
}*//*

class LevelLoaderTest {
    public static void main(String[] args) {
        //Loading level Startlevel ...
        System.out.println(LevelLoader.getInstance().load("StartLevel"));
    }
}

*/
/*public class LevelLoader {
    String load(String levelName){
        return "Loading level "+ levelName + " ...";
    }
}*//*

*/
/*public class LevelLoader {
    private static LevelLoader instance = new LevelLoader();

    public static LevelLoader getInstance(){
        return instance;
    }

    String load(String levelName){
        return "Loading level "+ levelName + " ...";
    }
}*//*

public class LevelLoader {
    private static LevelLoader instance = new LevelLoader();

    public static LevelLoader getInstance(){
        return instance;
    }

    private LevelLoader(){

    }

    String load(String levelName){
        return "Loading level "+ levelName + " ...";
    }
}*/
