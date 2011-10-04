package framework.common.services;

import java.util.List;

import framework.common.IBusinessObject;

public interface NQSServiceFactory {

	public List<Class<? extends IGenericService>> getServiceTypes();

	/**
	 * Do not cache service instances!
	 * @param <SVC> 
	 * @param serviceTye
	 * @return the newly created service instance.
	 */
	public <SVC extends IGenericService> SVC createService( Class<SVC> serviceTye ) throws Exception;

}
