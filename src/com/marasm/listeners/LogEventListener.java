/**
 * 
 */
package com.marasm.listeners;

import java.util.EventListener;

/**
 * @author mkorotkovas
 *
 */
public interface LogEventListener extends EventListener
{
  public void logEventPerformed(String inLogMessage);
}
