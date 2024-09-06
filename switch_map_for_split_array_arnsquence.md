```java
import java.util.List;
import java.util.ArrayList;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        List<String> listOfProteins = new ArrayList<>();

        if (rnaSequence.isEmpty()) {
            return listOfProteins;
        }
        
        String[] arrOfCodon = rnaSequence.split("(?<=\\G.{3})");
        for(String codon : arrOfCodon) { 

            if (codon.length() != 3) {
                throw new IllegalArgumentException("Invalid codon");
            }
            
        String protein = switch(codon) {
            case "AUG" -> "Methionine";
            case "UUU","UUC" -> "Phenylalanine";
            case "UUA", "UUG" -> "Leucine";
            case "UCU", "UCC","UCA", "UCG" -> "Serine";
            case "UAU", "UAC" ->  "Tyrosine";
            case "UGU", "UGC" -> "Cysteine";
            case "UGG" -> "Tryptophan";
            case "UAA", "UAG", "UGA" -> "STOP";
            default -> throw new IllegalArgumentException("Invalid codon");
        };
            if(!protein.equals("STOP")) {
                listOfProteins.add(protein);
            } else {
                break;
            }
        }

        return listOfProteins;
    }
}
```


ou


```java
import java.util.*;

public class ProteinTranslator {

    // Dictionnaire de codons pour les acides aminés
    private static final Map<String, String> CODON_TO_PROTEIN = new HashMap<>() {{
        put("AUG", "Methionine");
        put("UUU", "Phenylalanine");
        put("UUC", "Phenylalanine");
        put("UUA", "Leucine");
        put("UUG", "Leucine");
        put("UCU", "Serine");
        put("UCC", "Serine");
        put("UCA", "Serine");
        put("UCG", "Serine");
        put("UAU", "Tyrosine");
        put("UAC", "Tyrosine");
        put("UGU", "Cysteine");
        put("UGC", "Cysteine");
        put("UGG", "Tryptophan");
        put("UAA", "STOP");
        put("UAG", "STOP");
        put("UGA", "STOP");
    }};

    public List<String> translate(String rnaSequence) {
        List<String> proteinSequence = new ArrayList<>();

        // Parcours de la séquence par groupes de 3 (codons)
        for (int i = 0; i < rnaSequence.length(); i += 3) {
            if (i + 3 > rnaSequence.length()) {
                throw new IllegalArgumentException("Invalid codon");
            }
            String codon = rnaSequence.substring(i, i + 3);
            String protein = CODON_TO_PROTEIN.get(codon);

            if (protein == null) {
                throw new IllegalArgumentException("Invalid codon");
            }

            // Si on rencontre un codon STOP, on arrête la traduction
            if (protein.equals("STOP")) {
                break;
            }

            proteinSequence.add(protein);
        }

        return proteinSequence;
    }
}
```
