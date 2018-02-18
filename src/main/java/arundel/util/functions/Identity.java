package arundel.util.functions;

import arundel.util.Function;

public class Identity {

    /**
     * Creates a new instance of {@link Identity}
     * @return a new {@link Identity} instance
     */
    public static Negation op() { return new Negation(); }

    public int noOfInputs() { return 1; }

    public double operate(double... param) {
        return param.length == noOfInputs() ?
         param[0] : Double.NaN;
    }

    public double[] derivatives(double... param) {
        return new double[]{1};
    }
}
