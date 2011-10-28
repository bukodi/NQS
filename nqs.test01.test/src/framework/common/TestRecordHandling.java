package framework.common;

import org.junit.Test;

import example.pkgbase.Ugyfel;

public class TestRecordHandling {
	
	@Test
	public void buildRawRecord() throws Exception {
		@SuppressWarnings("unchecked")
		RecordFormat<Ugyfel> rf = new RecordFormat<Ugyfel>( Ugyfel.class, Ugyfel.KERESZTNEV, Ugyfel.VEZETEKNEV );
		RecordList<Ugyfel> list = new RecordList<Ugyfel>(rf);
		
		// Add first record
		Record<Ugyfel> tesztAnna = new Record<Ugyfel>(rf);
		tesztAnna.set(Ugyfel.VEZETEKNEV, "Teszt");
		tesztAnna.set(Ugyfel.KERESZTNEV, "Anna");
		list.add(tesztAnna);
		
		// Add second record		
		list.add(rf.newRecord().set(Ugyfel.VEZETEKNEV, "Teszt").set(Ugyfel.KERESZTNEV, "Bea"));
		
		// Add third record		
		list.newRecord().set(Ugyfel.VEZETEKNEV, "Teszt").set(Ugyfel.KERESZTNEV, "Cili");
		
		
		System.out.println( list.toString());
		
	}

	static class UgyfelNev extends Record<Ugyfel> {
		String VEZETEKNEV = Ugyfel.VEZETEKNEV.initialValue();
		String KERESZTNEV = Ugyfel.KERESZTNEV.initialValue();
	};

	@Test
	public void buildTypedRecord() {
		TypedRecordList<Ugyfel, UgyfelNev> list = new TypedRecordList<Ugyfel, UgyfelNev>(UgyfelNev.class);
				
		// Add first record
		UgyfelNev tesztAnna = new UgyfelNev();
		tesztAnna.set(Ugyfel.VEZETEKNEV, "Teszt");
		tesztAnna.set(Ugyfel.KERESZTNEV, "Anna");
		list.add(tesztAnna);
		
		// Add second record		
		UgyfelNev tesztBea = new UgyfelNev();
		tesztBea.VEZETEKNEV = "Teszt";
		tesztBea.KERESZTNEV = "Bea";
		list.add(tesztBea);
		
		// Add third record		
		list.newRecord().set(Ugyfel.VEZETEKNEV, "Teszt").set(Ugyfel.KERESZTNEV, "Cili");		

		System.out.println( list.toString());
	}
	
}
