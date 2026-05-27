class Solution {
    public int evalRPN(String[] tokens) {
               Deque<Integer> st = new ArrayDeque<>();
        for (String s : tokens) {
            if (!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")))
                st.push(Integer.valueOf(s));
            else {
                int secondOperand = st.pop();
                int firstOperand = st.pop();
                switch (s) {
                    case "+" -> st.push(firstOperand + secondOperand);
                    case "-" -> st.push(firstOperand - secondOperand);
                    case "*" -> st.push(firstOperand * secondOperand);
                    case "/" -> st.push(firstOperand / secondOperand);
                }
            }
        }
        return st.pop();
    }
}
