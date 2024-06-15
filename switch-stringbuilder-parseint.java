class ResistorColorDuo {
    int value(String[] colors) {
        StringBuilder value = new StringBuilder();
        for(int i = 0; i < 2; i++ ) {
            int code = switch(colors[i]) {
                case "black" -> 0;
                case "brown" -> 1;
                case "red" -> 2;
                case "orange" -> 3;
                case "yellow" -> 4;
                case "green" -> 5;
                case "blue" -> 6;
                case "violet" -> 7;
                case "grey" -> 8;
                case "white" -> 9;
                default -> throw new IllegalArgumentException("Couleur inconnue");
            };
        value.append(code);
        }

        return Integer.parseInt(value.toString());
    }
}


class RnaTranscription {

    String transcribe(String dnaStrand) {
        if(dnaStrand.isEmpty()) {
            return "";
        }
        StringBuilder rnaStrand = new StringBuilder();
        for(int i = 0; i < dnaStrand.length(); i++) {
            char dnaChar = dnaStrand.charAt(i);
        String rnaLetter = switch(dnaChar) {
            case 'G' -> "C";
            case 'C' -> "G";
            case 'T' -> "A";
            case 'A' -> "U";
            default -> throw new IllegalArgumentException("Not DNA");
        };
        rnaStrand.append(rnaLetter);
        }
        
        return rnaStrand.toString();
    }
}
