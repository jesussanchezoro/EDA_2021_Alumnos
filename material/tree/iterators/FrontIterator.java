package material.tree.iterators;

import material.Position;
import material.tree.Tree;

import java.util.Iterator;

/**
 * Front iteartor for trees.
 *
 * @param <T>
 * @author jvelez, JD. Quintana
 */
public class FrontIterator<T> implements Iterator<Position<T>> {


    public FrontIterator(Tree<T> tree) {
        throw new RuntimeException("Not yet implemented");
    }


    public FrontIterator(Tree<T> tree, Position<T> node) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public boolean hasNext() {
        throw new RuntimeException("Not yet implemented");
    }

    /**
     * This method visits the nodes of a tree by following a breath-first search
     */
    @Override
    public Position<T> next() {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public void remove() {
        throw new RuntimeException("Not yet implemented");
    }
}
