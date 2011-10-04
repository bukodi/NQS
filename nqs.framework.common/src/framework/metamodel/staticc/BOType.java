package framework.metamodel.staticc;

import framework.common.IBusinessObject;
import framework.metamodel.IAttribute;
import framework.metamodel.IPrimaryKey;
import framework.metamodel.IBOTypeDescriptor;

public class BOType<BO extends IBusinessObject> implements IBOTypeDescriptor<BO> {
	
	private final Class<BO> businessObjectType;
	
	private final IPrimaryKey<BO> primaryKey;

	private final IAttribute<BO,?> fields[];

	public BOType(Class<BO> businessObjectType) {
		this.businessObjectType = businessObjectType;
		this.primaryKey = null;
		this.fields = null;
	}
	
	@Override
	public Class<BO> getJavaType() {
		return businessObjectType;
	}

	@Override
	public IPrimaryKey<BO> getPrimaryKey() {
		return primaryKey;
	}

	@Override
	public IAttribute<BO, ?>[] getAttributes() {
		return fields;
	}
		
	
}
