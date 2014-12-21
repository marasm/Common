package com.marasm.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFileUtil
{

  @Test
  public void testGetFileExtention_null()
  {
    assertNull(FileUtil.getExtentionFromFileName(null));
  }

  @Test
  public void testGetFileExtention_empty()
  {
    assertEquals("", FileUtil.getExtentionFromFileName(""));
  }

  @Test
  public void testGetFileExtention_txt()
  {
    assertEquals(".txt", FileUtil.getExtentionFromFileName("test.txt"));
  }

  @Test
  public void testGetFileExtention_txtx()
  {
    assertEquals(".txtx", FileUtil.getExtentionFromFileName("test.txtx"));
  }

  @Test
  public void testGetFileExtention_txt_multidots()
  {
    assertEquals(".txt", FileUtil.getExtentionFromFileName("test.this.long.name.txt"));
  }
  
  @Test
  public void testGetFileNameNoExtention_txt()
  {
    assertEquals("test", FileUtil.getFileNameWithNoExtention("test.txt"));
  }

  @Test
  public void testGetFileNameNoExtention_txt_multidots()
  {
    assertEquals("test.hello.kitty", FileUtil.getFileNameWithNoExtention("test.hello.kitty.txt"));
  }
  
  @Test
  public void testGetFileNameNoExtention_no_ext()
  {
    assertEquals("test", FileUtil.getFileNameWithNoExtention("test"));
  }

  @Test
  public void testGetNumberFromFileName_with_number()
  {
    assertEquals("123", FileUtil.getNumberFromFileName("test123.txt"));
  }

  @Test
  public void testGetNumberFromFileName_with_number_no_ext()
  {
    assertEquals("123", FileUtil.getNumberFromFileName("test123"));
  }
  
  @Test
  public void testGetNumberFromFileName_no_number()
  {
    assertEquals("", FileUtil.getNumberFromFileName("test.txt"));
  }

  @Test
  public void testGetNumberFromFileName_numbers_in_file_and_ext()
  {
    assertEquals("1", FileUtil.getNumberFromFileName("Part 1 - Intro.mp4"));
  }

  @Test
  public void testGetNumberFromFileName_MULTI_numbers_in_file()
  {
    assertEquals("1", FileUtil.getNumberFromFileName("[MGS2] Part 1 - Intro.mp4"));
  }
}
