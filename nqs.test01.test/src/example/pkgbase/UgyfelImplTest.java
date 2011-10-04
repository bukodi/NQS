package example.pkgbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import example.pkgbase.UgyfelImplTest.Ugyfel1;
import framework.common.Filter;
import framework.common.Record;
import framework.common.RecordFormat;
import framework.common.RecordList;
import framework.common.services.IBOService;
import framework.common.services.NQSBase;

public class UgyfelImplTest {

	EntityManager em;
	EntityManagerFactory emf;

	@Before
	public void setUp() throws Exception {
		Map<String, String> properties = new HashMap<String, String>();
        properties.put("javax.persistence.jdbc.driver", "oracle.jdbc.driver.OracleDriver");
        properties.put("javax.persistence.jdbc.url", "jdbc:oracle:thin:@127.0.0.1:1521:XE");
        properties.put("javax.persistence.jdbc.user", "test02");
        properties.put("javax.persistence.jdbc.password", "test02");
		
		emf = Persistence.createEntityManagerFactory("nqs.test01.server", properties);		
		em = emf.createEntityManager();		
	}		

	@After
	public void tearDown() throws Exception {
		em.close();
	}
	
	@Test
	public void test01() throws IOException {
		UgyfelService svc1 = NQSBase.getService(UgyfelService.class);
		//Class<Ugyfel> clazz = svc1.getServedType();
		System.out.println( svc1);
		
		RecordList<Ugyfel1> ds = new RecordList<Ugyfel1>();
		
		
		IBOService<Ugyfel> svc2 = NQSBase.getBOService(Ugyfel.class);
		System.out.println( svc2); 
		//Ugyfel bo = new Ugyfel();
		//svc2.store( bo );
	}

	@Test
	public void bulkInsert() throws IOException {
		UgyfelService svc1 = NQSBase.getService(UgyfelService.class);

		List<Ugyfel1> list = new ArrayList<Ugyfel1>();
		for( int i = 0; i < 10; i++ ) {
			Ugyfel1 uf1 = new Ugyfel1();
			uf1.KERESZTNEV = "Giz";
			list.add(new Ugyfel1());
		}
		svc1.store(list);
		
		RecordList<Ugyfel1> ds = new RecordList<UgyfelImplTest.Ugyfel1>();
		
		
		IBOService<Ugyfel> svc2 = NQSBase.getBOService(Ugyfel.class);
		System.out.println( svc2); 
		//Ugyfel bo = new Ugyfel();
		//svc2.store( bo );
	}

	static class Ugyfel1 extends Record<Ugyfel> {
		Long UGYFEL_ID = Ugyfel.META.UGYFEL_ID.initialValue();
		String KERESZTNEV = Ugyfel.META.KERESZTNEV.initialValue();
	};

	static class Ugyfel2 extends Ugyfel1 {
		UgyfelFelettes1 FELETTES;

		static class UgyfelFelettes1 extends Record<Ugyfel> {
			String VEZETEKNEV = Ugyfel.META.VEZETEKNEV.initialValue();
			String KERESZTNEV = Ugyfel.META.KERESZTNEV.initialValue();
		};
	};

	@Test
	public void test02() throws IOException {
		IBOService<Ugyfel> svc2 = NQSBase.getBOService(Ugyfel.class);
		Ugyfel1 ur1 = new Ugyfel1();
		
		Filter<Ugyfel> filter = null;
		svc2.query(null, filter );
		
		RecordList<Ugyfel1> dsUf1 = new RecordList<Ugyfel1>();
		
		svc2.store(dsUf1);
	}

}
