package material.linear;

import material.Position;


/**
 * Realization of a PositionList using a doubly-linked list of nodes.
 *
 * @author A. Duarte, J. Vélez, J. Sánchez-Oro
 * @param <E> the generic type of the list
 */
public class DoubleLinkedList<E> implements List<E> {

    private class DNode<T> implements Position<T> {

        private DNode<T> prev, next; // References to the nodes before and after
        private T element; // Element stored in this position
        private final DoubleLinkedList<T> myList; //Reference to the object that contains each node

        /**
         * Constructor
         */
        public DNode(DNode<T> newPrev, DNode<T> newNext, T elem, DoubleLinkedList<T> l) {
            prev = newPrev;
            next = newNext;
            element = elem;
            myList = l;
        }

        @Override
        public T getElement() {
            return element;
        }

        /**
         * Accesses to the next element
         *
         * @return the next element in the list
         */
        public DNode<T> getNext() {
            return next;
        }

        /**
         * Accesses to the previous element
         *
         * @return the previous element in the list
         */
        public DNode<T> getPrev() {
            return prev;
        }

        /**
         * Modifies the next element
         *
         * @param newNext the new next element
         */
        public void setNext(DNode<T> newNext) {
            next = newNext;
        }

        /**
         * Modifies the previous element
         *
         * @param newPrev the new previous element
         */
        public void setPrev(DNode<T> newPrev) {
            prev = newPrev;
        }

        /**
         * Modifies the current element
         *
         * @param newElement The new current element
         */
        public void setElement(T newElement) {
            element = newElement;
        }

        /**
         * Accesses to the list where the DNode belongs to
         *
         * @return the list of the DNode
         */
        DoubleLinkedList<T> getMyList() {
            return this.myList;
        }
    }

    protected int size; // Number of elements in the list
    protected DNode<E> header, trailer; // Special sentinels

    /**
     * Constructor that creates an empty list; O(1) time
     */
    public DoubleLinkedList() {
        this.size = 0;
        this.header = null;
        this.trailer = null;
    }

    /**
     * Checks if position is valid for this list and converts it to DNode if it
     * is valid; O(1) time
     *
     * @param p the position to check
     * @return the position converted to DNode
     * @throws RuntimeException
     */
    private DNode<E> checkPosition(Position<E> p) throws RuntimeException {
        if (p == null || !(p instanceof DNode)) {
            throw new RuntimeException("The position is either null or not an instance of DNode");
        }

        DNode<E> node = (DNode<E>) p;
        if (this != node.getMyList()) {
            throw new RuntimeException("The position refers to a node not in this list");
        }
        return node;
    }


    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public Position<E> first() throws RuntimeException {
        if (this.isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        return this.header;
    }


    @Override
    public Position<E> last() throws RuntimeException {
        if (this.isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        return this.trailer;
    }

    @Override
    public Position<E> prev(Position<E> p) throws RuntimeException {
        DNode<E> node = checkPosition(p);
        DNode<E> prev = node.getPrev();
        if (prev == null) {
            throw new RuntimeException("Cannot advance past the beginning of the list");
        }
        return prev;
    }

    @Override
    public Position<E> next(Position<E> p) throws RuntimeException {
        DNode<E> node = checkPosition(p);
        DNode<E> next = node.getNext();
        if (next == null) {
            throw new RuntimeException("Cannot advance past the end of the list");
        }
        return next;
    }

    
    @Override
    public Position<E> addBefore(Position<E> p, E element) throws RuntimeException {
        DNode<E> node = checkPosition(p);
        DNode<E> newNode;
        if (node == this.header) {
            newNode = new DNode<E>(null, node, element, this);
            node.setPrev(newNode);
            this.header = newNode;
        } else {
            newNode = new DNode<E>(node.getPrev(), node, element, this);
            node.getPrev().setNext(newNode);
            node.setPrev(newNode);
        }
        this.size++;
        return newNode;
    }

    
    @Override
    public Position<E> addAfter(Position<E> p, E element) throws RuntimeException {
        DNode<E> node = checkPosition(p);
        DNode<E> newNode;
        if (node == this.trailer) {
            newNode = new DNode<E>(node, null, element, this);
            node.setNext(newNode);
            this.trailer = newNode;
        } else {
            newNode = new DNode<E>(node, node.getNext(), element, this);
            node.getNext().setPrev(newNode);
            node.setNext(newNode);
        }
        size++;
        return newNode;
    }

    @Override
    public Position<E> addFirst(E element) {
        DNode<E> newNode;
        if (this.isEmpty()) {
            newNode = new DNode<E>(null, null, element, this);
            this.header = newNode;
            this.trailer = newNode;
        } else {
            newNode = new DNode<E>(null, this.header, element, this);
            this.header.setPrev(newNode);
            this.header = newNode;
        }
        size++;
        return newNode;
    }

    @Override
    public Position<E> addLast(E element) {
        DNode<E> newNode;
        if (this.isEmpty()) {
            newNode = new DNode<E>(null, null, element, this);
            this.header = newNode;
            this.trailer = newNode;
        } else {
            newNode = new DNode<E>(this.trailer, null, element, this);
            this.trailer.setNext(newNode);
            this.trailer = newNode;
        }
        size++;
        return newNode;
    }

    
    @Override
    public E remove(Position<E> p) throws RuntimeException {
        DNode<E> node = checkPosition(p);
        E elem = node.getElement();
        if (this.trailer == this.header) {
            this.trailer = null;
            this.header = null;
        } else if (node == this.header) {
            this.header = this.header.getNext();
        } else if (node == this.trailer) {
            this.trailer = this.trailer.getPrev();
        } else {
            DNode<E> nodePrev = node.getPrev();
            DNode<E> nodeNext = node.getNext();
            nodePrev.setNext(nodeNext);
            nodeNext.setPrev(nodePrev);
        }
        size--;
        return elem;
    }

    
    @Override
    public E set(Position<E> p, E element) throws RuntimeException {
        DNode<E> node = checkPosition(p);
        E oldElt = node.getElement();
        node.setElement(element);
        return oldElt;
    }

    // Convenience methods
    /**
     * Checks if a position is the first one in the list; O(1) time
     *
     * @param p the position to check
     * @return TRUE if p is the first position, FALSE otherwise
     */
    public boolean isFirst(Position<E> p) throws RuntimeException {
        DNode<E> v = checkPosition(p);
        return v == header;
    }

    /**
     * Checks if a position is the last one in the list; O(1) time
     *
     * @param p the position to check
     * @return TRUE if p is the last position, FALSE otherwise
     */
    public boolean isLast(Position<E> p) throws RuntimeException {
        DNode<E> v = checkPosition(p);
        return v == trailer;
    }

    /**
     * Swaps the elements of two give positions; O(1) time
     *
     * @param a the first position to swap
     * @param b the second position to swap
     */
    public void swapElements(Position<E> a, Position<E> b)
            throws RuntimeException {
        DNode<E> pA = checkPosition(a);
        DNode<E> pB = checkPosition(b);
        E temp = pA.getElement();
        pA.setElement(pB.getElement());
        pB.setElement(temp);
    }


}
