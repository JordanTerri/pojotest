package org.jtbox.test.pojotest;

import java.lang.reflect.ParameterizedType;

import org.junit.Test;

import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

/**
 * 
 * @author JordanTerri
 *
 * @param <T>
 */
public abstract class AbstractPojoTester<T> {

	@SuppressWarnings("unchecked")
	protected Class<T> clazzUnderTest = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
			.getActualTypeArguments()[0];

	public void testGetterAndSetter() {
		Assertions.assertPojoMethodsFor(clazzUnderTest).testing(Method.SETTER, Method.GETTER).areWellImplemented();
	}

	@Test
	public void test() {
		testGetterAndSetter();
	}
}
