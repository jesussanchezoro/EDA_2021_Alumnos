package material.tree.narytree;

import material.Position;

import java.util.Iterator;

/**
 * A linked class for a tree where nodes have an arbitrary number of children.
 *
 * @author Raul Cabido, Abraham Duarte, Jose Velez, Jesús Sánchez-Oro
 * @param <E> the elements stored in the tree
 */
public class LCRSTree<E> implements NAryTree<E> {



    @Override
    public int size() {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public boolean isEmpty() {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public Position<E> root() throws RuntimeException {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public Position<E> parent(Position<E> v) throws RuntimeException {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public boolean isInternal(Position<E> v) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public boolean isLeaf(Position<E> v) throws RuntimeException {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public boolean isRoot(Position<E> v) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public Position<E> addRoot(E e) throws RuntimeException {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public Iterator<Position<E>> iterator() {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public E replace(Position<E> p, E e) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public void swapElements(Position<E> p1, Position<E> p2) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public Position<E> add(E element, Position<E> p) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public void remove(Position<E> p) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public void moveSubtree(Position<E> pOrig, Position<E> pDest) throws RuntimeException {
        throw new RuntimeException("Not yet implemented");
    }
}
