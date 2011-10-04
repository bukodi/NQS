package example.pkgbase;

import java.util.Arrays;
import java.util.List;

import framework.annotations.NotNull;
import framework.common.IBusinessObject;
import framework.common.UndefinedFieldException;
import framework.metamodel.IAttribute;
import framework.metamodel.IPrimaryKey;
import framework.metamodel.staticc.BOType;
import framework.metamodel.staticc.CalculatedField;
import framework.metamodel.staticc.PersistentField;
import framework.metamodel.staticc.PrimaryKey;

public interface Ugyfel extends IBusinessObject {
	
	public <V> V get(IAttribute<Ugyfel, V> field)
			throws UndefinedFieldException;

	public <V> void set(IAttribute<Ugyfel, V> field, V value)
			throws UndefinedFieldException;

	@SuppressWarnings("unchecked")
	public static class META extends BOType {
		// @formatter:off
		META(){super(Ugyfel.class);}

		protected META( Class<? extends Ugyfel> boType ){super(boType);}

		public final static PersistentField<Ugyfel, Long> UGYFEL_ID = new PersistentField<Ugyfel, Long>( Ugyfel.class, "UGYFEL_ID", Long.class); //$NON-NLS-1$

		public final static PersistentField<Ugyfel, String> VEZETEKNEV = new PersistentField<Ugyfel, String>( Ugyfel.class, "VEZETEKNEV", String.class); //$NON-NLS-1$

		public final static PersistentField<Ugyfel, String> KERESZTNEV = new PersistentField<Ugyfel, String>( Ugyfel.class, "KERESZTNEV", String.class); //$NON-NLS-1$

		public final static CalculatedField<Ugyfel, String> TELJESNEV = new CalculatedField<Ugyfel, String>( Ugyfel.class, "TELJESNEV", String.class, VEZETEKNEV, KERESZTNEV); //$NON-NLS-1$

		private final static IPrimaryKey<Ugyfel> _primaryKey_ = new PrimaryKey<Ugyfel>(	Ugyfel.class, UGYFEL_ID);
		// @formatter:on

	};

	public Long getUGYFEL_ID();

	/**
	 * Visszadja a kerestnevet
	 * 
	 * @return
	 */
	public String getKERESZTNEV();

	/**
	 * Beállítja a keresztnevet
	 * 
	 * @param keresztnev
	 */
	public void setKERESZTNEV(String keresztnev);

	public String getVEZETEKNEV();

	public void setVEZETEKNEV(String vezeteknev);

	public String getTELJESNEV();

	public String sayHello1(String name);

	public String sayHello2(String name);

	public String sayHello3(String name);

	public String sayHello4(String name);

	Object getPrimaryKey();

}
