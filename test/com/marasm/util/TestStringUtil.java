package com.marasm.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringUtil
{

  @Test
  public void testPrintProgressBar_0()
  {
    assertEquals("[--------------------------------------------------] 0%", 
        StringUtil.getProgressBarString(0));
  }

  
  @Test
  public void testPrintProgressBar_100()
  {
    assertEquals("[||||||||||||||||||||||||||||||||||||||||||||||||||] 100%", 
        StringUtil.getProgressBarString(1));
  }

  @Test
  public void testPrintProgressBar_50()
  {
    assertEquals("[|||||||||||||||||||||||||-------------------------] 50%", 
        StringUtil.getProgressBarString(.5));
  }
  
  @Test
  public void testleftZeroPadNumber_PAD_10_TO_12digts()
  {
    assertEquals("000000000010", StringUtil.leftZeroPadNumber(10, 12));
  }

  
  @Test
  public void testleftZeroPadNumber_PAD_LARGE_NUMBER_TO_SMALLER_SIZE()
  {
    assertEquals("1000000", StringUtil.leftZeroPadNumber(1000000, 3));
  }

  @Test
  public void testleftZeroPadNumber_ZERO_INPUTS()
  {
    assertEquals("0", StringUtil.leftZeroPadNumber(0, 0));
  }
  
  @Test
  public void testRemoveSubStringFromString_NULL() throws Exception
  {
    assertNull(StringUtil.removeSubStringFromString(null, null));
  }

  @Test
  public void testRemoveSubStringFromString_EMPTY() throws Exception
  {
    assertEquals("", StringUtil.removeSubStringFromString("", ""));
  }

  @Test
  public void testRemoveSubStringFromString_NOTHING_TO_REMOVE() throws Exception
  {
    assertEquals("testStringIsTest", StringUtil.removeSubStringFromString("testStringIsTest", ""));
  }

  @Test
  public void testRemoveSubStringFromString_NO_MATCH() throws Exception
  {
    assertEquals("testStringIsTest", StringUtil.removeSubStringFromString("testStringIsTest", "hello"));
  }

  @Test
  public void testRemoveSubStringFromString_SUCCESS() throws Exception
  {
    assertEquals("testIsTest", StringUtil.removeSubStringFromString("testStringIsTest", "String"));
  }

}
