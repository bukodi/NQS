package framework.common;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

import org.omg.IOP.Codec;

import framework.metamodel.IAttribute;

public class RecordFormat<BO extends IBusinessObject> {
	
	public static <BO extends IBusinessObject> RecordFormat<BO> formatOf( Class<? extends Record<BO>> recordType ) {
		RecordFormat<BO> rf = new RecordFormat<BO>();
		
		return rf;
	}

	public final Class<BO> boType;
	public final ArrayList<IAttribute<? super BO, ?>> attributes = new ArrayList<IAttribute<? super BO, ?>>();
	// private final List<IField<BO, ?>> unmodifiableAttributes =
	// Collections.unmodifiableList(attributes);
	public final boolean throwExceptionOnInvalidGet;
	public final boolean addAttributeOnInvaidSet;
	
	/**
	 * Ha a clazz típusa<br/>
	 * <code>Class&lt;RF extends RecordFormat&lt;BO extends IBusinessObject&gt;&gt;</code><br/>
	 * vagy<br/>
	 * <code>Class&lt;RF extends Record&lt;BO extends IBusinessObject&gt;&gt;</code><br/> 
	 * akkor visszaadja <code>BO</code> típusparamétert.
	 * @param clazz
	 * @return az {@linkplain IBusinessObject} típusú típusparaméter értéke. Ha ilyen nincs, akkor <code>null</code>. 
	 */	
	private final static Class getBOType(Class clazz) {		
		Class<?> tmp_boType = null;
		for (Type sc = clazz.getGenericSuperclass(); sc != null;) {
			if (sc == null) {
				return null;
			} else if (sc instanceof Class) {
				Class superClass = (Class) sc;
				sc = ((Class) sc).getGenericSuperclass();
				continue;
			} else if (sc instanceof ParameterizedType) {
				ParameterizedType pt = (ParameterizedType) sc;
				if (! ( Record.class.equals(pt.getRawType()) || RecordFormat.class.equals(pt.getRawType()) ))
					return null;
				tmp_boType = (Class<?>) pt.getActualTypeArguments()[0];
				break;
			} else {
				new RuntimeException("Illegal type hierarchy");
			}
		}
		return tmp_boType;
	}

	public RecordFormat() {
		this(true, false, null);
	}

	public RecordFormat(IAttribute<? super BO, ?>... fields) {
		this(true, false, fields);
	}

	public RecordFormat(boolean throwExceptionOnInvalidGet,
			boolean addAttributeOnInvaidSet, IAttribute<? super BO,?>[] fields) {
		boType = getBOType(getClass());
		this.throwExceptionOnInvalidGet = throwExceptionOnInvalidGet;
		this.addAttributeOnInvaidSet = addAttributeOnInvaidSet;
						
		// Get fields base on reflection
		if (fields != null)
			for (IAttribute<? super BO, ?> f : fields)
				attributes.add(f);
		// TODO: add key fields
	}


}
