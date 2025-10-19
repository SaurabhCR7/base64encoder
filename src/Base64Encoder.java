import java.util.HashMap;

public class Base64Encoder {
    private final char[] characters;
    private final HashMap<Character, Integer> charToInt;

    public Base64Encoder() {
        characters = new char[64];
        charToInt = new HashMap<>();
        int idx = 0;
        // 0 - 9
        for (int i=0; i<10; i++) {
            char ch = (char)('0' + i);
            charToInt.put(ch, idx);
            characters[idx++] = ch;
        }
        // a - z
        for (int i=0; i<26; i++) {
            char ch = (char)('a' + i);
            charToInt.put(ch, idx);
            characters[idx++] = ch;
        }
        // A - Z
        for (int i=0; i<26; i++) {
            char ch = (char)('A' + i);
            charToInt.put(ch, idx);
            characters[idx++] = ch;
        }

        // 2 extra characters (url safe)
        charToInt.put('-', idx);
        characters[idx++] = '-';

        charToInt.put('_', idx);
        characters[idx++] = '_';
    }

    public String encode(int n) {
        StringBuilder result = new StringBuilder();

        while(n > 0) {
            int num = n%64;
            result.append(characters[num]);
            n = n/64;
        }
        return result.toString();
    }

    public int decode(String str) {
        int result = 0;

        for (int i=str.length()-1; i>=0; i--) {
            char ch = str.charAt(i);
            result = (result*64) + charToInt.get(ch);
        }
        return result;
    }
}
