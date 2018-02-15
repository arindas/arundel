package arundel.util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;

import arundel.core.Circuit;
import arundel.core.Gate;
import arundel.core.Link;

/**
 * <p>
 * Class to encapsulate the topological sorting algorithm. Instances of this
 * class, sort the {@link Gate}s in {@link Circuit} topologically and return
 * them as a {@code List<Gate>}.
 * </p>
 *
 */

public class TopologicalSorter {

    /* DAG whose nodes are to be sorted */
    private Circuit dag;
    /* Set of gates to be topologically sorted */
    private Set<Gate> universe;
    /* Mark assocaited with every gate */
    private Map<Gate, Boolean> isMarked;
    /* List of sorted of Gates */
    private List<Gate> sorted;


    /**
     * Constructs an instance of a {@link TopologicalSorter}
     * from a {@link arundel.core.Circuit}
     * @param dag the {@link arundel.core.Circuit} whose computation graph is
     *  to be topologically sorted
     */
    public TopologicalSorter(Circuit dag) {
        this.universe = dag.gates();
        this.isMarked = new HashMap<>();
        this.sorted = new ArrayList<>();
    }

    /**
     * <p>
     * Visits this {@link Gate}s and its adjacent gates recursively, in order to
     * order them in a topologically sorted manner. At first the parameter
     * {@link Gate} is temporarily marked and all the {@link Gate}s topologically below it
     * are recursively visited. If in this process the temporarily marked gate is
     * visited again, it is evident that there exists a cycle in the computation
     * graph which is not permissible. Hence if a cycle is found a {@link InvalidDAGException}
     * is thrown. If, however all the gates below the given gate are suceessfully visited,
     * it is marked and is added to head of the list of sorted gates.
     * </p>
     * @param g the gate to be visited
     * @throws InvalidDAGException when a cycle is found
     */
    public void visit(Gate g) throws InvalidDAGException {
        if(isMarked.get(g) == null) // unmarked
            isMarked.put(g, false); // mark temporarily

        else if(isMarked.get(g))    // permanently marked
            return;                 // done with this Gate

        else if(!isMarked.get(g))   // cycle found
            throw new InvalidDAGException("Cycle found in the given DAG.");

        // for every output link of this gate
        for(Link output : g.outputs())
            visit(output.sink); // visit the sink gate recursively

        isMarked.put(g, true); // mark permanently
        sorted.add(0, g);
    }

    /**
     * Returns the sorted list of {@link arundel.core.Gate}s as
     * a {@link java.util.List} as a result of the sorting. It invokes
     * {@link #visit} for every unmarked Gate in the {@link Circuit}.
     * @return The sorted {@link java.util.List} of
     * {@link arundel.core.Gate}
     * @throws InvalidDAGException when a cycle is found
     */
    public List<Gate> sort() throws InvalidDAGException {
        // for every the 'universe'
        for(Gate gate : universe)
            if(isMarked.get(universe) == null)
                visit(gate); // if not marked visit it

        return sorted;
    }
}

/**
 * Exception class to denote invalid DAGs.
 */
class InvalidDAGException extends Exception {
    public InvalidDAGException(String cause) {
        super(cause);
    }
}
