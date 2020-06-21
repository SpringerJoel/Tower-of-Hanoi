import java.util.Enumeration;
import java.util.Stack;

public class Stick {
    private Stack<Ring> ringStack;
    public Stick() {
        this.ringStack = new Stack<Ring>();
    }

    public Stack<Ring> getRingStack() {
        return ringStack;
    }

    public void stackRing(Ring ring) {
        ringStack.push(ring);
    }

    public void clearRingStack() {
        while(!ringStack.empty()) {
            ringStack.pop();
        }
    }

    public void printStick() {
        Enumeration enu = ringStack.elements();
        while (enu.hasMoreElements()) {
            System.out.print(enu.nextElement() + " ");
        }
        System.out.println();
    }

    public int getNumRings() {
        return ringStack.size();
    }

    public boolean isEmpty() {
        return ringStack.empty();
    }

    public boolean topRingLargerThan(Stick toStick) {
        return this.getRingStack().peek().isLargerThan(toStick.getRingStack().peek());
    }

    public Ring popRing() {
        return ringStack.pop();
    }

    public void pushRing(Ring newRing) {
        ringStack.push(newRing);
    }

    public boolean contains(Ring largestRing) {
        return ringStack.contains(largestRing);
    }

    public Ring peekRing() {
        return ringStack.peek();
    }
}
