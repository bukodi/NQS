package example.pkgbase;

import framework.common.Filter;
import framework.common.IBOReference;
import framework.common.Record;

public class UgyfelServiceImpl implements UgyfelService {

	@Override
	public <R extends Record<Ugyfel>> Iterable<R> query(Class<R> returnType,
			Filter<Ugyfel> filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <R extends Record<Ugyfel>> Iterable<IBOReference<Ugyfel>> store(
			Iterable<R> records) {
		// TODO Auto-generated method stub
		return null;
	}


}
