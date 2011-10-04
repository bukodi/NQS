package framework.common.services;

import java.util.List;

import framework.common.IBusinessObject;
import framework.metamodel.IBOTypeDescriptor;

public interface NQSTypeFactory {

	public List<Class<? extends IBusinessObject>> getBOTypes();

	/**
	 * Do not cache type descriptor instances!
	 * @param <BO> 
	 * @param boTye
	 * @return the type descriptor of boType.
	 */
	public <BO extends IBusinessObject> IBOTypeDescriptor<BO> getBOTypeDescriptor( Class<? extends BO> boType ) throws Exception;

}
