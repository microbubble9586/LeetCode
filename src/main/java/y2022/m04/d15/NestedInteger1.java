package y2022.m04.d15;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public interface NestedInteger1 {
    // Constructor initializes an empty nested list.
    //public NestedInteger();

    // Constructor initializes a single integer.
    //public NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class NestedInteger implements NestedInteger1 {
    Integer val;
    List<NestedInteger> list;


    public NestedInteger() {
        list = new ArrayList<>();
    }


    public NestedInteger(int value) {
        val = value;
    }

    @Override
    public boolean isInteger() {
        if (val != null) {
            return true;
        }
        return false;
    }

    @Override
    public Integer getInteger() {
        return val;
    }

    @Override
    public void setInteger(int value) {
        val = value;
    }

    @Override
    public void add(NestedInteger ni) {
        list.add(ni);
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}

class Solution {
    static NestedInteger SIGN = new NestedInteger(0);

    public static NestedInteger deserialize(String s) {
        Deque<NestedInteger> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        int length = chars.length;
        int i = 0;
        while (i < length) {
            if (chars[i] == ',' && ++i > 0) {
                continue;
            } else if (chars[i] == '[') {
                stack.addLast(new NestedInteger());
                stack.addLast(SIGN);
                i++;
            } else if (chars[i] == '-' || chars[i] >= '0' && chars[i] <= '9') {
                int j = chars[i] == '-' ? i + 1 : i;
                int num = 0;
                while (j < length && (chars[j] >= '0' && chars[j] <= '9')) {
                    num = num * 10 + (chars[j] - '0');
                    j++;
                }
                stack.addLast(new NestedInteger(chars[i] == '-' ? -num : num));
                i=j;
            } else {
                List<NestedInteger> list = new ArrayList<>();
                while (!stack.isEmpty()) {
                    NestedInteger nestedInteger = stack.pollLast();
                    if (nestedInteger == SIGN) {
                        break;
                    }
                    list.add(nestedInteger);
                }
                for (int j = list.size() - 1; j >= 0; j--) {
                    stack.peekLast().add(list.get(j));
                }
                i++;
            }
        }
        return stack.peekLast();
    }

    public static void main(String[] args) {
        deserialize("324");
    }
}
