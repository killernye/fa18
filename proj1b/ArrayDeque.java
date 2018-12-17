import static java.lang.System.arraycopy;

public class ArrayDeque<T> implements Deque<T> {

    private static final double usage = 0.25; // samllest usage factor

    private int size;
    private T[] items = (T[]) new Object[8];

    private int front; // front index of underlying array
    private int back; // back index of underlying array

    /* Invariants:
    *   f 0 1 2 3 4 5 6 b
    *   addFirst at f position
    *   addLast at b position
    *   when size = 0 f and b are at the same position
    *
    *   if f = b, array has been full
    *
     */
    public ArrayDeque() {}

    public ArrayDeque(T item) {
        size = 1;
        items[front] = item;
        front = left(front);
        back = right(back);
    }

    // resize the underlying array
    private void resize(double factor) {
        // copy old array to new array
        // find the first and end index
        // two conditions
        // reset front and back variables
        int first = right(front);
        int last = left(back);
        T[] a = (T[]) new Object[(int) (items.length * factor)];
        if (last >= first) {
            arraycopy(items, first, a, 0, size);
        } else {
            int s1 = items.length - first;;
            int s2 = size - s1;
            arraycopy(items, first, a, 0, s1);
            arraycopy(items, 0, a, s1, s2);
        }
        items = a;
        front = left(0);
        back = size;
    }

    // translate the abstract index to the actual index of the underlying array
    private int translate(int i) {
        if (i > size - 1) {
            return 0;
        }
        int first = right(front);
        int last = left(back);
        if (last >= first) {
            return first + i;
        } else if (i < items.length - first){
            return first + i;
        } else {
            return i - (items.length - first);
        }
    }

    // move forwards left side of the position at the array
    private int left(int i) {
        if (i == 0) {
            return items.length - 1;
        } else {
            return i - 1;
        }
    }

    // move forwards right side along the position of the array
    private int right(int i) {
        if (i == items.length - 1) {
            return 0;
        } else {
            return i + 1;
        }
    }


    // Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        if (size == 0) {
            back = right(back);
        }
        if (size == items.length) {
            resize(2);
        }
        items[front] = item;
        front = left(front);
        size += 1;
    }

    // Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        if (size == 0) {
            front = left(front);
        }
        if (size == items.length) {
            resize(2);
        }
        items[back] = item;
        back = right(back);
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
        System.out.print("[ ");
        for (int i = 0; i < size(); i += 1) {
            System.out.print(get(i) + " ");
        }
        System.out.println("]");
    }

    // Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        double ur = size * 1.0 / items.length;  // usage rate
        if (ur < usage && items.length > 8) {
            resize(0.5);
        }
//        if (size == 1) {
//            back = left(back);
//        }
        front = right(front);
        T first = items[front];
        items[front] = null;
        size -= 1;
        return first;
    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        double ur = size * 1.0 / items.length;
        if (ur < usage && items.length > 8) {
            resize(0.5);
        }
        back = left(back);
        T last = items[back];
        items[back] = null;
        size -= 1;
        return last;
    }

    // Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    // If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        return items[translate(index)];
    }
}
