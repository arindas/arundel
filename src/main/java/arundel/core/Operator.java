package arundel.core;

import java.util.List;
import java.util.ArrayList;

import arundel.util.Function;

public class Operator implements Gate {

    /* function to be used for
       operating on parameters */
    private Function function;

    /* Links to this gate */
    private List<Link> inputs, outputs;

    /**
     * Creates an instance of {@link Operator} using a {@link arundel.util.Function}
     * @param function the funtion to be used for operating on the parameters
     */
    public Operator(Function function) {
        this.function = function;
        inputs = new ArrayList<>();
        outputs = new ArrayList<>();
    }

    /**
     * Initializes the inputs of this gate using the given list of
     * parameters. It essentially establishes the required links between
     * the invoking object and the parmter gates. Note that this method
     * essentially responsible for establishing edges in the computation DAG
     * @param gates the gates to receive inputs from
     */
    public void initialize(Gate... gates) {
        if(gates.length != function.noOfInputs())
            throw new RuntimeException("Invalid no of parameters.");

        for(Gate gate : gates) {
            Link link = new Link(gate, this);
            inputs.add(link);
            gate.outputs().add(link);
        }
    }

    public List<Link> inputs() { return inputs; }

    public List<Link> outputs() { return outputs; }

    private double[] getParameters() {
        // initialize list of parameters
        double[] params = new double[function.noOfInputs()];
        // obtain input values from input links
        int index = 0;
        for(Link link : inputs)
            params[index++] = link.getData();

        return params;
    }

    public void forward() {

        // compute the result from parameters
        double result = function.operate(getParameters());

        // write the result to the output links
        for(Link link : outputs)
            link.setData(result);

    }

    public void backward() {
        // receive total gradient from suceeding gates
        double receivedGradient = 0;
        for(Link link : outputs)
            receivedGradient += link.getData();

        // collect partial derivatives
        double[] derivatives =
            function.derivatives(getParameters());

        // backpropagate gradients
        for(int i = 0; i < inputs.size(); i++)
            inputs.get(i).setData(receivedGradient * derivatives[i]);

        // update... LOL
        update();
    }

    // Is an Operator trainable?
    public void update() {}

}
