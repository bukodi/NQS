package framework.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import framework.annotations.NotNull;
import framework.metamodel.IAttribute;
import framework.util.OneElementIterator;

public class Record<BO extends IBusinessObject> implements
		IBOReference<BO>, Iterable<Record<BO>> {

	private final RecordFormat<BO> recordFormat;
	private final Map<IAttribute<? super BO, ?>, Object> values = new HashMap<IAttribute<? super BO, ?>, Object>();

	
	protected Record() {
		//Class<? extends Record<BO>> clazz = null;
		recordFormat = RecordFormat.formatOf((Class<? extends Record<BO>>) getClass());
		//null;
	}

	public Record( RecordFormat<BO> recordFormat ) {
		this.recordFormat = recordFormat; 
	}

	public <V> V get(@NotNull IAttribute<? super BO, V> field)
			throws UndefinedFieldException {
		if (field == null)
			throw new NullPointerException("field");
		if (!recordFormat.attributes.contains(field)) {
			if (recordFormat.throwExceptionOnInvalidGet)
				throw new UndefinedFieldException(field);
			else
				return field.initialValue();
		}

		if (!values.containsKey(field)) {
			if (recordFormat.throwExceptionOnInvalidGet)
				throw new UndefinedFieldException(field);
			else
				return field.initialValue();
		} else {
			return (V) values.get(field);			
		}		
	}

	public <V> Record<BO> set(@NotNull IAttribute<? super BO, V> field, V value)
			throws UndefinedFieldException {
		if (field == null)
			throw new NullPointerException("field");
		if ( ! recordFormat.attributes.contains(field) )
			throw new UndefinedFieldException(field);
				
		values.put(field, value);
		
		// For chained call
		return this; 
	}

	@Override
	public Object getPrimaryKey() {
		return null;
	}

	@Override
	public String toString() {
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(this.recordFormat.boType.getName() + " " + recordFormat.attributes.size() + " attributes.\n" );
			for( IAttribute<? super BO, ?>  field : recordFormat.attributes ) {
				sb.append( field.getName()  );
				if( values.containsKey(field) )
					sb.append( " = " + values.get(field) );
				else
					sb.append( " is not set.");
				sb.append("\n");
			}
			return sb.toString();
		} catch (Exception e) {
			return ("Exception in toString() : " + e.getMessage());
		}
	}

	@Override
	public Iterator<Record<BO>> iterator() {		
		return new OneElementIterator<Record<BO>>(this);
	}
	
}
