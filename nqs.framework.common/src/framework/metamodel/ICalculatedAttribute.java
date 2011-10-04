package framework.metamodel;

import framework.common.IBusinessObject;
import framework.metamodel.staticc.Field;

public interface ICalculatedAttribute<BO extends IBusinessObject,V> extends IAttribute<BO,V> {

	public abstract IAttribute<BO, V>[] getDependentFields();

}
