package framework.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OneElementIterator<T> implements Iterator<T>{

	private final T element;
	private boolean beforeFirst = true;
	
	public OneElementIterator( T element ) {
		this.element = element;
	}
	
	@Override
	public boolean hasNext() {
		return beforeFirst;
	}

	@Override
	public T next() {
		if( beforeFirst ) {
			beforeFirst = false;
			return element;
		} else {
			throw new NoSuchElementException();
		}		
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
