package arundel.util.functions;

import arundel.util.Function;

public class Constant implements Function {
    // the constant value of this function
    public final int constant;

    public Constant(int c) { constant = c; }
    /**
     * Creates a new instance of {@link Constant}
     * @param c the constant output of the new function
     * @return a new {@link Constant} instance
     */
    public static Constant op(int c) { return new Constant(c); }

    /**
     * Note that the no of inputs for a constant function does not matter
     * as it will output the same constant irrespective of the input.
     * @return the no of inputs = 1 (by default)
     */
    public int noOfInputs() { return 1; }

    public double operate(double... param) {
        return constant;
    }

    public double[] derivatives(double... param) {
        return new double[param.length > 0 ? param.length : 1];
    }
}
