package arundel.util.functions;

import arundel.util.Function;

/**
 * Implementation of a binary addition function.
 *
 */
public class Add implements Function {

    /**
     * Creates a new instance of {@link Add}
     * @return a new {@link Add} instance
     */
    public static Add op() { return new Add(); }

    public int noOfInputs() { return 2; }

    /**
     * Return the sum of the parameters passesd in.
     * @param parameters the parameters to be added up
     * @return the sum or {@code Double.NaN} if
     * the number of parameters is not two.
     */
    public double operate(double... parameters) {
        return parameters.length == noOfInputs() ?
        parameters[0] + parameters[1] : Double.NaN;
    }

    public double[] derivatives(double... parameters) {
        return new double[]{1, 1};
    }
}
