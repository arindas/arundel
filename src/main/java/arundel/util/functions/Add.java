package arundel.util.functions;

import arundel.util.Function;

public class Add implements Function {

    /**
     * Creates a new instance of {@link Add}
     * @return a new {@link Add} instance
     */
    public static Add op() { return new Add(); }

    public int noOfInputs() { return 2; }

    public double operate(double... parameters) {
        if(parameters.length != noOfInputs())
            return Double.NaN;

        return parameters[0] + parameters[1];
    }

    public double[] derivatives(double... parameters) {
        return new double[]{1, 1};
    }
}
