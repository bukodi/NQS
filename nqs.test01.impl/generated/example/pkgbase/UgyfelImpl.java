package example.pkgbase;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Access( AccessType.FIELD)
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class UgyfelImpl implements Ugyfel {
			
	@Id
	@Column(name = "UGYFEL_ID")
	protected Long UGYFEL_ID;
	
	@Override
	public Long getUGYFEL_ID() {
		return UGYFEL_ID;
	}

	protected String VEZETEKNEV; 
	
	@Override
	public String getVEZETEKNEV() {
		return VEZETEKNEV;
	}

	@Override
	public void setVEZETEKNEV(String vezeteknev) {
		this.VEZETEKNEV = vezeteknev;		
	}
	
	protected String KERESZTNEV;

	@Override
	public String getKERESZTNEV() {
		return KERESZTNEV;
	}

	@Override
	public void setKERESZTNEV(String keresztnev) {
		this.KERESZTNEV = keresztnev;		
	}

	@Override
	public String getTELJESNEV() {
		return getVEZETEKNEV() + " " + getKERESZTNEV();
	}

	@Override
	public String sayHello1(String name) {
		return "Hello1 - BaseImpl";
	}

	@Override
	public String sayHello2(String name) {
		return "Hello2 - BaseImpl";
	}
	
	@Override
	public String sayHello3(String name) {
		return "Hello3 - BaseImpl";
	}

	@Override
	public String sayHello4(String name) {
		return "Hello4 - BaseImpl";
	}

}
