package com.simplilearn.test;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TestNg1 {
	
  @Test
  public void testTrue() {
	  assertEquals(false, false);
  }
}