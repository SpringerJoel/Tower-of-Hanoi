public class Solver {

    private enum ringLetter {L,M,R}

    private int numRings;
    private Board board;

    public Solver(Board board, int numRings) {
        this.numRings = numRings;
        this.board = board;
    }

    private Move bestNextMoveRec(int largestRing, ringLetter r) {
        // TODO
        // If largestRing is in place return recursion for next largest ring
        // If can move largestRing into place, return that move
        // Else Recurse for next largest ring to move to the third ring (not the src or destination of current ring)
    }

    public Move bestNextMove() {
        return bestNextMoveRec(numRings,ringLetter.R);
    }
}
