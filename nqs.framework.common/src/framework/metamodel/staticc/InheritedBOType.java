package framework.metamodel.staticc;

import java.util.concurrent.Callable;

import framework.common.IBusinessObject;
import framework.metamodel.IAttribute;
import framework.metamodel.IInheritedBOType;
import framework.metamodel.IPrimaryKey;
import framework.metamodel.IBOTypeDescriptor;

public class InheritedBOType<S extends IBusinessObject, BO extends S> extends BOType<BO> implements IInheritedBOType<S, BO> {
	
	private final IBOTypeDescriptor<S> superType;

	public InheritedBOType(IBOTypeDescriptor<S> superType,
			Class<BO> businessObjectType, IPrimaryKey<BO> primaryKey,
			IAttribute<BO, ?> ... declaredFields) {
		super(businessObjectType);
		//super(businessObjectType, primaryKey, (new Con structorProc<S,BO>( businessObjectType, superType, declaredFields)).call());
		this.superType = superType;
	}
	
	public IBOTypeDescriptor<S> getSuperType() {
		return superType;
	}

	private static class ConstructorProc<S extends IBusinessObject, BO extends S> implements Callable<IAttribute<BO, ?>[]>{
		
		final IAttribute<BO,?>[] fields;
		
		@SuppressWarnings("unchecked")
		ConstructorProc( Class<BO> businessObjectType, IBOTypeDescriptor<S> superType, IAttribute<BO, ?>[] declaredFields ) {
			this.fields = new IAttribute[superType.getAttributes().length + declaredFields.length];
			int i = 0;
			for( IAttribute<S,?> superField : superType.getAttributes() ) 				
				fields[i++] = new InheritedField(businessObjectType, superField);
			for( IAttribute<BO, ?> declaredField : declaredFields )
				fields[i++] = declaredField;
		}
		
		@Override
		public IAttribute<BO, ?>[] call()  {
			return fields;
		}
		
	};	
}
