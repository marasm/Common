package com.marasm.util;

import static org.junit.Assert.assertEquals;

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
  
  
  

}
