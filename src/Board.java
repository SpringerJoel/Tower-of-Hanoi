import GameExceptions.BadInputException;
import GameExceptions.EmptyHistoryException;
import GameExceptions.EmptyStickException;
import GameExceptions.RingSizeException;

public class Board {
    private Stick left;
    private Stick middle;
    private Stick right;
    private int numRings;
    private MoveHistory moveHistory;

    public Board() {
        this.left = new Stick();
        this.middle = new Stick();
        this.right = new Stick();
        this.moveHistory = new MoveHistory();
        this.numRings = 0;
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

    public int getNumRings() {
        return numRings;
    }

    public void addRings(int numRings) {
        for (int i = numRings; i > 0; i--) {
            left.stackRing(new Ring(i));
        }
        this.numRings = numRings;
    }

    public void removeRings() {
        left.clearRingStack();
        middle.clearRingStack();
        right.clearRingStack();
        this.numRings = 0;
    }

    public void moveRing(String moveString) throws Exception {
        String[] position = moveString.split(" ");
        Stick fromStick = null;
        Stick toStick = null;
        switch (position[0]) {
            case "L":
                fromStick = left;
                break;
            case "M":
                fromStick = middle;
                break;
            case "R":
                fromStick = right;
                break;
        }
        switch (position[1]) {
            case "L":
                toStick = left;
                break;
            case "M":
                toStick = middle;
                break;
            case "R":
                toStick = right;
                break;
        }
        // check if move is possible
        if (fromStick.isEmpty()) {
            throw new EmptyStickException();
        }
        if (!toStick.isEmpty() && (fromStick.topRingLargerThan(toStick)) ) {
            throw new RingSizeException();
        }
        toStick.pushRing(fromStick.popRing());
        Move newMove = new Move(fromStick, toStick);
        moveHistory.pushMove(newMove);
    }

    public void print() {
        System.out.print("L ");
        left.printStick();

        System.out.print("M ");
        middle.printStick();

        System.out.print("R ");
        right.printStick();
    }

    public boolean inFinishedPosition() {
        return left.isEmpty() && middle.isEmpty();
    }

    public void undoLastMove() {
        try {
            if (moveHistory.isEmpty()) {
                throw new EmptyHistoryException();
            }
            Move move = moveHistory.popMove();
            Stick stickFrom = move.getTo();
            Stick stickTo = move.getFrom();
            stickTo.pushRing(stickFrom.popRing());

        } catch (EmptyHistoryException e) {
            System.out.println("There is no last move to undo.");
        }
    }

    public void hintMove(Move bestNextMove) {
        Stick fromStick = bestNextMove.getFrom();
        Stick toStick = bestNextMove.getTo();
        toStick.pushRing(fromStick.popRing());
        moveHistory.pushMove(bestNextMove);
    }
}
