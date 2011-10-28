package framework.common.services;

import framework.common.Filter;
import framework.common.RecordList;
import framework.common.IBOReference;
import framework.common.IBusinessObject;
import framework.common.Record;
import framework.common.RecordFormat;
import framework.common.TypedRecordList;

public interface IBOService<BO extends IBusinessObject> extends IGenericService {

	RecordList<BO> query( RecordFormat<BO> recordFormat, Filter<BO> filter);
	
	Iterable<IBOReference<BO>> store( RecordList<BO> records );

}
