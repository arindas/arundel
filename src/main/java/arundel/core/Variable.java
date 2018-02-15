package arundel.core;

import java.util.List;
import java.util.ArrayList;


/**
* <p>
 * Class to implement a Variable as component in the computation graph.
 * Its is used as a souce of data for other Gates. It may be trained depeneding
 * upon its usage. If it is used as a parameted for optimization, it is trained using
 * {@link Gate#update}. Otherwise the implementation simply skips the update state.
 * Note that the update state is implicitly invoke in {@link #backward}, in the case
 * of a trainable {@link Variable}.
 * </p>
 */
public class Variable implements Gate {

    /* List of output Links */
    private List<Link> outputs;
    private double value; // value stored
    private boolean isTrainable;

    /**
     * Constructs an instance of a {@link Variable} {@link Gate}
     * with an empty list of output {@link Link}s and an
     * initial value and a trainable flag.
     * @param value initial value stored in this variable
     * @param isTrainable whether or not this Variable is trainable
     */
    public Variable(double value, boolean isTrainable) {
        this.value = value;
        this.isTrainable = isTrainable;
        outputs = new ArrayList<>();
    }

    /**
     * Constructs an instance of a {@link Variable} {@link Gate}
     * with an empty list of output {@link Link}s and an
     * initial value of 0.0d and non trainable status.
     */
    public Variable() { this(0, false); }

    public void setValue(double v) { value = v; }

    public double getValue() { return value; }

    public List<Link> inputs() { return null; }

    public List<Link> outputs() { return outputs; }

    public void forward() {
        for(Link link : outputs)
            link.setData(value);
    }

    public void backward() {
        // It has no inputs, hence no backward
        // computation is necessary for this gate

        // However, for training, update value using
        // backpropagated gradients
        if(isTrainable) update();
    }

    public void update() {
        double delta = 0;
        // for all links leaving this gate
        for(Link link : outputs) {
            // net change required is the sum
            // all the back propagated gradients
            delta += link.getData();
        }
        // update value
        value -= delta;
    }
}
