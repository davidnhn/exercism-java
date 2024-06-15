class Acronym {

    String phrase;

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        StringBuilder acronym = new StringBuilder();
        String[] words = this.phrase.split("[\\s-_]+");

        for(String word : words) {
            char letterToKeep = word.charAt(0);
            acronym.append(Character.toUpperCase(letterToKeep));
        }
 
        return acronym.toString();
    }

}
