/**
<p>
Contains classes that define the components for building computational graphs.
All data is collected from {@link Variable}s, processed in <code>Operator</code>s and
stored in placeholders. All computational units <code>Variable, Operator, Placeholder</code>
implement the {@link Gate} interface. Hence the computation graph which is encapsulated
as a {@link Circuit} is a directed acyclic graph (DAG) of {@link Gate}s. See {@link Circuit}
and {@link Gate} for more information in order to develop an intuition about the usage of this framework.
</p>
<p>
The {@link Gate} class is the basic building block of the computation graph a.k.a. {@link Circuit}.
See more about {@link Gate} for information regarding the implementation required bu the {@link Gate}
interface.
</p>
<p>
All computation is performed in the {@link Operator}s. Hence it makes sense to place the
trainable parmameters as inputs to the {@link Operator} instances and update them using
<code>Gate.update().</code> Learn more about {@link Operator}s for implementation of computation.
</p>

*/



package arundel.core;
