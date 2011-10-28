package framework.common;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import framework.annotations.NotNull;
import framework.metamodel.IAttribute;

/**
 * Az osztály a példányosítás után nem változik.
 * 
 * @author bukodi
 * 
 * @param <BO>
 */
public class RecordFormat<BO extends IBusinessObject> {

	@NotNull
	public final Class<BO> boType;
	public final List<IAttribute<? super BO, ?>> attributes;
	public final boolean throwExceptionOnInvalidGet;

	/**
	 * Ha a clazz típusa<br/>
	 * <code>Class&lt;RF extends RecordFormat&lt;BO extends IBusinessObject&gt;&gt;</code>
	 * <br/>
	 * vagy<br/>
	 * <code>Class&lt;RF extends Record&lt;BO extends IBusinessObject&gt;&gt;</code>
	 * <br/>
	 * akkor visszaadja <code>BO</code> típusparamétert.
	 * 
	 * @param clazz
	 * @return az {@linkplain IBusinessObject} típusú típusparaméter értéke. Ha
	 *         ilyen nincs, akkor <code>null</code>.
	 */	
	private final static Class getBOType(Class clazz) {
		// TODO: ezt majd valószínûleg törölni kell
		Class<?> tmp_boType = null;
		for (Type sc = clazz; sc != null;) {
			if (sc == null) {
				return null;
			} else if (sc instanceof ParameterizedType) {
				ParameterizedType pt = (ParameterizedType) sc;
				if (!(Record.class.equals(pt.getRawType()) || RecordFormat.class
						.equals(pt.getRawType())))
					return null;
				tmp_boType = (Class<?>) pt.getActualTypeArguments()[0];
				break;
			} else if (sc instanceof Class) {
				Class superClass = (Class) sc;
				sc = ((Class) sc).getGenericSuperclass();
				continue;
			} else {
				new RuntimeException("Illegal type hierarchy");
			}
		}
		return tmp_boType;
	}

	public RecordFormat(@NotNull Class<BO> boType,
			IAttribute<? super BO, ?>... fields) {
		this(boType, true, fields);
	}

	public RecordFormat(@NotNull Class<BO> boType,
			boolean throwExceptionOnInvalidGet,
			IAttribute<? super BO, ?>[] fields) {
		this( boType, throwExceptionOnInvalidGet, Arrays.asList(fields));
	}

	public RecordFormat(@NotNull Class<BO> boType,
			boolean throwExceptionOnInvalidGet,
			List<IAttribute<? super BO, ?>> fields) {

		this.boType = boType;

		this.throwExceptionOnInvalidGet = throwExceptionOnInvalidGet;

		// TODO: add key fields

		// TODO: calculate hashcode for this instance
		this.attributes = Collections.unmodifiableList(fields);
	}

	@NotNull
	public static <BO extends IBusinessObject> RecordFormat<BO> formatOf(
			@NotNull Class<? extends Record<BO>> recordType) {
		// Determine BO type
		Class<?> boType = null;
		// Walk up on type hierarchy
		for (Type sc = recordType; sc != null;) {			
			if (sc == null) {
				new RuntimeException("Illegal type hierarchy");
			} else if (sc instanceof ParameterizedType) {
				// The first ParameterizedType
				ParameterizedType pt = (ParameterizedType) sc;
				if (Record.class.equals(pt.getRawType())) {
					boType = (Class<?>) pt.getActualTypeArguments()[0];
					break;
				} else {
					new RuntimeException("Illegal type hierarchy");					
				}
			} else if (sc instanceof Class) {				
				Class superClass = (Class) sc;
				sc = ((Class) sc).getGenericSuperclass();
				continue;
			} else {
				new RuntimeException("Illegal type hierarchy");
			}
		}
	
		// Get fields based on reflection		
		List<IAttribute<? super BO, ?>> attrs = new ArrayList<IAttribute<? super BO,?>>(); 
		try{
			for( Field recordField : recordType.getDeclaredFields()) {
				Field typeField = boType.getField(recordField.getName());
				Object typeValue = typeField.get(null);
				attrs.add((IAttribute<? super BO, ?>) typeValue);
			}			
		} catch ( Exception e ) {
			throw new RuntimeException(e);
		}
	
		RecordFormat<BO> rf = new RecordFormat<BO>((Class<BO>)boType, true, attrs);
		return rf;
	}

	public Record<BO> newRecord() {
		return new Record<BO>(this);
	}
	

}
