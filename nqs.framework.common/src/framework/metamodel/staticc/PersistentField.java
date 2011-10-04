package framework.metamodel.staticc;

import framework.common.IBusinessObject;
import framework.metamodel.IPersistentField;

public class PersistentField<BO extends IBusinessObject,V> extends Field<BO,V> implements IPersistentField<BO, V>{
	
	public final String columnName;
	
	public final String sqlType;
		
	public PersistentField(Class<BO> declaringType, String name, 
			Class<V> valueType) {
		this(declaringType, name, valueType, name, calculateSQLTypeFromJavaType( valueType) );
	}

	public PersistentField(Class<BO> declaringType, String name, 
			Class<V> valueType, String columnName, String sqlType ) {
		super(declaringType, name, valueType);
		 this.columnName = columnName;
		 this.sqlType = sqlType;
	}
	
	private static String calculateSQLTypeFromJavaType( Class<?> javaType ) {
		return javaType.toString();
	}

	@Override
	public String getColumnName() {
		return columnName;
	}

	@Override
	public String getSqlType() {
		return sqlType;
	}

}
