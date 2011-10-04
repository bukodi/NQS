package framework.common.services;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.ServiceLoader;
import java.util.Set;

import framework.common.IBusinessObject;
import framework.metamodel.IBOTypeDescriptor;

public class NQSBase {
	
	private final static Set<NQSServiceFactory> serviceFactories = new HashSet<NQSServiceFactory>();

	private final static Set<NQSTypeFactory> typeFactories = new HashSet<NQSTypeFactory>();

	private final static Map<Class<? extends IGenericService>, NQSServiceFactory> serviceTypesFactories = new HashMap<Class<? extends IGenericService>, NQSServiceFactory>();

	private final static Map<Class<? extends IBusinessObject>, Class<? extends IBOService>> boTypesServices = new HashMap<Class<? extends IBusinessObject>, Class<? extends IBOService>>();

	private final static Map<Class<? extends IGenericService>, IGenericService> loadedServices = new HashMap<Class<? extends IGenericService>, IGenericService>();

	private final static Map<Class<? extends IBusinessObject>, IBOService> loadedBOServices = new HashMap<Class<? extends IBusinessObject>, IBOService>();

	private final static Map<Class<? extends IBusinessObject>, IBOTypeDescriptor<?>> loadedTypeDescriptors = new HashMap<Class<? extends IBusinessObject>, IBOTypeDescriptor<?>>();

	static {
		loadServices();
		loadTypeDescriptors();
	}

	private static void loadServices() {
		// TODO: handling inheritance
		ServiceLoader<NQSServiceFactory> sl = ServiceLoader
				.load(NQSServiceFactory.class);

		// Loop on factories
		for (Iterator<NQSServiceFactory> it = sl.iterator(); it.hasNext();) {
			NQSServiceFactory boSvcFactory = it.next();
			serviceFactories.add(boSvcFactory);

			// Loop on service types of current factory
			for (Class<? extends IGenericService> svcType : boSvcFactory
					.getServiceTypes()) {
				serviceTypesFactories.put(svcType, boSvcFactory);

				// Check is an IBOEntityService
				if (IBOService.class.isAssignableFrom(svcType)) {
					// Extract boType
					Class<?> boType = null;
					for (Type ifType : svcType.getGenericInterfaces()) {
						if (!(ifType instanceof ParameterizedType))
							continue;
						ParameterizedType boServiceType = (ParameterizedType) ifType;
						if (!IBOService.class
								.equals(boServiceType.getRawType()))
							continue;
						Type[] typeParams = boServiceType.getActualTypeArguments();
						if( (typeParams.length != 1) || (! (typeParams[0] instanceof Class) ) )
							throw new RuntimeException("Invalid class hierarchy:" + svcType );
						boType = (Class)typeParams[0];
						if( ! IBusinessObject.class.isAssignableFrom( boType) )
							throw new RuntimeException("Invalid class hierarchy:" + svcType );
						break;
					}
					if( boType == null )
						throw new RuntimeException("Invalid class hierarchy:" + svcType );
					// Register entity service
					boTypesServices.put((Class<IBusinessObject>)boType, (Class<IBOService>)svcType);
				}
			}
		}
	};

	private static void loadTypeDescriptors() {
		// TODO: handling inheritance
		ServiceLoader<NQSTypeFactory> sl = ServiceLoader
				.load(NQSTypeFactory.class);

		// Loop on factories
		for (Iterator<NQSTypeFactory> it = sl.iterator(); it.hasNext();) {
			NQSTypeFactory boTypeFactory = it.next();
			typeFactories.add(boTypeFactory);

			// Loop on types of current factory
			for (Class<? extends IBusinessObject> boType : boTypeFactory
					.getBOTypes()) {
				try {
					loadedTypeDescriptors.put(boType, boTypeFactory.getBOTypeDescriptor(boType));
				} catch (Exception e) {
					throw new RuntimeException( e );
				}
			}
		}
	};

	public static <BO extends IBusinessObject> IBOTypeDescriptor<BO> getBOTypeDescriptor(
			Class<BO> boType) throws NoSuchElementException,
			RuntimeException {
		// Argument checking
		if (boType == null)
			throw new NullPointerException("boType");

		IBOTypeDescriptor<BO> typeDesc;
		// Fast lookup in loadedServices
		synchronized (loadedTypeDescriptors) {
			typeDesc = (IBOTypeDescriptor<BO>) loadedTypeDescriptors.get(boType);
			if (typeDesc != null)
				return typeDesc;
			else
				throw new NoSuchElementException(boType.getName());
		}
	}

	public static <SVC extends IGenericService> SVC getService(
			Class<SVC> serviceType) throws NoSuchElementException,
			RuntimeException {
		// Argument checking
		if (serviceType == null)
			throw new NullPointerException("serviceType");

		SVC svcImpl;
		// Fast lookup in loadedServices
		synchronized (loadedServices) {
			svcImpl = (SVC) loadedServices.get(serviceType);
			if (svcImpl != null)
				return svcImpl;
		}

		if (!serviceTypesFactories.containsKey(serviceType))
			throw new NoSuchElementException(
					"No such registered service implementation for type: "
							+ serviceType.toString());

		// Not loaded > load it
		synchronized (serviceType) {
			NQSServiceFactory factory = serviceTypesFactories.get(serviceType);
			try {
				svcImpl = factory.createService(serviceType);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			synchronized (loadedServices) {
				loadedServices.put(serviceType, svcImpl);
				return svcImpl;
			}
		}
	}

	public static <BO extends IBusinessObject> IBOService<BO> getBOService(
			Class<BO> boType) {
		// Argument checking
		if (boType == null)
			throw new NullPointerException("boType");

		IBOService<BO> svcImpl;
		// Fast lookup in loadedServices
		synchronized (loadedBOServices) {
			svcImpl = (IBOService<BO>)loadedBOServices.get(boType);
			if (svcImpl != null)
				return svcImpl;
		}

		if (!boTypesServices.containsKey(boType))
			throw new NoSuchElementException(
					"No such registered BO service implementation for type: "
							+ boType.toString());

		// Not loaded > load it
		synchronized (boType) {
			Class<? extends IBOService> serviceType = boTypesServices.get(boType);
			svcImpl = getService(serviceType);
			synchronized (loadedBOServices) {
				loadedBOServices.put(boType, svcImpl);
				return svcImpl;
			}
		}
	}
}
