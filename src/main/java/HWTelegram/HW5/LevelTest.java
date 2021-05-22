/*
package HWTelegram.HW5;

*/
/*class LevelTest {
    public static void main(String[] args) {
        //Quarke level, name is Test
        System.out.println(new Level("Test"));
    }
}*//*


*/
/*class LevelTest {
    public static void main(String[] args) {
        Level.Point p1 = new Level.Point(3, 5);
        Level.Point p2 = new Level.Point(10, 100);
        Level.Point p3 = new Level.Point(50, 40);

        Level.Point[] points = {p1, p2, p3};

        //Quarke level, name is Test, point count is 3
        System.out.println(new Level("Test", points));
    }
}*//*


class LevelTest {
    public static void main(String[] args) {
        Level.Point p1 = new Level.Point(3, 5);
        Level.Point p2 = new Level.Point(10, 100);
        Level.Point p3 = new Level.Point(50, 40);

        Level.Point[] points = {p1, p2, p3};

        Level.LevelInfo info = new Level.LevelInfo("Quarke Intro", "Easy");

        //Quarke level, name is Quarke Intro, difficulty is Easy, point count is 3
        //System.out.println(new Level(info, points));

        //3015
        System.out.println(new Level(info, points).calculateLevelHash());
    }
}

class Level{
    //private String name;
    private LevelInfo levelInfo;
    private Point[] points;

    */
/*public Level(String name){
        this.name = name;
    }*//*


   */
/* public Level(String name, Point[] points) {
        this.name = name;
        this.points = points;
    }*//*


    public Level(LevelInfo levelInfo, Point[] points) {
        this.levelInfo = levelInfo;
        this.points = points;
    }

    static class Point{
        private int x, y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class LevelInfo{
        private String name;
        private String difficulty;

        public String getName() {
            return name;
        }

        public String getDifficulty() {
            return difficulty;
        }

        public LevelInfo(String name, String difficulty) {
            this.name = name;
            this.difficulty = difficulty;
        }
    }

    @Override
    public String toString() {
        return "Quarke level, name is " + levelInfo.name +
                ", difficulty is " + levelInfo.difficulty +
                ", point count is " + this.points.length;
    }

    public int calculateLevelHash(){
        int hash = 0;
        for (int i = 0; i < points.length; i++) {
            hash += points[i].getX()*points[i].getY();
        }
        return hash;
    }
}
*/
