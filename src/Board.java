import GameExceptions.BadInputException;
import GameExceptions.EmptyStickException;
import GameExceptions.RingSizeException;

public class Board {
    private Stick left;
    private Stick middle;
    private Stick right;

    public Board() {
        this.left = new Stick();
        this.middle = new Stick();
        this.right = new Stick();
    }

    public Stick getLeft() {
        return left;
    }

    public Stick getMiddle() {
        return middle;
    }

    public Stick getRight() {
        return right;
    }

    public void addRings(int numRings) {
        for (int i = numRings; i > 0; i--) {
            left.stackRing(new Ring(i));
        }
    }

    public void removeRings() {
        left.clearRingStack();
        middle.clearRingStack();
        right.clearRingStack();
    }

    public void moveRing(Move move) throws Exception {
        Stick stickFrom = move.getFrom();
        Stick stickTo = move.getTo();
        // check if move is possible
        if (stickFrom.isEmpty()) {
            throw new EmptyStickException();
        }
        if (!stickTo.isEmpty() && (stickFrom.topRingLargerThan(stickTo)) ) {
            throw new RingSizeException();
        }
        stickTo.pushRing(stickFrom.popRing());
    }

    public void print() {
        int lRings = left.getNumRings();
        int mRings = middle.getNumRings();
        int rRings = right.getNumRings();
        int maxRings = mostRings(lRings, mRings, rRings);

        System.out.print("L ");
        left.printStick();

        System.out.print("M ");
        middle.printStick();

        System.out.print("R ");
        right.printStick();
    }

    private void printNSpaces(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

    private int mostRings(int numRings1, int numRings2, int numRings3) {
        if (numRings1 > numRings2) {
            if (numRings1 > numRings3) {
                return numRings1;
            } else {
                return numRings3;
            }
        } else {
            if (numRings2 > numRings3) {
                return numRings2;
            } else {
                return numRings3;
            }
        }
    }

    public boolean inFinishedPosition() {
        return left.isEmpty() && middle.isEmpty();
    }
}
