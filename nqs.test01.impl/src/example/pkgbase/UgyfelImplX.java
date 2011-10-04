package example.pkgbase;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "Ugyfel")
class UgyfelImplX extends UgyfelImpl  {

	@Override
	public String sayHello2(String name) {
		return super.sayHello2(name) + " modified by BaseImplX";
	}

	@Override
	public String getTELJESNEV() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
