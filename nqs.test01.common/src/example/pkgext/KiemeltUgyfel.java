package example.pkgext;

import example.pkgbase.Ugyfel;
import example.pkgbase.Ugyfel.Attr;
import framework.annotations.NotNull;
import framework.common.UndefinedFieldException;
import framework.metamodel.IAttribute;
import framework.metamodel.IPersistentField;
import framework.metamodel.IPrimaryKey;
import framework.metamodel.staticc.PersistentField;
import framework.metamodel.staticc.PrimaryKey;

public interface KiemeltUgyfel extends Ugyfel {

	public interface Attr<V> extends IAttribute<KiemeltUgyfel, V> {
		
	};

	public <V> V get(Attr<V> field)
			throws UndefinedFieldException;

	public <V> void set(Attr<V> field, V value)
			throws UndefinedFieldException;

	public final static class META extends Ugyfel.META {

		public META() {
			super(KiemeltUgyfel.class);
		}

		public final static IPersistentField<KiemeltUgyfel, Long> KIEMELTUGYFEL_ID = new PersistentField<KiemeltUgyfel, Long>(
				KiemeltUgyfel.class, "KIEMELTUGYFEL_ID", Long.class); //$NON-NLS-1$

		public final static IPersistentField<KiemeltUgyfel, String> SZEMELYES_UGYINTEZO = new PersistentField<KiemeltUgyfel, String>(
				KiemeltUgyfel.class, "SZEMELYES_UGYINTEZO", String.class); //$NON-NLS-1$

		public final static IPersistentField<KiemeltUgyfel, Boolean> UTOLSO_TALALKOZO = new PersistentField<KiemeltUgyfel, Boolean>(
				KiemeltUgyfel.class, "UTOLSO_TALALKOZO", Boolean.class); //$NON-NLS-1$

		@SuppressWarnings("unchecked")
		private final static IPrimaryKey<KiemeltUgyfel> _primaryKey_ = new PrimaryKey<KiemeltUgyfel>(
				KiemeltUgyfel.class, KIEMELTUGYFEL_ID);

	}

	public static class INSTANCES {
		static KiemeltUgyfel KOVACS_JANOS;
		static KiemeltUgyfel VARGA_BELA;
	}

	public String sayHello3(String name);

	public String sayHello4(String name);

	public String sayHello5(String name);

	public String sayHello6(String name);
}
