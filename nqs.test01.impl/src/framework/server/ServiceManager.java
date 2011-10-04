package framework.server;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class ServiceManager {
	
	private final static Map<Class, Object> typeImplementations = new HashMap<Class, Object>();

	public static <T> T getImpl(Class<T> type) {
		ServiceLoader<T> sl = ServiceLoader.loadInstalled(type);
		
		return (T) typeImplementations.get(type);
	}

	public static <T> void addImpl(Class<T> type, T singleton) {
		if (!type.isInterface())
			throw new RuntimeException();
		typeImplementations.put(type, singleton);

		for (Class superIf : type.getInterfaces()) {
			if (typeImplementations.containsKey(superIf))
				addImpl(superIf, singleton);
		}

	}

}
