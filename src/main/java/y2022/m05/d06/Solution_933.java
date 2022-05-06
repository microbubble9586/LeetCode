package y2022.m05.d06;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_933 {
    class RecentCounter {
        Deque<Integer> queue;
        public RecentCounter() {
            queue = new ArrayDeque();
        }

        public int ping(int t) {
            queue.addLast(t);
            while (queue.peekFirst()!=null&&queue.peekFirst()<(t-3000)){
                queue.pollFirst();
            }
            return queue.size();
        }
    }

}
