package example.pkgbase;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import framework.common.UndefinedFieldException;
import framework.metamodel.IAttribute;

@MappedSuperclass
@Access( AccessType.FIELD)
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class UgyfelImpl implements Ugyfel {
			
	@Override
	public <V> V get(Ugyfel.Attr<V> field)
			throws UndefinedFieldException {
		if( field.equals(ID) ) 
			return (V)getPrimaryKey();
		else if ( field.equals(KERESZTNEV) )
			return (V)getKERESZTNEV();
		else if ( field.equals(VEZETEKNEV) )
			return (V)getVEZETEKNEV();
		else
			throw new UndefinedFieldException((IAttribute<?, ?>) field);
	}

	@Override
	public <V> void set(Ugyfel.Attr<V> field, V value)
			throws UndefinedFieldException {		
		if( field.equals(ID) ) 
			ID = (Long) value;
		else if ( field.equals(KERESZTNEV) )
			setKERESZTNEV((String) value);
		else if ( field.equals(VEZETEKNEV) )
			setVEZETEKNEV((String) value);
		else
			throw new UndefinedFieldException((IAttribute<?, ?>) field);
	}

	@Id
	@Column(name = "UGYFEL_ID")
	protected Long ID;
	
	protected String KERESZTNEV;

	protected String VEZETEKNEV; 
		
	@Override
	public final Object getPrimaryKey() {
		return getUGYFEL_ID();
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

	@Override
	public Long getUGYFEL_ID() {
		return ID;
	}

	@Override
	public String getKERESZTNEV() {
		return KERESZTNEV;
	}

	@Override
	public void setKERESZTNEV(String keresztnev) {
		KERESZTNEV = keresztnev;		
	}

	@Override
	public String getVEZETEKNEV() {
		return VEZETEKNEV;
	}

	@Override
	public void setVEZETEKNEV(String vezeteknev) {
		VEZETEKNEV = vezeteknev;		
	}
}
