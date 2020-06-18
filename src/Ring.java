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
}
