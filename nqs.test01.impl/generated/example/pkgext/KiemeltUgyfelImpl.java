package example.pkgext;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrimaryKeyJoinColumn;

import example.pkgbase.Ugyfel;
import example.pkgbase.UgyfelImpl;
import framework.common.UndefinedFieldException;
import framework.metamodel.IAttribute;
import framework.server.ServiceManager;

@MappedSuperclass
@Access(AccessType.FIELD)
@DiscriminatorValue("KiemeltUgyfel")
@PrimaryKeyJoinColumn(name = "KIEMELTUGYFEL_ID")
// Currently not working. See:
// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330628
class KiemeltUgyfelImpl extends UgyfelImpl implements KiemeltUgyfel {
	
	protected Long KIEMELTUGYFEL_ID;
	
	@Override
	public Long getKIEMELTUGYFEL_ID() {
		return KIEMELTUGYFEL_ID;
	}

	@Override
	public void setKIEMELTUGYFEL_ID(Long kiemeltugyfel_id) {
		this.KIEMELTUGYFEL_ID = kiemeltugyfel_id;
	}

	protected String SZEMELYES_UGYINTEZO;
	
	@Override
	public String getSZEMELYES_UGYINTEZO() {
		return SZEMELYES_UGYINTEZO;
	}

	@Override
	public void setSZEMELYES_UGYINTEZO(String szemelyes_ugyintezo) {
		this.SZEMELYES_UGYINTEZO = szemelyes_ugyintezo;
	}
	
	protected Boolean UTOLSO_TALALKOZO;

	@Override
	public Boolean getUTOLSO_TALALKOZO() {
		return UTOLSO_TALALKOZO;
	}

	@Override
	public void setUTOLSO_TALALKOZO(Boolean utolso_talalkozo) {
		this.UTOLSO_TALALKOZO = utolso_talalkozo;
	}

	@Override
	public String getTELJESNEV() {
		return getVEZETEKNEV() + " " + getKERESZTNEV();
	}

	@Override
	public String sayHello5(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sayHello6(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
