import java.util.Objects;

public class Ring {
    private int size;
    public Ring(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.format(Integer.toString(size));
    }

    public Boolean isLargerThan(Ring ring) {
        return this.getSize() > ring.getSize();
    }

    public Ring nextLargestRing() {
        try {
            if (size == 1) {
                throw new Exception();
            }
            return new Ring(size - 1);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isSmallestRing() {
        return (size == 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ring ring = (Ring) o;
        return size == ring.size;
    }
}
