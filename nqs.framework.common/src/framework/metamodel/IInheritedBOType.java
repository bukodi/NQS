package framework.metamodel;

import framework.common.IBusinessObject;

public interface IInheritedBOType<S extends IBusinessObject, BO extends S> extends IBOTypeDescriptor<BO> {
	
	IBOTypeDescriptor<S> getSuperType();

}
