```java
class MicroBlog {
    public String truncate(String input) {
        return input.codePoints() 
                    .limit(5)
                    .collect(StringBuilder::new,
                            StringBuilder::appendCodePoint,
                            StringBuilder::append)
                    .toString();
    }
}

// codePoints(): This method returns an IntStream of Unicode codepoints from the string. This is important because it correctly handles characters that are represented by multiple char values (like emojis).
