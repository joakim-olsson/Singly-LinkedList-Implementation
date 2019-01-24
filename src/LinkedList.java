import java.util.NoSuchElementException;

/**
 * @Author: Joakim Olsson <lomo133>
 * @Date:   2019-01-24T16:55:54+01:00
 * @Last modified by:   lomo133
 * @Last modified time: 2019-01-24T16:57:03+01:00
 */

public class LinkedList<T> {
    private ListElement<T> first;   // First element in list.
    private ListElement<T> last;    // Last element in list.
    private int size;               // Number of elements in list.

    /**
     * A list element.
     */
    private static class ListElement<T> {
        public T data;
        public ListElement<T> next;

        public ListElement(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Creates an empty list.
     */
    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Inserts the given element at the beginning of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addFirst(T element) {
        ListElement<T> firstE = new ListElement<>(element);
        if (first == null)
            last = firstE;
        else {
            ListElement<T> prevFirst = first;
            firstE.next = prevFirst;
        }
        first = firstE;
        size++;
    }

    /**
     * Inserts the given element at the end of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addLast(T element) {
        ListElement<T> lastE = new ListElement<>(element);

        if (last == null)
            first = lastE;
        else {
            ListElement<T> prevLast = last;
            prevLast.next = lastE;
        }
        last = lastE;
        size++;
    }

    /**
     * @return The head of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getFirst() {
        if (first != null)
            return first.data;
        throw new NoSuchElementException();
    }

    /**
     * @return The tail of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getLast() {
        if (last != null)
            return last.data;
        throw new NoSuchElementException();
    }

    /**
     * Returns an element from a specified index.
     *
     * @param index A list index.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        int searchedIndex = 0;
        for (ListElement<T> element = first; element != null; element = element.next) {
            if (searchedIndex == index)
                return element.data;
            searchedIndex++;
        }
        return null; // Should not be able to execute
    }

    /**
     * Removes the first element from the list.
     *
     * @return The removed element.
     * @throws NoSuchElementException if the list is empty.
     */
    public T removeFirst() {
        if (size == 0)
            throw new NoSuchElementException();
        ListElement<T> firstE = first;
        if (size == 1) {
            first = null;
            last = null;
            size--;
            return firstE.data;
        }
        ListElement<T> nextE = firstE.next;
        first = nextE;
        size--;
        return firstE.data;
    }

    /**
     * Removes all of the elements from the list.
     */
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * @return The number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Note that by definition, the list is empty if both first and last
     * are null, regardless of what value the size field holds (it should
     * be 0, otherwise something is wrong).
     *
     * @return <code>true</code> if this list contains no elements.
     */
    public boolean isEmpty() {
        return first == null && last == null;
    }

    /**
     * Creates a string representation of this list. The string
     * representation consists of a list of the elements enclosed in
     * square brackets ("[]"). Adjacent elements are separated by the
     * characters ", " (comma and space). Elements are converted to
     * strings by the method toString() inherited from Object.
     *
     * Examples:
     *  "[1, 4, 2, 3, 44]"
     *  "[]"
     *
     * @return A string representing the list.
     */
    public String toString() {
        String returnString = "[";
        if (size != 0) {
            for (ListElement<T> index = first; index != null; index = index.next) {
                returnString += index.data + ", ";
            }
            return returnString.substring(0, returnString.length()-2) + "]";
        }
        returnString += "]";
        return returnString;
    }
}
