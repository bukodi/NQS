package example.pkgbase;

import framework.common.Filter;
import framework.common.IBOReference;
import framework.common.RecordList;
import framework.common.RecordFormat;
import framework.server.JPABOServiceHelper;

public class UgyfelServiceImpl implements UgyfelService {
	
	@Override
	public RecordList<Ugyfel> query(RecordFormat<Ugyfel> recordFormat,
			Filter<Ugyfel> filter) {

		JPABOServiceHelper.get().query(recordFormat, filter);
		
		return null;
	}



	@Override
	public Iterable<IBOReference<Ugyfel>> store(RecordList<Ugyfel> records) {
		// TODO Auto-generated method stub
		return null;
	}


}
