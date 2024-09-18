class RaindropConverter {
  
    String convert(int number) {
         StringBuilder sound = new StringBuilder();

        if (number % 3 == 0) {
            sound.append("Pling");
        }
        if (number % 5 == 0) {
            sound.append("Plang");
        }
        if (number % 7 == 0) {
            sound.append("Plong");
        }

        if (sound.length() == 0) {
            return String.valueOf(number);
        }

        return sound.toString();
    }

}

class RaindropConverter {
    String convert(int number) {
        String result = "";

        if (number % 3 == 0) result += "Pling";
        if (number % 5 == 0) result += "Plang";
        if (number % 7 == 0) result += "Plong";

        return result.isEmpty() ? String.valueOf(number) : result;
    }
}
