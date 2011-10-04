package framework.common.services;

import framework.common.Filter;
import framework.common.IBOReference;
import framework.common.IBusinessObject;
import framework.common.Record;
import framework.common.RecordList;

public interface IBOService<BO extends IBusinessObject> extends IGenericService {

	<R extends Record<BO>> Iterable<R> query( Class<R> returnType, Filter<BO> filter);
	
	<R extends Record<BO>> Iterable<IBOReference<BO>> store( Iterable<R> records );

}
