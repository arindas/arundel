package arundel.core;

import java.util.List;

/**
 * A {@link Gate} is the basic building block for the computational directed acyclic graph (DAG).
 * A gate has certain inputs, it can perform some computation on these inputs
 * and produces some outputs as a result of this computation, which in turn
 * maybe the inputs for some other {@link Gate}s.
 *
 * @author Arindam Das
 * @version 0.0.1b
 */
public interface Gate {

    /**
     * Method to compute the forward
     * computation for this gate.
     */
    void forward();

    /**
     * Method to compute the backward
     * computation for this gate.
     */
    void backward();

    /**
     * Update the parmameters of this gate on
     * the basis of backward computation.
     */
    void update();

    /**
     * Returns the list of input links (incoming edges) for this Gate.
     * @return a {@link java.util.List} of {@link arundel.core.Link}s
     */
    List<Link> inputs();

    /**
     * Returns the list of output links (outgoing edges) for this Gate.
     * @return a {@link java.util.List} of {@link arundel.core.Link}s
     */
    List<Link> outputs();
}
