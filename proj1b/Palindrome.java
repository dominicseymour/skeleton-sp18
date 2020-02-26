public class Palindrome {


    /** Given a String, wordToDeque should return a Deque
     * where the characters appear in the same order as in the String.
     *  */
    public Deque<Character> wordToDeque(String word) {

        Deque<Character> characterDeque = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i++) {

            Character c = word.charAt(i);
            characterDeque.addLast(c);
        }
        return characterDeque;
    }

    /** The isPalindrome method should return true
     * if the given word is a palindrome, and false otherwise.
     */
    public boolean isPalindrome(String word) {

        Deque<Character> d = wordToDeque(word);

        while (d.size() > 1) {

            Character first = d.removeFirst();
            Character last = d.removeLast();

            if (!first.equals(last)) {
                return false;
            }
        }

        return true;
    }

    /** The method will return true if the word is a palindrome
     * according to the character comparison test provided by
     * the CharacterComparator passed in as argument cc.
     *
     * */
    public boolean isPalindrome(String word, CharacterComparator cc) {

        Deque<Character> d = wordToDeque(word);

        while (d.size() > 1) {

            Character first = d.removeFirst();
            Character last = d.removeLast();

            if (!cc.equalChars(first, last)) {
                return false;
            }
        }

        return true;

    }
}
