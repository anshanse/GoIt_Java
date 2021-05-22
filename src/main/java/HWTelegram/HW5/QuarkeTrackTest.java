package HWTelegram.HW5;

import java.util.Arrays;
import java.util.Objects;

class QuarkeTrackTest {
    public static void main(String[] args) {
        int[] track1Data = {1, 3, 5};
        int[] track2Data = {3, 5, 4};
        int[] track3Data = {1, 5, 3};

        QuarkeTrack track1 = new QuarkeTrack(track1Data);
        QuarkeTrack track2 = new QuarkeTrack(track2Data);
        QuarkeTrack track3 = new QuarkeTrack(track3Data);

        //false
        System.out.println(track1.equals(track2));

        //true
        System.out.println(track1.equals(track3));

        //Can be true or false
        System.out.println(track1.hashCode() == track2.hashCode());

        //true
        System.out.println(track1.hashCode() == track3.hashCode());
    }
}
class QuarkeTrack{
    private int [] lines;
    int lengthLines;

    public QuarkeTrack(int[] lines) {
        this.lines = lines;
        for (int i = 0; i < this.lines.length; i++) {
            lengthLines += this.lines[i];
        }
    }

    public int[] getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        //if (this == o) return true;
        if (!(o instanceof QuarkeTrack)) return false;
        QuarkeTrack that = (QuarkeTrack) o;
        if (this.lengthLines == that.lengthLines) return true;
        //return Arrays.equals(getLines(), that.getLines());
        return false;
    }

    /*@Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < this.lines.length; i++) {
            hash += this.lines[i];
        }
        return hash;
    }*/

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.lines);
    }
}
