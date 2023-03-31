package dataStructures;

public class Stack<T> {

    StackNode<T> top;

    Stack(StackNode<T> t) {
        top = t;
    }

    Stack(T t) {
        top = new StackNode<T>(t);
    }

    public StackNode<T> peek() {
        return top;
    }

    public StackNode<T> pushData(T d) {
        StackNode<T> node = new StackNode<T>(d);
        if (top != null) {
            node.next = top;
        }
        top = node;
        return top;
    }

    public StackNode<T> pushNode(StackNode<T> n) {
        if (top != null) {
            n.next = top;
        }
        top = n;
        return top;
    }

    public StackNode<T> poll() {
        StackNode<T> curr = top;
        top = top.next;
        return curr;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
