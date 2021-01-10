package week6.stacksAndQueue;

import org.junit.Test;

public class P1_155_MinStack {

	//@Test
	//public void 
}

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
*/

/*
class MinStack {
    
    Stack<Integer> s1,s2;
    //initialize your data structure here. 
    public MinStack() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
        if(s2.isEmpty()){
                s2.push(x);
        }else{
                s2.push(Math.min(s2.peek(),x));
        }
    }
    
    public void pop() {
        s1.pop();
        s2.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}
*/
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

