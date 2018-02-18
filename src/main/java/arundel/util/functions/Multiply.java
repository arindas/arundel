package arundel.util.functions;

import arundel.util.Function;

/**
 * Implementation of a binary product function.
 *
 */
public class Multiply implements Function {

    /**
     * Creates a new instance of {@link Multiply}
     * @return a new {@link Multiply} instance
     */
    public static Multiply op() { return new Multiply(); }

    public int noOfInputs() { return 2; }

    /**
     * Return the multiplication of the parameters passed in.
     * @param parameters the parameters to be added up
     * @return the sum or {@code Double.NaN} if
     * the number of parameters is not two.
     */
    public double operate(double... parameters) {
        return parameters.length == noOfInputs() ?
        parameters[0] * parameters[1] : Double.NaN;
    }

    public double[] derivatives(double... parameters) {
        return parameters.length != noOfInputs() ? null :
         new double[]{parameters[1], parameters[0]};
    }
}
