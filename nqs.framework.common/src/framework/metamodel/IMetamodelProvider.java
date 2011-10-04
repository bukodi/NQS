package framework.metamodel;

import java.util.List;

import framework.common.services.IGenericService;

public interface IMetamodelProvider {
	
	List<IGenericService> getServiceTypes();
	
	List<IBOTypeDescriptor> getBOTypes();

}
