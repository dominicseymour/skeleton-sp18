public class ArrayDeque<T> implements Deque<T> {

    private int size;
    private T[] items;
    private int first;
    private int last;
    private double usageRatio;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        first = 0;
        last = items.length - 1;
        usageRatio = 1.0;
    }

    /** Inserts X into the front of the list. */
    @Override
    public void addFirst(T x) {

        /* Resize if array is full */
        if (size == items.length) {
            items = resize();
        }

        /* If the first item is in slot 0 then add the new first to the last slot
        *  If not then add it in the slot preceding the current first */
        if (first == 0) {
            first = items.length - 1;
        } else {
            first--;
        }

        /* Add the item to the array and increase the size */
        items[first] = x;
        size++;
    }

    /** Inserts X into the back of the list. */
    @Override
    public void addLast(T x) {

        /* Resize if array is full */
        if (size == items.length) {
            items = resize();
        }

        /* If the last item is in the final slot then add the new last item to the first slot
         *  If not then add it in the slot following the current first */
        if (last == items.length - 1) {
            last = 0;
        } else {
            last++;
        }

        /* Add the item to the array and increase the size */
        items[last] = x;
        size++;
    }

    /** Returns true if deque is empty, false otherwise. */
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /** Returns the number of items in the list. */
    @Override
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    @Override
    public void printDeque() {

        int start = first;
        for (int i = 0; i < size; i++) {
            System.out.print(items[start % items.length] + " ");
            start++;
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null. */
    @Override
    public T removeFirst() {

        updateUsageRatio();

        /* Reduce size of array if usage ratio is less than 25% */
        if (usageRatio < 0.25) {
            items = reduceArray();
        }

        /* Get the object in the first position */
        T remove = items[first];

        /* Set the array location to null */
        items[first] = null;

        /* Decrease the size */
        size--;

        /* Update the value of first */
        if (first == items.length - 1) {
            first = 0;
        } else {
            first++;
        }

        /* Return the object */
        return remove;
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null. */
    public T removeLast() {

        updateUsageRatio();

        /* Reduce size of array if usage ratio is less than 25% */
        if (usageRatio < 0.25) {
            items = reduceArray();
        }

        /* Get the object in the last position */
        T remove = items[last];

        /* Set the array location to null */
        items[last] = null;

        /* Decrease the size */
        size--;

        /* Update the value of last */
        if (last == 0) {
            last = items.length - 1;
        } else {
            last--;
        }

        /* Return the object */
        return remove;
    }

    /** Gets the ith item in the list (0 is the front). */
    @Override
    public T get(int i) {
        return items[i];
    }

    private T[] resize() {

        T[] newArray = (T[]) new Object[items.length * 2];
        System.arraycopy(items, first, newArray, 0, size - first);
        System.arraycopy(items, 0, newArray, size - first, size - (size - first));
        first = 0;
        last = size - 1;
        return newArray;
    }

    private void updateUsageRatio() {

        if (items.length < 16) {
            return;
        }

        usageRatio = (double) size / items.length;
    }

    private T[] reduceArray() {

        T[] newArray = (T[]) new Object[items.length / 2];

        /* If original array does not loop then just copy in one go */
        if (first < last) {
            System.arraycopy(items, first, newArray, 0, size);
        /* If original array loops then do two copies
        *  First one from first to the end
        *  Second from 0 to last */
        } else {
            System.arraycopy(items, first, newArray, 0, items.length - first);
            System.arraycopy(items, 0, newArray, items.length - first, last);
        }

        first = 0;
        last = size - 1;
        return newArray;
    }
}
