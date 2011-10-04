package framework.metamodel.staticc;

import framework.common.IBusinessObject;
import framework.metamodel.IPersistentField;
import framework.metamodel.IPrimaryKey;

public class PrimaryKey<BO extends IBusinessObject> implements IPrimaryKey<BO>{
	
	private final Class<BO> businessObjectType;
	
	private final IPersistentField<BO, ?> primaryKeyFields[];

	public PrimaryKey(Class<BO> businessObject, IPersistentField<BO, ?> ... primaryKeyFields) {
		this.businessObjectType = businessObject;
		this.primaryKeyFields = primaryKeyFields;
	}

	@Override
	public Class<BO> getBusinessObjectType() {
		return businessObjectType;
	}

	@Override
	public IPersistentField<BO, ?>[] getPrimaryKeyFields() {
		return primaryKeyFields;
	}
}
