package arundel.util.functions;

import arundel.util.Function;

public class Negation implements Function {

    /**
     * Creates a new instance of {@link Negation}
     * @return a new {@link Negation} instance
     */
    public static Negation op() { return new Negation(); }

    public int noOfInputs() { return 1; }

    public double operate(double... param) {
        return param.length == noOfInputs() ?
         -param[0] : Double.NaN;
    }

    public double[] derivatives(double... param) {
        return new double[]{1};
    }
}
