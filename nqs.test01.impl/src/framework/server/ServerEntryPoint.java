package framework.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ServerEntryPoint {

	public static Object excuteServerCall(String serviceTypeName,
			String methodSignature, Object[] args) throws RemoteException {
		try {
			Class serviceType = Class.forName(serviceTypeName);
			String methodName = methodSignature.substring(0,
					methodSignature.indexOf('('));
			String argsSign =  methodSignature.substring(methodSignature.indexOf('(')+1,
					methodSignature.indexOf(')'));
			List<Class> argTypes = new ArrayList<Class>(); // parse signature			
			for( StringTokenizer st = new StringTokenizer(argsSign, ","); st.hasMoreTokens(); ) {
				Class argType = Class.forName(st.nextToken());
				argTypes.add(argType);
			}
			
			Method method = serviceType.getMethod(methodName, argTypes.toArray(new Class[argTypes.size()]));
			Object impl = ServiceManager.getImpl(serviceType);
			return method.invoke(impl, args);
		} catch (InvocationTargetException e) {
			throw new RemoteException("Server call failed.", e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
