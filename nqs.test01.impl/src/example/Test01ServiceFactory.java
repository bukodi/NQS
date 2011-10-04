package example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import example.pkgbase.UgyfelService;
import example.pkgbase.UgyfelServiceImpl;
import example.pkgext.KiemeltUgyfelService;
import example.pkgext.KiemeltUgyfelServiceImpl;
import framework.common.services.NQSServiceFactory;
import framework.common.services.IGenericService;

public class Test01ServiceFactory implements NQSServiceFactory {
		
	private final List<Class<? extends IGenericService>> serviceTypes;

	public Test01ServiceFactory() {
		 serviceTypes = new ArrayList<Class<? extends IGenericService>>();
		 serviceTypes.add(UgyfelService.class);
		 serviceTypes.add(KiemeltUgyfelService.class);
	}
	
	@Override
	public List<Class<? extends IGenericService>> getServiceTypes() {
		return Collections.unmodifiableList(serviceTypes);
	}
	
	
	@Override
	public <SVC extends IGenericService> SVC createService(Class<SVC> serviceTye) {
		if( UgyfelService.class.equals(serviceTye))
			return (SVC) new UgyfelServiceImpl();
		else if( KiemeltUgyfelService.class.equals(serviceTye))
			return (SVC) new KiemeltUgyfelServiceImpl();
		else return null;
	}
}
