class Solution {

    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder(); // To store the final result
        int count = 0; // Counter to track depth of parentheses

        for (char c : s.toCharArray()) { // Iterate through each character in the string
            if (c == '(') {
                if (count > 0) {
                    result.append(c); // Add '(' only if it is not an outermost parenthesis
                }
                count++; // Increment depth for '('
            } else if (c == ')') {
                count--; // Decrement depth for ')'
                if (count > 0) {
                    result.append(c); // Add ')' only if it is not an outermost parenthesis
                }
            }
        }

        return result.toString(); // Return the result as a string
    }
}

//NOTE
//The condition if (count > 0) ensures that only non-outermost opening parentheses (() are added to the result, while count++ ensures the depth is accurately tracked for future iterations.
