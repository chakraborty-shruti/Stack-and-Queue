/* Implementation of Stack Using two Queue
 * Stack is Last In First Out and Queue is First In First Out
 * So we use two queue to solve this problem
 * The new element (x) is first added to q2
 * All element from q1 are then moved to q2 , ensuring that x is at the front
 * Swap q1 ans q2 : now q1 contains elements i the correct stack order
 */

import java.util.LinkedList;
import java.util.Queue;

class Test{

    static class Stack {
        
        static Queue<Integer> q1 = new LinkedList<Integer>();
        static Queue<Integer> q2 = new LinkedList<Integer>();

        static int curr_size;

        static void push(int x){
            //Push x first in empty queue
            q2.add(x);

            //Push all the remaining elements in q1 to q2.
            while(q1.isEmpty() == false){
                q2.add(q1.peek());
                q1.remove();
            }

            //swap the ames of two queues
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
        }

        static void pop(){
            if(q1.isEmpty()) return;
            q1.remove();
        }

        static int top(){
            if (q1.isEmpty()) 
                return -1;
            return q1.peek();
            
        }

        static int size(){return q1.size(); }
    }

    public static void main(String[] args){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("current size :"+ s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());

        System.out.println("current size:"+ s.size());
    }
}