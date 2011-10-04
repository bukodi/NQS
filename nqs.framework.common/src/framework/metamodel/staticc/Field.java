package framework.metamodel.staticc;

import framework.common.IBusinessObject;
import framework.metamodel.IAttribute;

public abstract class Field<BO extends IBusinessObject,V> implements IAttribute<BO, V> {

	private final Class<BO> declaringType;
	
	private final String name;

	private final Class<V> valueType;
	
	private final V defaultValue = null;
		
	public Field(Class<BO> accessingType, String name, Class<V> valueType) {
		this.declaringType = accessingType;
		this.name = name;
		this.valueType = valueType;
	}

	@Override
	public Class<BO> getDeclaringType() {
		return declaringType;
	}

	@Override
	public String getName() {
		return name; 
	}

	@Override
	public Class<V> getValueType() {
		return valueType;
	}

	@Override
	public V initialValue() {
		return defaultValue;
	}
}
