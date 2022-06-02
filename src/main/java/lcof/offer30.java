package lcof;

import java.util.LinkedList;

public class offer30 {
    class MinStack{
        LinkedList<Integer> stack, min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new LinkedList();
            min = new LinkedList();
        }

        public void push(int x) {
            stack.push(x);
            if (min.isEmpty()) {
                min.push(x);
            } else {
                int cur = min.peek();
                min.push(Math.min(cur, x));
            }

        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
                min.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min.peek();
        }
    }

}
