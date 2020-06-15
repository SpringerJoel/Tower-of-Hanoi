public class Board {
    private Stick left;
    private Stick middle;
    private Stick right;

    public Board() {
        this.left = new Stick();
        this.middle = new Stick();
        this.right = new Stick();
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

    public void moveRing(String fromStickName, String toStickName) {
        try {
            Stick FromStick = stringToStick(fromStickName);
            Stick toStick = stringToStick(toStickName);
            // TODO
        } catch (Exception e) {
        }
    }

    private Stick stringToStick(String stickName) throws Exception {
        switch(stickName) {
            case "L":
                return left;
            case "M":
                return middle;
            case "R":
                return right;
            default:
                throw new Exception();
        }
    }

    public void print() {
        int lRings = left.getNumRings();
        int mRings = middle.getNumRings();
        int rRings = right.getNumRings();
        int maxRings = mostRings(lRings, mRings, rRings);

        System.out.print("L ");
        printNSpaces((maxRings-lRings)*2);
        left.printStick();

        System.out.print("M ");
        printNSpaces((maxRings-mRings)*2);
        middle.printStick();

        System.out.print("R ");
        printNSpaces((maxRings-rRings)*2);
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
}
