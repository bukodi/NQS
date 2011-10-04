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
@DiscriminatorValue( "KiemeltUgyfel")
@PrimaryKeyJoinColumn(name="KIEMELTUGYFEL_ID") // Currently not working.  See: https://bugs.eclipse.org/bugs/show_bug.cgi?id=330628
class KiemeltUgyfelImpl extends UgyfelImpl implements KiemeltUgyfel {
	
	

	@Override
	public <V> V get(KiemeltUgyfel.Attr<V> field)
			throws UndefinedFieldException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <V> void set(KiemeltUgyfel.Attr<V> field, V value)
			throws UndefinedFieldException {
		// TODO Auto-generated method stub
	}

	/*** Delegating methods to implementation methods ***/
	protected transient KiemeltUgyfel impl = (KiemeltUgyfel) ServiceManager
			.getImpl(KiemeltUgyfel.class);

	//@formatter:off
	public String sayHello1(String name) { return impl.sayHello1(name);	}
	public String sayHello2(String name) { return impl.sayHello2(name);	}
	public String sayHello3(String name) { return impl.sayHello3(name);	}
	public String sayHello4(String name) { return impl.sayHello4(name);	}
	public String sayHello5(String name) { return impl.sayHello5(name);	}
	public String sayHello6(String name) { return impl.sayHello6(name);	}
	@Override public Long getUGYFEL_ID() { return impl.getUGYFEL_ID(); }
	@Override public String getKERESZTNEV() { return impl.getKERESZTNEV(); }
	@Override public void setKERESZTNEV(String keresztnev) { impl.setKERESZTNEV(keresztnev); }
	@Override public String getVEZETEKNEV() { return getVEZETEKNEV(); }
	@Override public void setVEZETEKNEV(String vezeteknev) { impl.setVEZETEKNEV(vezeteknev); }
	@Override public String getTELJESNEV() { return impl.getTELJESNEV(); }
	//@formatter:on

}
