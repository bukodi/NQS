package example.pkgbase;

import framework.common.IBusinessObject;
import framework.metamodel.staticc.CalculatedField;
import framework.metamodel.staticc.PersistentField;

public interface Ugyfel extends IBusinessObject {

	final static PersistentField<Ugyfel, Long> UGYFEL_ID = new PersistentField<Ugyfel, Long>(
			Ugyfel.class, "UGYFEL_ID", Long.class); //$NON-NLS-1$

	Long getUGYFEL_ID();

	final static PersistentField<Ugyfel, String> VEZETEKNEV = new PersistentField<Ugyfel, String>(
			Ugyfel.class, "VEZETEKNEV", String.class); //$NON-NLS-1$

	public String getVEZETEKNEV();

	public void setVEZETEKNEV(String vezeteknev);

	final static PersistentField<Ugyfel, String> KERESZTNEV = new PersistentField<Ugyfel, String>(
			Ugyfel.class, "KERESZTNEV", String.class); //$NON-NLS-1$

	public String getKERESZTNEV();

	public void setKERESZTNEV(String keresztnev);

	final static CalculatedField<Ugyfel, String> TELJESNEV = new CalculatedField<Ugyfel, String>(
			Ugyfel.class, "TELJESNEV", String.class, VEZETEKNEV, KERESZTNEV); //$NON-NLS-1$

	public String getTELJESNEV();

	public String sayHello1(String name);

	public String sayHello2(String name);

	public String sayHello3(String name);

	public String sayHello4(String name);

}
