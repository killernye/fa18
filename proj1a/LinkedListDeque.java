public class LinkedListDeque<T> {

    private class Node {
        T item;
        Node next;
        Node prev;

        public Node(T f, Node n, Node p) {
            item = f;
            next = n;
            prev = p;
        }

        public Node(T f) {
//            first = f;
//            next = null;
            this(f, null, null);
        }

    }

    private Node sentinel = new Node(null);
    private int size;

    public LinkedListDeque() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(T item) {
        super();
        Node first = new Node(item);
        sentinel.next = first;
        first.prev = sentinel;
        size += 1;
    }


    // Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        Node first = new Node(item);
        first.next = sentinel.next;
        sentinel.next.prev = first;
        first.prev = sentinel;
        sentinel.next = first;
        size += 1;
    }

    // Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        Node last = new Node(item);
        last.next = sentinel;
        last.prev = sentinel.prev;
        sentinel.prev.next = last;
        sentinel.prev = last;
        size += 1;
    }

    // Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the number of items in the deque.
    public int size() {
        return size;
    }

    // Prints the items in the deque from first to last, separated by a space.
    public void printDeque() {
        Node ptr = sentinel.next;
        System.out.print("[ ");
        while (ptr != sentinel) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
        System.out.println("]");
    }

    // Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node removed = sentinel.next;
        sentinel.next = removed.next;
        removed.next.prev = sentinel;

        size -= 1;
        return removed.item;
    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node removed  = sentinel.prev;
        removed.prev.next = sentinel;
        sentinel.prev = removed.prev;

        size -= 1;
        return removed.item;
    }

    // Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    // If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        if (index > size - 1) {
            return null;
        }

        Node ptr = sentinel.next;
        while (index > 0) {
            index -= 1;
            ptr = ptr.next;
        }
        return ptr.item;
    }

    // Same as get, but uses recursion.
    public T getRecursive(int index) {
        if (index > size - 1) {
            return null;
        }

        return getRecursive(sentinel.next, index);
    }

    private T getRecursive(Node n, int index) {
        if (index == 0) {
            return n.item;
        } else {
            return getRecursive(n.next, index - 1);
        }
    }

}
