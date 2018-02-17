package arundel.core;

import java.util.List;
import java.util.ArrayList;

/**
A {@link Placeholder} is essentially a non-trainable {@link Gate} for storing labels. It may be used to
store the result of some computation or some labels which will be compared against to
estimate the loss of a model.

Placeholders are intended to be added to the computation graph at the penultimate
state of computation, mostly as an input to the loss function. Hence, it is intuititve
to limit the number of outputs of this gate to one. However, this {@link Gate} doesn't
place such restrictions.
 */

public final class Placeholder implements Gate {

    // value stored in this gate
    private double value;
    private List<Link> outputs;

    /**
     * Creted a Placeholder with an inital value.
     * @param value the value to be stored
     */
    public Placeholder(double value) {
        this.value = value;
        this.outputs =  new ArrayList<>();
    }

    /**
     * Returns the value stored in this {@link Gate}
     * @return the vlaue stored
     */
    public double getValue() { return value; }

    /**
     * Sets the value stored in this {@link Gate}
     * @param value the value to be stored
     */
    public void setValue(double value) { this.value = value; }

    public void forward() {
        // 'forward' the date the output links
        for(Link link : outputs)
            link.setData(value);
    }

    /**
     * Doesn't perform any computation as ther are no inputs
     * to backpropagate into.
     */
    public void backward() { }

    /**
     * Doesn't perform any computation as this
     * {@link Gate} is essentially non-trainable.
     */
    public void update() { }

    public List<Link> outputs() { return outputs; }

    public List<Link> inputs() { return null; }
}
