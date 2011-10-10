package example.pkgext;

import example.pkgbase.Ugyfel;
import framework.metamodel.IPersistentField;
import framework.metamodel.staticc.PersistentField;

public interface KiemeltUgyfel extends Ugyfel {

	final static IPersistentField<KiemeltUgyfel, Long> KIEMELTUGYFEL_ID = new PersistentField<KiemeltUgyfel, Long>(
			KiemeltUgyfel.class, "KIEMELTUGYFEL_ID", Long.class); //$NON-NLS-1$

	Long getKIEMELTUGYFEL_ID();

	void setKIEMELTUGYFEL_ID(Long kiemeltugyfel_id);

	final static IPersistentField<KiemeltUgyfel, String> SZEMELYES_UGYINTEZO = new PersistentField<KiemeltUgyfel, String>(
			KiemeltUgyfel.class, "SZEMELYES_UGYINTEZO", String.class); //$NON-NLS-1$

	String getSZEMELYES_UGYINTEZO();

	void setSZEMELYES_UGYINTEZO(String szemelyes_ugyintezo);

	final static IPersistentField<KiemeltUgyfel, Boolean> UTOLSO_TALALKOZO = new PersistentField<KiemeltUgyfel, Boolean>(
			KiemeltUgyfel.class, "UTOLSO_TALALKOZO", Boolean.class); //$NON-NLS-1$

	Boolean getUTOLSO_TALALKOZO();

	void setUTOLSO_TALALKOZO(Boolean utolso_talalkozo);

	public static class INSTANCES {
		static KiemeltUgyfel KOVACS_JANOS;
		static KiemeltUgyfel VARGA_BELA;
	}

	public String sayHello3(String name);

	public String sayHello4(String name);

	public String sayHello5(String name);

	public String sayHello6(String name);
}
