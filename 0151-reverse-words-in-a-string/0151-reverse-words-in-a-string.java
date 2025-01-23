class Solution {
    public String reverseWords(String s) {
        // Trim the input string to remove leading and trailing spaces
        String[] str = s.trim().split("\\s+");

        // Initialize the output string
        String out = "";

        // Iterate through the words in reverse order
        for (int i = str.length - 1; i > 0; i--) {
            // Append the current word and a space to the output
            out += str[i] + " ";
        }

        // Append the first word to the output (without trailing space)
        return out + str[0];
    }
}




/*
s.trim():
"Hello World Java"

.split("\\s+"):Splits the string into parts where one or more spaces appear:

Result: ["Hello", "World", "Java"]

Result Stored in str:
str[0] = "Hello"
str[1] = "World"
str[2] = "Java"

trim() removes only leading and trailing spaces.
split("\\s+") handles all kinds of whitespace and collapses multiple spaces into a single split point. 
*/