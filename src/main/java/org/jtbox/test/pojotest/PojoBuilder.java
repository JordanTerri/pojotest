package org.jtbox.test.pojotest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class used to make one or more POJO objects.
 * 
 * @author JordanTerri
 *
 */
public class PojoBuilder {

	private final static Logger log = LoggerFactory.getLogger("org.jtbox.test.pojotest");

	private PojoBuilder() {
	}

	public static <T> T createOne(final Class<T> clazz) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchMethodException {
		T myInstance = ( (Constructor<T>) clazz.getConstructor() ).newInstance();
		Method[] methodList = clazz.getMethods();
		for (Method method : methodList) {
			if (ReflectionHelper.isSetter(method)) {
				invokeSetter(myInstance, method, 0);
			}
		}
		return myInstance;
	}

	public static <T> T createOne(final Class<T> clazz, final int index)
			throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		T myInstance = ( (Constructor<T>) clazz.getConstructor() ).newInstance();
		Method[] methodList = clazz.getMethods();
		for (Method method : methodList) {
			if (ReflectionHelper.isSetter(method)) {
				invokeSetter(myInstance, method, index);
			}
		}
		return myInstance;
	}

	public static <T> List<T> createMany(final Class<T> clazz, final int index)
			throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		List<T> list = new ArrayList<>();
		for (int i = 0; i < index; i++) {
			T t = createOne(clazz, i);
			list.add(t);
		}
		return list;
	}

	private static <T> void invokeSetter(T instance, Method setterMethod, int index) {
		Class<?>[] parameterTypes = setterMethod.getParameterTypes();
		if (parameterTypes.length > 1) {
			throw new IllegalArgumentException(
					"A setter can't have multiple parameters: check " + setterMethod.getName());
		}
		Class<?> parameter = parameterTypes[0];

		log.trace("Setting field {} using {}", parameter.getName(), setterMethod.getName());

		try {
			switch (parameter.getName()) {
			case "java.lang.String":
				setterMethod.invoke(instance, setterMethod.getName() + "-" + index);
				break;
			case "int":
				setterMethod.invoke(instance, Integer.valueOf(index));
				break;
			case "float":
				setterMethod.invoke(instance, Float.valueOf(index));
				break;
			case "double":
				setterMethod.invoke(instance, Double.valueOf(index));
				break;
			case "long":
				setterMethod.invoke(instance, Long.valueOf(index));
				break;
			case "char":
				setterMethod.invoke(instance, Character.valueOf((char) (index % 65535)));
				break;
			case "short":
				setterMethod.invoke(instance, Short.valueOf((short) (index % 32767)));
				break;
			case "boolean":
				setterMethod.invoke(instance, Boolean.valueOf(false));
				break;
			case "java.util.List":
				setterMethod.invoke(instance, new ArrayList<>());
				break;
			case "java.util.Map":
				setterMethod.invoke(instance, new HashMap<>());
				break;
			case "java.util.Set":
				setterMethod.invoke(instance, new HashSet<>());
				break;
			case "java.util.Date":
				setterMethod.invoke(instance, new Date());
				break;
			default:
				setterMethod.invoke(instance, Class.forName(parameter.getName()));
				break;
			}
		} catch (Exception e) {
			log.error("Couldn't set properly field {} using {}: {}", parameter.getName(), setterMethod.getName(),
					e.getMessage());
		}
	}
}
