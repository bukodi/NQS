package framework.metamodel;

import framework.common.IBusinessObject;

public interface IPersistentField<BO extends IBusinessObject,V> extends IAttribute<BO,V> {

	public abstract String getSqlType();

	public abstract String getColumnName();

}
