/**
 * 
 */
package com.marasm.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.Util;

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
    log(LogLevel.DEBUG, inMessage);
  }

  public static void debug(String inMessage, Object... inArgs)
  {
    log(LogLevel.DEBUG, inMessage, inArgs);
  }

  public static void debug(String inMessage, Throwable inException)
  {
    log(LogLevel.DEBUG, inMessage, inException);
  }
  
  
  public static void info(String inMessage)
  {
    log(LogLevel.INFO, inMessage);
  }
  
  public static void info(String inMessage, Object... inArgs)
  {
    log(LogLevel.INFO, inMessage, inArgs);
  }
  
  public static void info(String inMessage, Throwable inException)
  {
    log(LogLevel.INFO, inMessage, inException);
  }
  
  
  public static void warn(String inMessage)
  {
    log(LogLevel.WARNING, inMessage);
  }
  
  public static void warn(String inMessage, Object... inArgs)
  {
    log(LogLevel.WARNING, inMessage, inArgs);
  }
  
  public static void warn(String inMessage, Throwable inException)
  {
    log(LogLevel.WARNING, inMessage, inException);
  }
  
  
  public static void error(String inMessage)
  {
    log(LogLevel.ERROR, inMessage);
  }
  
  public static void error(String inMessage, Object... inArgs)
  {
    log(LogLevel.ERROR, inMessage, inArgs);
  }
  
  public static void error(String inMessage, Throwable inException)
  {
    log(LogLevel.ERROR, inMessage, inException);
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
  
  
  private static void log(LogLevel inLogLevel, String inMsg)
  {
    Logger logger = getLogger(); 
    String logStr = addCallingClassToMessage(inMsg);
    
    switch (inLogLevel)
    {
      case DEBUG:
        logger.debug(logStr);
        break;
      
      case INFO:
        logger.info(logStr);
        break;
      
      case WARNING:
        logger.warn(logStr);
        break;

      case ERROR:
        logger.error(logStr);
        break;
      
      default:
        logger.debug(logStr);
        break;
    }
  }


  private static void log(LogLevel inLogLevel, 
    String inMsg, Object... inArgs)
  {
    Logger logger = getLogger();
    String logStr = addCallingClassToMessage(inMsg);
    switch (inLogLevel)
    {
      case DEBUG:
        logger.debug(logStr, inArgs);
        break;
        
      case INFO:
        logger.info(logStr, inArgs);
        break;
        
      case WARNING:
        logger.warn(logStr, inArgs);
        break;
        
      case ERROR:
        logger.error(logStr, inArgs);
        break;
        
      default:
        logger.debug(logStr, inArgs);
        break;
    }
  }
  private static void log(LogLevel inLogLevel, String inMsg, 
    Throwable inException)
  {
    Logger logger = getLogger();
    String logStr = addCallingClassToMessage(inMsg);
    switch (inLogLevel)
    {
      case DEBUG:
        logger.debug(logStr, inException);
        break;
        
      case INFO:
        logger.info(logStr, inException);
        break;
        
      case WARNING:
        logger.warn(logStr, inException);
        break;
        
      case ERROR:
        logger.error(logStr, inException);
        break;
        
      default:
        logger.debug(logStr, inException);
        break;
    }
  }

  private static String addCallingClassToMessage(String inMsg)
  {
    Class<?> clazz = Util.getCallingClass();
    String logStr = "[" + clazz.getSimpleName() + "] - " + inMsg;
    return logStr;
  }

  private enum LogLevel
  {
    DEBUG,
    INFO,
    WARNING,
    ERROR
  }
  
  
}
