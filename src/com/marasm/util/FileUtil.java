/**
 * 
 */
package com.marasm.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author mkorotkovas
 *
 */
public class FileUtil
{
  public static final List<String> IMAGE_FILE_EXT = Arrays.asList(
      ".png",".jpg");
  public static final List<String> VIDEO_FILE_EXT = Arrays.asList(
      ".avi");
  
  
  
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
  
  public static boolean isAnImageFile(File inFile)
  {
    return inFile != null &&
        inFile.exists() &&
        inFile.isFile() && 
        IMAGE_FILE_EXT.contains(getExtentionFromFileName(
                inFile.getName()).toLowerCase());
  }

  public static boolean isAVideoFile(File inFile)
  {
    return inFile != null &&
        inFile.exists() &&
        inFile.isFile() &&
        VIDEO_FILE_EXT.contains(
            FileUtil.getExtentionFromFileName(
                inFile.getName().toLowerCase()));
  }
  
}
