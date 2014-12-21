/**
 * 
 */
package com.marasm.util;

import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mkorotkovas
 *
 */
public class StringUtil
{
  public static boolean isEmpty(String inStr)
  {
    return inStr == null || inStr.trim().length() == 0;
  }
  
  public static boolean isValidPositiveNumber(String inStr, int inMax)
  {
    boolean validNumber = false;
    if (!isEmpty(inStr))
    {
      // Only accepts positive numbers of up to 9 numbers.
      Pattern intsOnly = Pattern.compile("^\\d{1,9}$");
      Matcher makeMatch = intsOnly.matcher(inStr);
      
      if (makeMatch.find()) 
      {
        int number = Integer.parseInt(makeMatch.group());
        if ((number >= 0) && (number < inMax)) 
        {
          validNumber = true;
        }
      }
    }
    return validNumber;
  }
  
  public static String getProgressBarString(double inProgress)
  {
    StringBuilder res = new StringBuilder("[");
    for (int i = 0; i < 50; i++)
    {
      if (i < inProgress * 50)
      {
        res.append("|");
      }
      else
      {
        res.append("-");
      }
    }
    res.append("] "); 
    res.append(NumberFormat.getPercentInstance().format(inProgress));
    return res.toString();
  }

}
