public class RunLengthEncoding {

    static String encode(String str) {
        StringBuilder encodedString = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            int count = 1;

            // Count the consecutive occurrences of the current character
            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            // Append the character and its count to the encoded string
            encodedString.append(currentChar);
            encodedString.append(count);
        }

        return encodedString.toString();
    }

    public static void main(String[] args) {
        // Example usage:
        String str1 = "aaaabbbccc";
        System.out.println(encode(str1));  // Output: a4b3c3

        String str2 = "abbbcdddd";
        System.out.println(encode(str2));  // Output: a1b3c1d4
    }
}
