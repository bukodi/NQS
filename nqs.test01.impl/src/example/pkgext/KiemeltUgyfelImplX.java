package example.pkgext;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table( name = "KiemeltUgyfel")
class KiemeltUgyfelImplX extends KiemeltUgyfelImpl {
	
	@Override
	public String sayHello3(String name) {
		return super.sayHello3(name) + " modified by ExtendedImplX";
	}

	@Override
	public String sayHello6(String name) {
		return super.sayHello6(name) + " modified by ExtendedImplX";
	}
		

}
