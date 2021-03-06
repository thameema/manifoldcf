/* $Id: RepositoryConnectorFactory.java 988245 2010-08-23 18:39:35Z kwright $ */

/**
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements. See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.apache.manifoldcf.crawler.interfaces;

import org.apache.manifoldcf.core.interfaces.*;
import org.apache.manifoldcf.agents.interfaces.*;
import org.apache.manifoldcf.crawler.system.Logging;
import org.apache.manifoldcf.crawler.system.ManifoldCF;

import java.util.*;
import java.io.*;
import java.lang.reflect.*;

/** This is the factory class for IRepositoryConnector objects.
*/
public class RepositoryConnectorFactory extends ConnectorFactory<IRepositoryConnector>
{
  public static final String _rcsid = "@(#)$Id: RepositoryConnectorFactory.java 988245 2010-08-23 18:39:35Z kwright $";

  // Static factory
  protected final static RepositoryConnectorFactory thisFactory = new RepositoryConnectorFactory();

  private RepositoryConnectorFactory()
  {
  }

  @Override
  protected boolean isInstalled(IThreadContext tc, String className)
    throws ManifoldCFException
  {
    IConnectorManager connMgr = ConnectorManagerFactory.make(tc);
    return connMgr.isInstalled(className);
  }

  /** Get the activities supported by this connector.
  *@param className is the class name.
  *@return the list of activities.
  */
  protected String[] getThisActivitiesList(IThreadContext threadContext, String className)
    throws ManifoldCFException
  {
    IRepositoryConnector connector = getThisConnector(threadContext, className);
    if (connector == null)
      return null;
    String[] values = connector.getActivitiesList();
    java.util.Arrays.sort(values);
    return values;
  }

  /** Get the link types logged by this connector.
  *@param className is the class name.
  *@return the list of link types, in sorted order.
  */
  protected String[] getThisRelationshipTypes(IThreadContext threadContext, String className)
    throws ManifoldCFException
  {
    IRepositoryConnector connector = getThisConnector(threadContext, className);
    if (connector == null)
      return null;
    String[] values = connector.getRelationshipTypes();
    java.util.Arrays.sort(values);
    return values;
  }

  /** Get the operating mode for a connector.
  *@param className is the class name.
  *@return the connector operating model, as specified in IRepositoryConnector.
  */
  protected int getThisConnectorModel(IThreadContext threadContext, String className)
    throws ManifoldCFException
  {
    IRepositoryConnector connector = getThisConnector(threadContext, className);
    if (connector == null)
      return -1;
    return connector.getConnectorModel();
  }

  /** Install connector.
  *@param className is the class name.
  */
  public static void install(IThreadContext threadContext, String className)
    throws ManifoldCFException
  {
    thisFactory.installThis(threadContext,className);
  }

  /** Uninstall connector.
  *@param className is the class name.
  */
  public static void deinstall(IThreadContext threadContext, String className)
    throws ManifoldCFException
  {
    thisFactory.deinstallThis(threadContext,className);
  }

  /** Get the activities supported by this connector.
  *@param className is the class name.
  *@return the list of activities.
  */
  public static String[] getActivitiesList(IThreadContext threadContext, String className)
    throws ManifoldCFException
  {
    return thisFactory.getThisActivitiesList(threadContext,className);
  }

  /** Get the link types logged by this connector.
  *@param className is the class name.
  *@return the list of link types, in sorted order.
  */
  public static String[] getRelationshipTypes(IThreadContext threadContext, String className)
    throws ManifoldCFException
  {
    return thisFactory.getThisRelationshipTypes(threadContext,className);
  }

  /** Get the operating mode for a connector.
  *@param className is the class name.
  *@return the connector operating model, as specified in IRepositoryConnector.
  */
  public static int getConnectorModel(IThreadContext threadContext, String className)
    throws ManifoldCFException
  {
    return thisFactory.getThisConnectorModel(threadContext,className);
  }

  /** Output the configuration header section.
  */
  public static void outputConfigurationHeader(IThreadContext threadContext, String className, IHTTPOutput out, Locale locale, ConfigParams parameters, ArrayList tabsArray)
    throws ManifoldCFException, IOException
  {
    thisFactory.outputThisConfigurationHeader(threadContext,className,out,locale,parameters,tabsArray);
  }

  /** Output the configuration body section.
  */
  public static void outputConfigurationBody(IThreadContext threadContext, String className, IHTTPOutput out, Locale locale, ConfigParams parameters, String tabName)
    throws ManifoldCFException, IOException
  {
    thisFactory.outputThisConfigurationBody(threadContext,className,out,locale,parameters,tabName);
  }

  /** Process configuration post data for a connector.
  */
  public static String processConfigurationPost(IThreadContext threadContext, String className, IPostParameters variableContext, Locale locale, ConfigParams configParams)
    throws ManifoldCFException
  {
    return thisFactory.processThisConfigurationPost(threadContext,className,variableContext,locale,configParams);
  }
  
  /** View connector configuration.
  */
  public static void viewConfiguration(IThreadContext threadContext, String className, IHTTPOutput out, Locale locale, ConfigParams configParams)
    throws ManifoldCFException, IOException
  {
    thisFactory.viewThisConfiguration(threadContext,className,out,locale,configParams);
  }

  /** Get a repository connector instance, without checking for installed connector.
  *@param className is the class name.
  *@return the instance.
  */
  public static IRepositoryConnector getConnectorNoCheck(String className)
    throws ManifoldCFException
  {
    return thisFactory.getThisConnectorNoCheck(className);
  }

}
