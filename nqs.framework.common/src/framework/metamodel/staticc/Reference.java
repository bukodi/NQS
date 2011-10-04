package framework.metamodel.staticc;

import framework.common.IBusinessObject;
import framework.metamodel.IBOTypeDescriptor;

public class Reference<ThisBO extends IBusinessObject, OtherBO extends IBusinessObject> {
	
	public final IBOTypeDescriptor<ThisBO> thisType;
	
	public final IBOTypeDescriptor<OtherBO> otherType;

	public Reference(IBOTypeDescriptor<ThisBO> thisType, IBOTypeDescriptor<OtherBO> otherType) {
		super();
		this.thisType = thisType;
		this.otherType = otherType;
	}
}
