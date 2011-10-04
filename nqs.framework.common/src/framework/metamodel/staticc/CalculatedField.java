package framework.metamodel.staticc;

import framework.common.IBusinessObject;
import framework.metamodel.ICalculatedAttribute;
import framework.metamodel.IAttribute;

public class CalculatedField<BO extends IBusinessObject,V> extends Field<BO,V> implements ICalculatedAttribute<BO, V> {
	
	private final IAttribute<BO, V> dependentFields[];
	
	public CalculatedField(Class<BO> accessingType, String name, 
			Class<V> valueType, IAttribute<BO, V> ... dependentFields) {
		super(accessingType, name, valueType);
		this.dependentFields = dependentFields;
	}

	@Override
	public IAttribute<BO, V>[] getDependentFields() {
		return dependentFields;
	}
}
