package framework.common.services;

import framework.common.IBusinessObject;
import framework.common.UndefinedFieldException;
import framework.metamodel.IAttribute;

public interface Accessor<BO extends IBusinessObject> {
	
	<V> V get( BO object, IAttribute<? super BO, V> attr ) throws UndefinedFieldException;
	
	<V> void set( BO object, IAttribute<? super BO, V> attr, V value ) throws UndefinedFieldException;

}
