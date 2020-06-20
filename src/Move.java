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

    public Move (Board board, String moveString) {
        String[] position = moveString.split(" ");
        switch (position[0]) {
            case "L":
                this.from = board.getLeft();
                break;
            case "M":
                this.from = board.getMiddle();
                break;
            case "R":
                this.from = board.getRight();
                break;
        }
        switch (position[1]) {
            case "L":
                this.to = board.getLeft();
                break;
            case "M":
                this.to = board.getMiddle();
                break;
            case "R":
                this.to = board.getRight();
                break;
        }
    }

    public Stick getFrom() {
        return from;
    }

    public Stick getTo() {
        return to;
    }
}
