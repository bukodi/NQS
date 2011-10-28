package framework.metamodel.staticc;

import framework.common.IBusinessObject;
import framework.metamodel.IAttribute;

public abstract class Field<BO extends IBusinessObject,V> implements IAttribute<BO, V> {

	private final Class<BO> declaringType;
	
	private final java.lang.reflect.Field reflectionField;

	private final Class<V> valueType;
	
	private final V defaultValue = null;
		
	public Field(Class<BO> accessingType, String name, Class<V> valueType) {
		this.declaringType = accessingType;
		try {
			this.reflectionField = accessingType.getField( name );
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		this.valueType = valueType;
	}

	@Override
	public Class<BO> getDeclaringType() {
		return declaringType;
	}

	@Override
	public String getName() {
		return reflectionField.getName(); 
	}

	@Override
	public Class<V> getValueType() {
		return valueType;
	}

	@Override
	public V initialValue() {
		return defaultValue;
	}

	@Override
	public String toString() {
		return reflectionField.toString();
	}
	
}
