package framework.metamodel;

import framework.common.IBusinessObject;

public interface IBOTypeDescriptor<BO extends IBusinessObject> {

	public abstract IAttribute<BO, ?>[] getAttributes();

	public abstract IPrimaryKey<BO> getPrimaryKey();

	public abstract Class<BO> getJavaType();

}
