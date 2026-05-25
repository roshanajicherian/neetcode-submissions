class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(')
                st.push(c);
            else {
                if (st.isEmpty())
                    return false;
                char popped = st.pop();
                if (!((c == '}' && popped == '{') || (c == ']' && popped == '[') || (c == ')' && popped == '(')))
                    return false;
            }
        }
        return st.isEmpty();
    }
}
