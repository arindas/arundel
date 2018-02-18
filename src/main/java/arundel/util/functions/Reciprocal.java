package arundel.util.functions;

import arundel.util.Function;

public class Reciprocal implements Function {

    /**
     * Creates a new instance of {@link Reciprocal}
     * @return a new {@link Reciprocal} instance
     */
    public static Reciprocal op() { return new Reciprocal(); }

    /**
     * Note that the no of inputs for a constant function does not matter
     * as it will output the same constant irrespective of the input.
     * @return the no of inputs = 1 (by default)
     */
    public int noOfInputs() { return 1; }

    public double operate(double... param) {
        return param.length != noOfInputs() ?
        Double.NaN : 1.0 / param[0];
    }

    public double[] derivatives(double... param) {
        return param.length != noOfInputs() ?
        null : new double[]{1.0 / (-param[0] * param[0])};
    }
}
