# arundel

Arundel is a Java library for building computation graphs.
The Arundel API primarily contains three components:
    - Variables - They are used for storing trainable data
    - Placeholders - They are used or storing non-trainable data
    - Operators - They operate on the data stored in the Variable and Placeholders

Now all of the above components can be generalized into a single abstract entity called Gate.
Hence, the computation directed acyclic graph can be expressed as a Circuit of Gates.

This forms the basic layer of abstraction for building computation Graphs.
The next layer of abstraction is the functions to be used for operating on the paramaeters
in the Operator gates. Hence we specify another abstract entity Function which implements the
notion of mathematical functions. This library also provides a bunch of Function implementations
to be used while building computation graphs.
