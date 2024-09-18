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
