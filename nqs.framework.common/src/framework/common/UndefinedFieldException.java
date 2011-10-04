package framework.common;

import framework.metamodel.IAttribute;

public class UndefinedFieldException extends RuntimeException {
	
	private final IAttribute<?, ?> field;
		
	public UndefinedFieldException( IAttribute<?, ?> field ) {
		super( field.toString() );
		this.field = field;
	}

}
