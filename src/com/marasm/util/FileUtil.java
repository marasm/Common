/**
 * 
 */
package com.marasm.util;

/**
 * @author mkorotkovas
 *
 */
public class FileUtil
{
  public static String getExtentionFromFileName(String inFileName)
  {
    if (StringUtil.isEmpty(inFileName))
    {
      return inFileName;
    }
    else
    {
      if (inFileName.lastIndexOf(".") <= 0)
      {
        return inFileName;
      }
      return inFileName.substring(inFileName.lastIndexOf("."), 
          inFileName.length());
    }
  }
  
  public static String getFileNameWithNoExtention(String inFileName)
  {
    if (StringUtil.isEmpty(inFileName))
    {
      return inFileName;
    }
    else
    {
      if (inFileName.lastIndexOf(".") <= 0)
      {
        return inFileName;
      }
      return inFileName.substring(0, inFileName.lastIndexOf("."));
    }
  }
  
  
  public static String getNumberFromFileName(String inFileName)
  {
    if (StringUtil.isEmpty(inFileName))
    {
      return inFileName;
    }
    else
    {
      //the assumption is that the part index is going to be at the end of the
      //file name, so build the number starting from the tail of the file name
      String fName = getFileNameWithNoExtention(inFileName);
      String result = ""; 
      for (int i = fName.length(); i >= 1; i--)
      {
        String curChar = fName.substring(i-1, i);
        if (StringUtil.isValidPositiveNumber(curChar, 10))
          result = curChar + result;
        else if (!StringUtil.isEmpty(result))
          break;
          
      }
      return result;
    }
  }
}
