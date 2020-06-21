import GameExceptions.BadInputException;
import GameExceptions.EmptyHistoryException;
import GameExceptions.EmptyStickException;
import GameExceptions.RingSizeException;

public class Board {
    private Stick left;
    private Stick middle;
    private Stick right;
    private MoveHistory moveHistory;

    public Board() {
        this.left = new Stick();
        this.middle = new Stick();
        this.right = new Stick();
        this.moveHistory = new MoveHistory();
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
        moveHistory.pushMove(move);
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
}
