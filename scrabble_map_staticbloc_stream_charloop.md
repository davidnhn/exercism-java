```java
import java.util.*;

class Scrabble {
    private char[] word = {};
    private static final Map<Character, Integer> scrabbleScores = new HashMap<>(){{
        put('A', 1);
        put('E', 1);
        put('I', 1);
        put('O', 1);
        put('U', 1);
        put('L', 1);
        put('N', 1);
        put('R', 1);
        put('S', 1);
        put('T', 1);
        put('D', 2);
        put('G', 2);
        put('B', 3);
        put('C', 3);
        put('M', 3);
        put('P', 3);
        put('F', 4);
        put('H', 4);
        put('V', 4);
        put('W', 4);
        put('Y', 4);
        put('K', 5);
        put('J', 8);
        put('X', 8);
        put('Q', 10);
        put('Z', 10);
    }};
    
    Scrabble(String word) {
        this.word = word.toUpperCase().toCharArray();
    }

    int getScore() {
        int score = 0;
        for(char letter : word) {
            score += scrabbleScores.get(letter);
        }

        return score;
    }

}
```

```java
import java.util.*;

class Scrabble {
    private char[] word = {};
    
    // Utilisation d'une méthode pour simplifier l'ajout des lettres avec la même valeur
    private static final Map<Character, Integer> scrabbleScores = new HashMap<>();
    
    static {
        addLettersWithSameScore(1, 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T');
        addLettersWithSameScore(2, 'D', 'G');
        addLettersWithSameScore(3, 'B', 'C', 'M', 'P');
        addLettersWithSameScore(4, 'F', 'H', 'V', 'W', 'Y');
        addLettersWithSameScore(5, 'K');
        addLettersWithSameScore(8, 'J', 'X');
        addLettersWithSameScore(10, 'Q', 'Z');
    }
    
    private static void addLettersWithSameScore(int score, char... letters) { // ... on appelle ça les varargs (variable arguments) , ça ca transofrme en array ici char[]
        for (char letter : letters) {
            scrabbleScores.put(letter, score);
        }
    }

    // Constructeur
    Scrabble(String word) {
        this.word = word.toUpperCase().toCharArray();
    }

    // Utilisation de getOrDefault pour gérer les lettres non valides
    int getScore() {
        return Arrays.stream(word)
                     .map(letter -> scrabbleScores.getOrDefault(letter, 0))  // Gère les lettres non valides
                     .sum();
    }

    // Méthode principale pour tester
    public static void main(String[] args) {
        Scrabble scrabble = new Scrabble("cabbage");
        System.out.println("Le score est : " + scrabble.getScore());  // Devrait afficher 14
    }
}
```


## 2. Le bloc statique (`static block`) :

### Utilisation :
Le bloc statique dans une classe est utilisé pour exécuter des instructions **au moment du chargement de la classe** en mémoire, c'est-à-dire avant même la création d'une instance de la classe.

### Exécution :
Ce bloc s'exécute **une seule fois**, lors du premier accès à la classe (que ce soit pour créer un objet ou appeler une méthode statique de la classe).

### Quand le bloc statique s'exécute ?
Le bloc statique dans ton code s'exécute lorsque la classe `Scrabble` est chargée pour la première fois par le ClassLoader. Cela se produit la première fois que :
- Tu crées une instance de la classe `Scrabble`.
- Tu accèdes à un membre statique (variable ou méthode) de cette classe.

### Exemple de déroulement :
1. Lors de l'appel à `new Scrabble("cabbage")`, la classe `Scrabble` est chargée par le ClassLoader.
2. Avant que l'objet soit instancié, **le bloc statique est exécuté**. Dans ce bloc, la méthode `addLettersWithSameScore` est appelée pour remplir le `Map` avec les valeurs des lettres.
3. Une fois le bloc statique exécuté, la création de l'objet continue, et le constructeur de la classe est appelé.

### Pourquoi utiliser un bloc statique ?
- **Initialisation complexe des variables statiques** : Si tu dois initialiser des variables statiques de manière plus complexe (comme remplir un `Map`), le bloc statique permet de regrouper toute cette logique. Il est particulièrement utile pour **initialiser des ressources statiques qui ne changent pas pendant l'exécution**.

- **Exécution unique** : Puisque le bloc statique ne s'exécute qu'une seule fois, il est idéal pour configurer des données partagées (comme les valeurs des lettres dans ton exemple) de manière sûre et efficace.

### Recommandations :
- **Courant pour initialiser des variables statiques** : Utiliser un bloc statique est une bonne pratique lorsque tu dois effectuer une initialisation qui ne dépend pas d'instances de la classe.
- **Clarté** : Si l'initialisation n'est pas trop complexe, tu peux initialiser directement le `Map` dans sa déclaration. Cependant, pour des structures plus complexes ou avec des dépendances, le bloc statique est adapté.
