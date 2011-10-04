package framework.metamodel;

import framework.common.IBusinessObject;

public interface IAttribute<A extends IBusinessObject,V> {

	public abstract Class<V> getValueType();

	public abstract String getName();

	public abstract Class<A> getDeclaringType();
	
	public V initialValue(); 
	

}
