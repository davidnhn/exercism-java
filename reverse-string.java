class ReverseString {

    String reverse(String inputString) {
        // StringBuilder reversedString = new StringBuilder();
        // reversedString.append(inputString);
        // reversedString.reverse();

        // return reversedString.toString();

        char ch;
        String newString= "";

        for(int i=0; i < inputString.length();i++) {
            ch = inputString.charAt(i);
            newString = ch + newString;
        }

        return newString;
    }
  
}
