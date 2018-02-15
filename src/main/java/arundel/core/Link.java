package arundel.core;

/**
 * <p>
 * Class to establish the link between two gates in the computational circuit
 * and enable the transimission of data between them. </p>
 */
public class Link {

    /** Portal for transimission of data */
    public final Gate source, sink;
    /** The data to be transmitted */
    private double data;

    /**
     * Constructor for class Link.
     * @param source the source {@link arundel.core.Gate}
     * @param sink the sink {@link arundel.core.Gate}
     */
    public Link(Gate source, Gate sink) {
        this.source = source;
        this.sink = sink;
    }

    /**
     * Sets the data to be transmitted through this link.
     * @param d the data to be transmitted
     */
    public void setData(double d) { data = d; }

    /**
     * Returns the data contained in this link.
     * @return the double data
     */
    public double getData() { return data; }
}
