class IntegerStackExample {
    public static void main(String[] args) {
        IStack stack = new ArrayStack();

        stack.push(7);
        stack.push(13);

        System.out.println(stack.top());    // 13
        stack.pop();                        
        stack.push(9);
        System.out.println(stack.top());    // 9
        System.out.println(stack.top());    // 9
        stack.pop();                        
        System.out.println(stack.size());   // 1
    }
}