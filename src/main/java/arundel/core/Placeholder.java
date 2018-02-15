package arundel.core;

/**
A {@link Placeholder} is essentially a non-trainable {@link Variable}. It may be used to
store the result of some computation or some labels which will be compared against to
estimate the loss of a model.

Placeholders are intended to be added to the computation graph at the penultimate
state of computation, mostly as an input to the loss function. Hence, it is intuititve
to limit the number of outputs of this gate to one. However, this {@link Gate} doesn't
place such restrictions.
 */

public class Placeholder extends Variable {
    public Placeholder() {
        super();
    }
}
