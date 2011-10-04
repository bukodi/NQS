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
		this(new RecordFormat<BO>(true, false, null));
	}

	public Record( RecordFormat<BO> recordFormat ) {
		this.recordFormat = recordFormat; 
	}

	public <V> V get(@NotNull IAttribute<? super BO, V> field)
			throws UndefinedFieldException {
		if (field == null)
			throw new NullPointerException("field");
		if (!values.containsKey(field)) {
			if (recordFormat.throwExceptionOnInvalidGet)
				throw new UndefinedFieldException(field);
			else
				return null;
		}

		return (V) values.get(field);
	}

	public <V> void set(@NotNull IAttribute<? super BO, V> field, V value)
			throws UndefinedFieldException {
		if (field == null)
			throw new NullPointerException("field");
		if (!values.containsKey(field))
			if (recordFormat.addAttributeOnInvaidSet)
				recordFormat.attributes.add(field);
			else
				throw new UndefinedFieldException(field);
		values.put(field, value);
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
