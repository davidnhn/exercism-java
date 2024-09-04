```java
import java.util.ArrayList;
import java.util.List;
class NaturalNumber {
    int number;
    NaturalNumber(int number) {
        if(number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.number = number;
    }

    Classification getClassification() {
        List<Integer> diviseurs = new ArrayList<>();
        for(int i=1; i < this.number; i++) {
            if(this.number % i == 0) {   
                diviseurs.add(i);
            }
        }

        int sum = diviseurs.stream().reduce(0, Integer::sum);

         if (sum == this.number) {
            return Classification.PERFECT;
        } else if (sum > this.number) {
            return Classification.ABUNDANT;
        } else {
            return Classification.DEFICIENT;
        }
        
    }
}
```

un diviseur propre, c'est quand le le nombre divisé par le diviseur donne un resultat entier
ChatGPT a dit :
ChatGPT
Oui, exactement ! Un diviseur propre d'un nombre entier 

Exemple :
Prenons le nombre 12 :

Diviseurs de 12 : 1, 2, 3, 4, 6, 12 (ce sont tous les entiers qui divisent 12 sans laisser de reste).
Diviseurs propres de 12 : 1, 2, 3, 4, 6 (on exclut 12 lui-même, car un diviseur propre est strictement inférieur au nombre).
Donc, pour être un diviseur propre :

Le diviseur doit diviser le nombre sans reste.
Le diviseur doit être strictement inférieur au nombre lui-même.
La somme aliquote est simplement la somme de ces diviseurs propres
