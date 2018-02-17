package arundel.core;

import java.util.List;
import java.util.ArrayList;


/**
 * <p>
 * Class to implement a Variable as component in the computation graph.
 * It does not per form any backward computation since it does not have
 * any inouts. However, it retrieves the gradients from its output {@link Link}s
 * and uses them to update the value stored.
 * </p>
 */
public final class Variable implements Gate {

    /* List of output Links */
    private List<Link> outputs;
    private double value; // value stored

    /**
     * Constructs an instance of a {@link Variable} {@link Gate}
     * with an empty list of output {@link Link}s and an
     * initial value and a trainable flag.
     * @param value initial value stored in this variable
     */
    public Variable(double value) {
        this.value = value;
        outputs = new ArrayList<>();
    }

    /**
     * Setter method for value stored in this variable
     * @param v value to be stored
     */
    public void setValue(double v) { value = v; }

    /**
     * Getter method for value stored
     * @return the value stored in the this variable
     */
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
        update();
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
