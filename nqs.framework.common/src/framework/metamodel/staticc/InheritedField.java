package framework.metamodel.staticc;

import framework.common.IBusinessObject;
import framework.metamodel.IAttribute;
import framework.metamodel.IInheritedField;

public class InheritedField<S extends IBusinessObject, BO extends S, V > extends Field<BO, V> implements IInheritedField<S, BO, V> {

	public final IAttribute<S, V> superField;
	
	public InheritedField(Class<BO> accessingType, IAttribute<S, V> superField) {
		super(accessingType, superField.getName(), superField.getValueType());
		this.superField = superField;
	}

}
