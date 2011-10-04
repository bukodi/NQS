package framework.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


public class RecordList<R extends Record> implements Iterable<R>{
	
	private final ArrayList<R> records = new ArrayList<R>();
	
	@Override
	public Iterator<R> iterator() {
		return records.listIterator();
	}

	
}
