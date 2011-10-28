package framework.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.annotations.NotNull;


public class RecordList<BO extends IBusinessObject> extends ArrayList<Record<BO>>{
	
	private final RecordFormat<BO> recordFormat;
	
	public RecordList(@NotNull RecordFormat<BO> recordFormat ) {		
		this.recordFormat = recordFormat;		
	}
	
	public RecordFormat<BO> getFormat() {
		return recordFormat;
	}
	
	public Record<BO> newRecord() {
		Record<BO> newRecord = new Record<BO>( recordFormat );
		add(newRecord);
		return newRecord;
	}
	public Record<BO> newRecord(int index ) {
		Record<BO> newRecord = new Record<BO>( recordFormat );
		add(index, newRecord);
		return newRecord;
	}

}
