import java.util.Arrays;
import java.util.Stack;

public class MoveHistory {
    private Stack<Move> moves;

    public MoveHistory() {
        this.moves = new Stack<Move>();
    }

    public void pushMove(Move newMove) {
        moves.push(newMove);
    }

    public Move popMove() {
        return moves.pop();
    }

    public void printMoveHistory() {
        System.out.println(Arrays.toString(moves.toArray()));
    }
}
