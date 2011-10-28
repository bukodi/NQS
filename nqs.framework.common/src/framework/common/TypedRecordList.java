package framework.common;

import framework.annotations.NotNull;


public class TypedRecordList<BO extends IBusinessObject, R extends Record<BO>> extends RecordList<BO>{
	
	private final Class<R> recordType;
	
	public TypedRecordList(@NotNull Class<R> recordType ) throws RuntimeException {
		super( RecordFormat.formatOf(recordType) );
		this.recordType = recordType; 
	}
			
	public R newRecord() {
		R newRecord;
		try {
			newRecord = recordType.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		};
		add(newRecord);
		return newRecord;
	}
	
	public Record<BO> newRecord(int index ) {
		R newRecord;
		try {
			newRecord = recordType.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		};
		add(index,newRecord);
		return newRecord;
	}	
}
