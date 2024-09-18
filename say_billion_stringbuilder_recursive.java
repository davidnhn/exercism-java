public class Say {
    
    // Tableau des unités et des nombres spéciaux
    private static final String[] UNITS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", 
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", 
        "seventeen", "eighteen", "nineteen"};
    
    // Tableau des dizaines
    private static final String[] TENS = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
    
    public String say(long number) {
        // Vérification de la plage
        if (number < 0 || number >= 1_000_000_000_000L) {
            throw new IllegalArgumentException("Number is out of range");
        }

        if(number < 20) {
            return UNITS[(int) number];
        } else if (number < 100) {
            return handleTens((int) number);
        } else  {
            return handleLargeNumbers(number);
        } 
    }

    private String handleTens(int number) {
        int tens = number / 10;
        int units = number % 10;

        if(units == 0) {
            return TENS[tens];
        } else {
            return TENS[tens] + "-" + UNITS[units];
        }
    }

    private String handleLargeNumbers(long number) {
        if(number < 1_000) {
            return handleHundreds((int) number);
        } else if(number < 1_000_000) {
            return handleThousands(number);
        } else if(number < 1_000_000_000) {
            return handleMillions(number);
        } else {
            return handleBillions(number);
        }
    }

    private String handleHundreds(int number) {
        int hundreds = number / 100;
        int remainder = number % 100;

        if(remainder == 0) {
            return UNITS[hundreds] + " hundred";
        } else {
            return UNITS[hundreds] + " hundred " + say(remainder);
        }
    }

    private String handleThousands(long number) {
        long thousands = number / 1_000;
        long remainder = number % 1_000;

        if(remainder == 0) {
            return say(thousands) + " thousand";
        } else {
            return say(thousands) + " thousand " + say(remainder);
        }
    }

    private String handleMillions(long number) {
        long millions = number / 1_000_000;
        long remainder = number % 1_000_000;

        if(remainder == 0) {
            return say(millions) + " million";
        } else {
            return say(millions) + " million " + say(remainder);
        }
    }

    private String handleBillions(long number) {
        long billions = number / 1_000_000_000;
        long remainder = number % 1_000_000_000;

         if(remainder == 0) {
            return say(billions) + " billion";
        } else {
            return say(billions) + " billion " + say(remainder);
        }
    }
    
}







import java.util.HashMap;
import java.util.Map;

public class Say {

    // Tableaux pour les unités, dizaines et puissances de mille
    private static final String[] UNITS = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", 
                                           "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", 
                                           "seventeen", "eighteen", "nineteen"};
    
    private static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    
    private static final String[] THOUSANDS = {"", "thousand", "million", "billion"};

    public String say(long number) {
        if (number < 0 || number >= 1_000_000_000_000L) {
            throw new IllegalArgumentException("Number is out of range");
        }
        
        if (number == 0) return "zero";

        return convertNumberToWords(number);
    }

    // Fonction principale pour convertir un nombre en mots
    private String convertNumberToWords(long number) {
        StringBuilder result = new StringBuilder();
        
        // Divise le nombre en groupes de milliers
        for (int i = 0; number > 0; i++) {
            if (number % 1000 != 0) {
                result.insert(0, convertChunk((int)(number % 1000)) + " " + THOUSANDS[i] + " ");
            }
            number /= 1000;
        }

        return result.toString().trim();
    }

    // Convertit une "tranche" de trois chiffres en mots
    private String convertChunk(int number) {
        StringBuilder chunk = new StringBuilder();

        if (number >= 100) {
            chunk.append(UNITS[number / 100]).append(" hundred ");
            number %= 100;
        }

        if (number >= 20) {
            chunk.append(TENS[number / 10]);
            if (number % 10 != 0) {
                chunk.append("-").append(UNITS[number % 10]);
            }
        } else if (number > 0) {
            chunk.append(UNITS[number]);
        }

        return chunk.toString().trim();
    }
}

