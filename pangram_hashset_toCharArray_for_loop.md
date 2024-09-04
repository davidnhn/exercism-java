```java
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class PangramChecker {

    public boolean isPangram(String input) {
        List<Character> alphabet = List.of(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        );

        input = input.toLowerCase();

        Set<Character> lettersFound = new HashSet<>();

        for(char c : input.toCharArray()) {
            if(alphabet.contains(c)) {
                lettersFound.add(c);
            }

            if(lettersFound.size() == alphabet.size()) {
                return true;
            }
        }

        return lettersFound.size() == alphabet.size();
    }

}
```

```java
import java.util.HashSet;
import java.util.Set;

public class PangramChecker {

    public boolean isPangram(String input) {
        // Convert input to lowercase to handle case insensitivity
        input = input.toLowerCase();
        
        // Use a HashSet to store unique letters
        Set<Character> lettersFound = new HashSet<>();
        
        // Iterate over the characters in the string
        for (char c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z') { // Only consider alphabetic characters
                lettersFound.add(c);
            }
            // If we found all 26 letters, return true
            if (lettersFound.size() == 26) {
                return true;
            }
        }
        
        // Check if we found all letters
        return lettersFound.size() == 26;
    }

    public static void main(String[] args) {
        PangramChecker checker = new PangramChecker();
        System.out.println(checker.isPangram("The quick brown fox jumps over the lazy dog")); // true
        System.out.println(checker.isPangram("Hello World!")); // false
    }
}
