package framework.metamodel.staticc;

import framework.common.IBusinessObject;
import framework.metamodel.IAttribute;

public class ReferencedField<BO extends IBusinessObject,V> extends CalculatedField<BO,V> {

	private final Reference<BO, ?> reference;

	private final IAttribute<?,V> otherField;
	
	public <OtherBO extends IBusinessObject> ReferencedField( Class<BO> accessingType, String name, Reference<BO,OtherBO> reference, 
			IAttribute<OtherBO,V> otherField ) {
		super(accessingType, name, otherField.getValueType());
		this.reference = reference;
		this.otherField = otherField;
	}

	public Reference<BO, ?> getReference() {
		return reference;
	}

	public IAttribute<?, V> getOtherField() {
		return otherField;
	}
}
