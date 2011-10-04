package framework.metamodel;

import framework.common.IBusinessObject;

public interface IPrimaryKey<BO extends IBusinessObject>{

	public abstract IPersistentField<BO, ?>[] getPrimaryKeyFields();

	public abstract Class<BO> getBusinessObjectType();

}
