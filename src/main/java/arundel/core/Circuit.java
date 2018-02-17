package arundel.core;

import java.util.Set;
import java.util.HashSet;

/**
 * <p>
 * Class {@link Circuit} encapsulates a computational directed acyclic graph
 * of {@link Gate}s. The most important properties of this class are :<br>
 * </p>
 * <pre>
 * 1. All instances of {@link Circuit} contain a set of operators
 *    placeholders and variables.
 * 2. All computation is performed from the data
 *    - retreived from the variables,
 *    - performed in the Operators, and
 *    - stored in the placeholders.
 *    - compared with labels stored in the placeholders
   </pre>
 *
 * <p>
 * More specifically, the variables happen to be the roots of the computation DAG,
 * the operators are internal nodes. Note that any terminal {@link Gate} is the leaf of
 * this computation DAG.
 * </p>
 *
 * <p>
 * In the computation step for the Circuit, first, all the {@link Gate}s are
 * sorted topologically. Then for each {@link Gate} in this ordered list
 * the {@link Gate#forward} method is invoked for the forward computation.
 * For backproagation, all the Gates are sorted in the reverse topological order
 * and then the {@link Gate#backward} method is invoked for backproagation.
 * During backpropagation, the {@link Gate#backward} method invokes the
 * {@link Gate#update} method which is used for updating the gate parmeters.
 * </p>
 */
public class Circuit {

    /** Gates in the computation Circuit */
    private Set<Gate> gates = new HashSet<>();

    // Placeholders for labelled data
    private Set<Placeholder> placeholders = new HashSet<>();
    // Variables for storing trainable data
    private Set<Variable> variables = new HashSet<>();
    // Operators for performing and branching computation
    private Set<Operator> operators = new HashSet<>();

    /**
     * Adds a gate to the computation DAG i.e this Circuit.
     * @param gate the gate to be added
     */
    public void addGate(Gate gate) {
        if(gate instanceof Operator)
            operators.add((Operator)gate);
        else if(gate instanceof Variable) {
            variables.add((Variable)gate);
        } else {
            placeholders.add((Placeholder)gate);
        } gates.add(gate);
    }

    public Set<Gate> gates() { return gates; }

    public Set<Placeholder> placeholders() { return placeholders; }

    public Set<Operator> operators() { return operators; }

    public Set<Variable> variables() { return variables; }
}
