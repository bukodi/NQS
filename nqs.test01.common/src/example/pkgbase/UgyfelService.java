package example.pkgbase;

import framework.annotations.NotNull;
import framework.common.UndefinedFieldException;
import framework.common.services.BeanAccessor;
import framework.common.services.IBOService;
import framework.metamodel.IAttribute;

public interface UgyfelService extends IBOService<Ugyfel>{
		
	final static BeanAccessor<Ugyfel> _BEAN_ACCESSOR_ = new BeanAccessor<Ugyfel>() {

		@SuppressWarnings("unchecked")
		@Override
		public <V> V get(@NotNull Ugyfel object,
				@NotNull IAttribute<? super Ugyfel, V> attr)
				throws UndefinedFieldException {
			if (attr.equals(Ugyfel.UGYFEL_ID))
				return (V) object.getUGYFEL_ID();
			else if (attr.equals(Ugyfel.VEZETEKNEV))
				return (V) object.getVEZETEKNEV();
			else if (attr.equals(Ugyfel.TELJESNEV))
				return (V) object.getTELJESNEV();
			else
				throw new UndefinedFieldException(attr);
		}

		@SuppressWarnings("unchecked")
		@Override
		public <V> void set(@NotNull Ugyfel object, @NotNull IAttribute<? super Ugyfel, V> attr,
				V value) throws UndefinedFieldException {
			if (attr.equals(Ugyfel.VEZETEKNEV))
				object.setVEZETEKNEV( (String)value);
			else if (attr.equals(Ugyfel.KERESZTNEV))
				object.setKERESZTNEV( (String)value);
			else
				throw new UndefinedFieldException(attr);
		}
	}; 
	
}
