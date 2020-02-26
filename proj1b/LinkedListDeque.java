public class LinkedListDeque<T> implements Deque<T> {

    private Node sentinel;
    private int size;

    private class Node {

        private T item;
        private Node previous;
        private Node next;

        public Node(Node previous, T item, Node next) {

            this.previous = previous;
            this.item = item;
            this.next = next;
        }
    }

    public LinkedListDeque() {

        this.sentinel = new Node(null, null, null);
        this.sentinel.previous = this.sentinel;
        this.sentinel.next = this.sentinel;
        this.size = 0;
    }

    @Override
    public void addFirst(T item) {

        /* Set new node including pointers */
        Node p = new Node(sentinel, item, sentinel.next);

        /* Set sentinel next pointer */
        sentinel.next = p;

        /* Set the old first nodes previous pointer to point at the new first node */
        sentinel.next.next.previous = p;

        /* Increase the size of the list by one */
        this.size++;
    }

    @Override
    public void addLast(T item) {

        /* Set new node including pointers */
        Node p = new Node(sentinel.previous, item, sentinel);

        /* Set the old last nodes next pointer to point at the new last node */
        sentinel.previous.next = p;

        /* Set the previous pointer of the sentinel to point at the new last node */
        sentinel.previous = p;

        /* Increase the size of the list by one */
        this.size++;

    }

    @Override
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {

        return this.size;
    }

    @Override
    public void printDeque() {

        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
    }

    @Override
    public T removeFirst() {

        if (size == 0) {
            return null;
        }

        Node nodeToRemove = sentinel.next;

        /* Change the previous pointer of the second node to point at the sentinel  */
        nodeToRemove.next.previous = sentinel;

        /* Change the next pointer of the sentinel to point at the second node */
        sentinel.next = sentinel.next.next;

        /* Decrease size by one */
        size--;

        return nodeToRemove.item;
    }

    @Override
    public T removeLast() {

        if (size == 0) {
            return null;
        }

        Node nodeToRemove = sentinel.previous;

        /* Change the next pointer of the penultimate node to point at the sentinel  */
        nodeToRemove.previous.next = sentinel;

        /* Change the previous pointer of the sentinel to point at the penultimate node */
        sentinel.previous = sentinel.previous.previous;

        /* Decrease size by one */
        size--;

        return nodeToRemove.item;
    }

    @Override
    public T get(int index) {

        /* Return null if index is out of bounds */
        if (index > size) {
            return null;
        }

        /* Create pointer and point it at the sentinel */
        Node p = sentinel;

        int start = 0;

        while (start <= index) {
            p = p.next;
            start++;
        }

        return p.item;
    }

    public T getRecursive(int index) {

        Node p = sentinel;

        if (index == 0) {
            return p.next.item;
        }

        p = p.next;

        return getRecursive(index);
    }
}
