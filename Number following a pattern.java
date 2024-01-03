class Solution{
    static String printMinNumberForPattern(String S){
        // code here
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = S.length() + 1;

        for (int i = 0; i < n; i++) {
            stack.push(i + 1);

            if (i == n - 1 || S.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }

        return result.toString();
    }
}
