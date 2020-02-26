public class OffByN implements CharacterComparator {

    private int n;

    public OffByN(int n) {
        this.n = n;
    }

    @Override
    public boolean equalChars(char x, char y) {

        if (Character.compare(x, y) == -n || Character.compare(x, y) == n) {
            return true;
        }
        return false;
    }
}
