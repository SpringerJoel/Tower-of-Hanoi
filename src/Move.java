import java.util.ArrayList;
import java.util.HashSet;

public class Move {

    private Stick from;
    private Stick to;

    public static boolean isValidMoveString(String s) {
        String[] position = s.split(" ");
        if (position.length != 2) {
            return false;
        }
        for (int i = 0; i < 2; i++) {
            if (!( position[i].equals("L") || position[i].equals("M") || position[i].equals("R") )) {
                return false;
            }
        }
        return true;
    }

    public Move (Stick from, Stick to) {
        this.from = from;
        this.to = to;
    }

    public Stick getFrom() {
        return from;
    }

    public Stick getTo() {
        return to;
    }
}
