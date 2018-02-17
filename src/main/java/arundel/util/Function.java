package arundel.util;

/**
 * Interface for abstracting the concept of mathematical functions.

 * A function  essentiallly operates on a set of inputs and returns an output.
 * It also has a property called derivative which denotes its rate of change with
 * the change in one of its parameters. Also, for implementation purposes we also
 * specify the number of inputs that a {@link Function} needs to operate.
 */

 public interface Function {

     /**
      * Returns the no of inputs that this function needs.
      * @return the number of inputs required.
      */
     int noOfInputs();

     /**
      * Operates on the given set of inputs and returns the result of
      * the operation. This is the elixir of the concept of functions.
      * @param parameters to be operated on
      * @return the result of the operation
      */
     double operate(double... parameters);

     /**
      * Returns the partial derivatives of this function with
      * respect to its parameters as an array of {@link Function}
      * @param parameters point of tangency
      * @return array of partial derivative values
      */
     double[] derivatives(double... parameters);
 }
