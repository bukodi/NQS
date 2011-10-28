package example.pkgext;

import example.pkgbase.Ugyfel;
import example.pkgbase.UgyfelService;
import framework.annotations.NotNull;
import framework.common.UndefinedFieldException;
import framework.common.services.BeanAccessor;
import framework.common.services.IBOService;
import framework.metamodel.IAttribute;

public interface KiemeltUgyfelService extends IBOService<KiemeltUgyfel> {

	final static BeanAccessor<KiemeltUgyfel> _ACCESSOR_ = new BeanAccessor<KiemeltUgyfel>() {

		@SuppressWarnings("unchecked")
		@Override
		public <V> V get(@NotNull KiemeltUgyfel object,
				@NotNull IAttribute<? super KiemeltUgyfel, V> attr)
				throws UndefinedFieldException {			
			if ( attr.getDeclaringType().equals(Ugyfel.class))
				return (V) UgyfelService._BEAN_ACCESSOR_.get(object, (IAttribute<? super Ugyfel, V>) attr);
			else if (attr.equals(KiemeltUgyfel.KIEMELTUGYFEL_ID))
				return (V) object.getKIEMELTUGYFEL_ID();
			else if (attr.equals(KiemeltUgyfel.SZEMELYES_UGYINTEZO))
				return (V) object.getSZEMELYES_UGYINTEZO();
			else if (attr.equals(KiemeltUgyfel.UTOLSO_TALALKOZO))
				return (V) object.getUTOLSO_TALALKOZO();
			else
				throw new UndefinedFieldException(attr);
		}

		@SuppressWarnings("unchecked")
		@Override
		public <V> void set(@NotNull KiemeltUgyfel object,
				@NotNull IAttribute<? super KiemeltUgyfel, V> attr, V value)
				throws UndefinedFieldException {
			if (attr.getDeclaringType().equals(Ugyfel.class) )
				UgyfelService._BEAN_ACCESSOR_.set(object, (IAttribute<? super Ugyfel, V>)attr, value);
			else if (attr.equals(KiemeltUgyfel.KIEMELTUGYFEL_ID))
				object.setKIEMELTUGYFEL_ID((Long) value);
			else if (attr.equals(KiemeltUgyfel.SZEMELYES_UGYINTEZO))
				object.setSZEMELYES_UGYINTEZO((String) value);
			else if (attr.equals(KiemeltUgyfel.UTOLSO_TALALKOZO))
				object.setUTOLSO_TALALKOZO((Boolean) value);
			else
				throw new UndefinedFieldException(attr);
		}
	};

}
