public class OffByOne implements CharacterComparator {


    @Override
    public boolean equalChars(char x, char y) {

        if (Character.compare(x, y) == -1 || Character.compare(x, y) == 1) {
            return true;
        }
        return false;
    }
}
