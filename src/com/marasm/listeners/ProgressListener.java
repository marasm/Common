/**
 * 
 */
package com.marasm.listeners;

import java.util.EventListener;

/**
 * @author mkorotkovas
 *
 */
public interface ProgressListener extends EventListener
{
  public void progressChanged(double inProgress);
}
