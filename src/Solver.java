public class Solver {

    private Board board;

    public Solver(Board board) {
        this.board = board;
    }

    private Move bestNextMoveRec(Ring largestRing, Stick destStick) {
        // TODO
        // If largestRing is in place return recursion for next largest ring
        if (destStick.contains(largestRing)) {
            return bestNextMoveRec(largestRing.nextLargestRing(), destStick); // create actual ring of size largestRing-1
        }
        // Find which stack has the largestRing
        Stick [] sticks = {board.getLeft(), board.getMiddle(), board.getRight()};
        Stick originStick = null;
        int i;
        for (i = 0; i < 3; i ++) {
            originStick = sticks[i];
            if (originStick.contains(largestRing)) {
                break;
            }
        }
        // If ring is smallest ring, you can always move it
        if (largestRing.isSmallestRing()) {
            return new Move(originStick, destStick);
        }
        // If can move largestRing into place, return that move
        if (originStick.peekRing().equals(largestRing) && (destStick.isEmpty()||destStick.peekRing().isLargerThan(largestRing))) {
            return new Move (originStick, destStick);
        }
        // Else recurse for next largest ring to move to the third (other) ring (not the src or destination of current ring)
        Stick otherStick = sticks[0];
        for ( i = 0; i < 3; i ++) {
            if (!(otherStick.equals(originStick) || otherStick.equals(destStick))) {
                break;
            }
            otherStick = sticks[i];
        }
        return bestNextMoveRec(largestRing.nextLargestRing(), otherStick);
    }

    public Move bestNextMove() {
        int numRings = board.getNumRings();
        Ring largestRing = new Ring(numRings);
        return bestNextMoveRec(largestRing, board.getRight());
    }
}
