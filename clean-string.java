class SqueakyClean {
    static String clean(String identifier) {
        identifier = identifier.replaceAll("[^a-zA-Z0-9\\s-]", "");
         identifier = identifier.replace(' ', '_');

        identifier = identifier.replace('4', 'a').replace('3', 'e').replace('0', 'o').replace('1', 'l').replace('7', 't');

        String[] parts = identifier.split("-");

        

        StringBuilder result = new StringBuilder();

       

        if(parts.length > 0) {
            result.append(parts[0]);
        }

        for(int i=1; i < parts.length; i++) {
            if(parts[i].length() > 0) {
                result.append(Character.toUpperCase(parts[i].charAt(0)));
                result.append(parts[i].substring(1).toLowerCase());
            }
        }

        return result.toString();
    }
}
