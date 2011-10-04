package example.pkgext;

import framework.common.Filter;
import framework.common.IBOReference;
import framework.common.Record;
import framework.common.RecordList;

public class KiemeltUgyfelServiceImpl implements KiemeltUgyfelService{

	@Override
	public <R extends Record<KiemeltUgyfel>> Iterable<R> query(
			Class<R> returnType, Filter<KiemeltUgyfel> filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <R extends Record<KiemeltUgyfel>> Iterable<IBOReference<KiemeltUgyfel>> store(
			Iterable<R> records) {
		// TODO Auto-generated method stub
		return null;
	}


}
