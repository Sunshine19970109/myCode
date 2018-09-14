package com.bjsxt.junit4.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;

import static org.hamcrest.Matchers.*;

import org.junit.Test;

import com.bjsxt.junit4.T;

public class TTest {

	@Test
	public void testAdd() {
		System.out.println();
		int z = new T().add(5, 3);
		assertTrue("Z太大",z>3);
		System.out.println("路过的");
		assertEquals("不对",8,z);
		assertThat(z,is(8));
	}
	@Ignore
	@Test(timeout=100)
	public void testDivide(){
		int z = new T().divide(8, 2);
		assertThat(z, is(4));
	}

}
