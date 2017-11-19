/**
 * 
 */
package com.marasm.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.marasm.util.StringUtil;

/**
 * @author makorotkovas
 *
 */
public class AppLogger
{
  private static String loggerName;
  
  
  public static void initLogger(String inLoggerName)
  {
    loggerName = inLoggerName;
  }
  
  
  public static void debug(String inMessage)
  {
    Logger logger = getLogger(); 
    String logStr = addCallingClassToMessage(inMessage);
    logger.debug(logStr);
  }

  public static void debug(String inMessage, Object... inArgs)
  {
    Logger logger = getLogger(); 
    String logStr = addCallingClassToMessage(inMessage);
    logger.debug(logStr, inArgs);
  }

  public static void debug(String inMessage, Throwable inException)
  {
    Logger logger = getLogger(); 
    String logStr = addCallingClassToMessage(inMessage);
    logger.debug(logStr, inException);
  }
  
  
  public static void info(String inMessage)
  {
    Logger logger = getLogger(); 
    String logStr = addCallingClassToMessage(inMessage);
    logger.info(logStr); 
  }
  
  public static void info(String inMessage, Object... inArgs)
  {
    Logger logger = getLogger(); 
    String logStr = addCallingClassToMessage(inMessage);
    logger.info(logStr, inArgs);
  }
  
  public static void info(String inMessage, Throwable inException)
  {
    Logger logger = getLogger(); 
    String logStr = addCallingClassToMessage(inMessage);
    logger.info(logStr, inException);
  }
  
  
  public static void warn(String inMessage)
  {
    Logger logger = getLogger(); 
    String logStr = addCallingClassToMessage(inMessage);
    logger.warn(logStr, inMessage);
  }
  
  public static void warn(String inMessage, Object... inArgs)
  {
    Logger logger = getLogger(); 
    String logStr = addCallingClassToMessage(inMessage);
    logger.warn(logStr, inArgs);
  }
  
  public static void warn(String inMessage, Throwable inException)
  {
    Logger logger = getLogger(); 
    String logStr = addCallingClassToMessage(inMessage);
    logger.warn(logStr, inException);
  }
  
  
  public static void error(String inMessage)
  {
    Logger logger = getLogger(); 
    String logStr = addCallingClassToMessage(inMessage);
    logger.error(logStr);
  }
  
  public static void error(String inMessage, Object... inArgs)
  {
    Logger logger = getLogger(); 
    String logStr = addCallingClassToMessage(inMessage);
    logger.error(logStr, inArgs);
  }
  
  public static void error(String inMessage, Throwable inException)
  {
    Logger logger = getLogger(); 
    String logStr = addCallingClassToMessage(inMessage);
    logger.error(logStr, inException);
  }
  
  
  
  
  private static Logger getLogger()
  {
    if (StringUtil.isEmpty(loggerName))
    {
      return LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    }
    else
    {
      return LoggerFactory.getLogger(loggerName);
    }
  }
  
  
  private static String addCallingClassToMessage(String inMsg)
  {
    String callingClazz = getCallingClassName();
    String logStr = "[" + callingClazz + "] - " + inMsg;
    return logStr;
  }

  
  private static String getCallingClassName()
  {
    StackTraceElement[] stackTrace = new Exception().getStackTrace();
    try
    {
      for (int i = 0; i < stackTrace.length; i++)
      {
        StackTraceElement stElem = stackTrace[i];
        if (!AppLogger.class.getName().equals(stElem.getClassName()) && 
          !stElem.getClassName().contains("Logger"))
        {
          return Class.forName(stElem.getClassName()).getSimpleName();
        }
      }
      
      //unable to find a caller that is not the logger itself. Will use the top most caller.
      return Class.forName(stackTrace[stackTrace.length - 1].getClassName()).getSimpleName();
      
    }
    catch (Exception e)
    {
      return "UNKNOWN";
    }
  }
  
  
}
