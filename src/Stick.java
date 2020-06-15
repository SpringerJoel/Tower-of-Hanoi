import java.util.Enumeration;
import java.util.Stack;

public class Stick {
    Stack<Ring> ringStack;
    public Stick() {
        this.ringStack = new Stack<Ring>();
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
}
