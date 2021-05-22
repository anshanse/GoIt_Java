package HWTelegram.HW5;

import java.util.Arrays;

class TargetFinderTest {
    public static void main(String[] args) {
        int[] aiCoords = {10, 10};
        int[][] targets = {
                {20, 20},
                {15, 14},
                {30, 5}
        };

        TargetFinder targetFinder = new TargetFinder();
        int[] nearestTarget = targetFinder.findTarget(aiCoords, targets);

        //Expect [15, 14]
        System.out.println(Arrays.toString(nearestTarget));
    }
}
class TargetFinder{

    public int[] findTarget(int[] aiCoords, int[][] targets){
        double minDist = (Math.sqrt(Math.pow(targets[0][0]-aiCoords[0],2)+Math.pow(targets[0][1]-aiCoords[1],2)));
        int count=0;
        for (int i = 0; i < targets.length; i++) {
            double dist = (Math.sqrt(Math.pow(targets[i][0]-aiCoords[0],2)+Math.pow(targets[i][1]-aiCoords[1],2)));
            if (dist < minDist){
                minDist = dist;
                count = i;
            }
        }
        return new int [] {targets[count][0], targets[count][1]};
    }
}
