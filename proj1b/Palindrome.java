public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        // word split to a sequence of character
        // how to spilt?
        // for loop? yeah, should work
        Deque<Character> d = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    // The method will return true if the word is a palindrome according to
    // the character comparison test provided by
    // the CharacterComparator passed in as argument cc.
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        return isPalindrome(d, cc);
    }

    private static boolean isPalindrome(Deque<Character> d, CharacterComparator cc) {
        if (d.size() == 0 || d.size() == 1) {
            return true;
        } else {
            char f = d.removeFirst();
            char l = d.removeLast();
            if (!cc.equalChars(f, l)) {
                return false;
            } else {
                return isPalindrome(d, cc);
            }
        }
    }

    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        return isPalindrome(d);
    }

    private static boolean isPalindrome(Deque<Character> d) {
        if (d.size() == 0 || d.size() == 1) {
            return true;
        } else {
            char first = d.removeFirst();
            char last = d.removeLast();
            if (first != last) {
                return false;
            }
            return isPalindrome(d);
        }
    }

}

/**String has a charAt method that returns the character at the specified position.
 * Like arrays and Lists, String is 0-indexed,
 * i.e. the first character is at index 0
 * and the last character is at index length() - 1.
 * s.charAt(0);
 * */