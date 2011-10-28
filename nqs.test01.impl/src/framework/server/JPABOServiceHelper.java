package framework.server;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import example.pkgbase.Ugyfel;
import framework.common.Filter;
import framework.common.IBOReference;
import framework.common.IBusinessObject;
import framework.common.Record;
import framework.common.RecordFormat;
import framework.metamodel.IAttribute;
import framework.metamodel.IPersistentField;

public class JPABOServiceHelper {
	
	private final static JPABOServiceHelper SINGLETON = new JPABOServiceHelper();
	
	public static JPABOServiceHelper get() {
		return SINGLETON;
	}
	
	private final EntityManagerFactory emf;
	private final EntityManager em;
	private final Metamodel mm;
	
	private JPABOServiceHelper() {
		emf = Persistence.createEntityManagerFactory("nqs.test01.server");
		em = emf.createEntityManager();
		mm = em.getMetamodel();		 
	}
	
	public <BO extends IBusinessObject, R extends Record<BO>> Iterable<R> query(RecordFormat<BO> recordFormat,
			Filter<BO> filter) {

		for( IAttribute<? super BO, ?> attr : recordFormat.attributes ) {
			if( attr instanceof IPersistentField ) {
				
			} else {
				// TODO
			}
		}
		
		
		
		Set<EntityType<?>> entityTypeSet = mm.getEntities();
		EntityType[] entityTypes = new EntityType[entityTypeSet.size()];
		entityTypeSet.toArray(entityTypes);
		for( EntityType et : mm.getEntities() ) {
			System.out.println( et.getName() + "->" + et.getBindableJavaType() + ", " + et.getJavaType() );
		}
		Query q = em.createQuery("SELECT u FROM Ugyfel u WHERE u.KERESZTNEV IS NOT NULL");
		List result = q.getResultList();
		
		return null;
	}

	public <BO extends IBusinessObject, R extends Record<Ugyfel>> Iterable<IBOReference<Ugyfel>> store(
			Iterable<R> records) {
		// TODO Auto-generated method stub
		return null;
	}


}
