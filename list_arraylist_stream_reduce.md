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
