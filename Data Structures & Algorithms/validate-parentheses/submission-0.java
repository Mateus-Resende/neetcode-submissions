class Solution {

    private final Map<Character, Character> BRACKETS = Map.of('(', ')', 
                                                             '[', ']', 
                                                             '{', '}');
    
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (BRACKETS.keySet().contains(c)) {
                stack.push(c);
            } else if (stack.size() > 0 && BRACKETS.get(stack.peek()).equals(c)) {
                stack.pop();
            } else {
                return false;
            }
        }

        if (stack.size() > 0) return false;

        return true;        
    }
}
