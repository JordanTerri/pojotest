package org.jtbox.test.pojotest;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Class containing reflection useful methods for pojo testing api.
 * 
 * @author JordanTerri
 *
 */
class ReflectionHelper {

	private ReflectionHelper() {
	}

	/**
	 * Check if the following method can be considerate as a getter. A method is
	 * considered as getter if named getXXX and returns an object, or isXXX and
	 * returns a boolean.
	 * 
	 * @param method the method that might be a getter.
	 * @return true if the method can be considered as a getter, false otherwise
	 */
	public static boolean isGetter(Method method) {
		if (Modifier.isPublic(method.getModifiers()) && method.getParameterTypes().length == 0) {
			if (method.getName().matches("^get[A-Z].*") && !method.getReturnType().equals(void.class))
				return true;
			if (method.getName().matches("^is[A-Z].*") && method.getReturnType().equals(boolean.class))
				return true;
		}
		return false;
	}

	/**
	 * Check if the following method can be considered as a setter method. A method
	 * is considered as a setter if named setXXX, have one and only one parameter,
	 * and has nothing in return (void).
	 * 
	 * @param method the method that might be a setter
	 * @return true if the method can be considered as a setter, false otherwise
	 */
	public static boolean isSetter(Method method) {
		if (Modifier.isPublic(method.getModifiers()) && method.getParameterTypes().length == 1
				&& method.getName().matches("^set[A-Z].*") && method.getReturnType().equals(void.class)) {
			return true;
		}
		return false;
	}
}
