/**
 * Copyright (C) 2010-2013 Eugen Feller, INRIA <eugen.feller@inria.fr>
 *
 * This file is part of Snooze, a scalable, autonomic, and
 * energy-aware virtual machine (VM) management framework.
 *
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 */
package org.inria.myriads.snoozeimages;

import org.inria.myriads.images.exception.ImageServiceConfiguratorException;
import org.inria.myriads.snoozecommon.guard.Guard;
import org.inria.myriads.snoozecommon.util.ErrorUtils;
import org.inria.myriads.snoozecommon.util.LoggerUtils;
import org.inria.myriads.snoozeimages.application.ImageServiceApplication;
import org.inria.myriads.snoozeimages.backend.ImageServiceBackend;
import org.inria.myriads.snoozeimages.configurator.ImageServiceConfiguratorFactory;
import org.inria.myriads.snoozeimages.configurator.api.ImageServiceConfiguration;
import org.inria.myriads.snoozeimages.configurator.api.ImageServiceConfigurator;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Context;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.engine.Engine;
import org.restlet.engine.connector.HttpClientHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main snoozeimages class.
 * 
 * @author Matthieu Simonin
 */
public final class Main 
{    
    /** Define the logger. */
    private static final Logger log_ = LoggerFactory.getLogger(Main.class);
 
    /** Number of arguments. */
    private static final int NUMBER_OF_CMD_ARGUMENTS = 2;
    
    /** Hide constructor. */
    private Main()
    {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Main method.
     * 
     * @param args  The arguments
     */
    public static void main(String[] args) 
    {
        String configurationFile = null;
        String logFile = null;

        if (args.length == NUMBER_OF_CMD_ARGUMENTS) 
        {
            configurationFile = args[0];
            logFile = args[1];
        } else
        {
            System.out.println("Usage: java -jar snoozenode.jar configurationFile logFile");
            System.exit(1); 
        }
        
        LoggerUtils.configureLogger(logFile);      
        ImageServiceConfiguration imageServiceConfiguration = null;
        try 
        {
            ImageServiceConfigurator imageServiceConfigurator = 
                    ImageServiceConfiguratorFactory.newNodeConfigurator(configurationFile);
            imageServiceConfiguration = imageServiceConfigurator.getImageServiceConfiguration();
            startNode(imageServiceConfiguration);
           
        }
        catch (ImageServiceConfiguratorException exception) 
        {
            ErrorUtils.processError(String.format("Node configuration exception! Error during node " +
                                                  "configuration parsing: %s", exception.getMessage()));
        }
         
        catch (Exception exception)
        {
            log_.error("Exception", exception);
        } 
    }

    /**
     * Initializes the component.
     * 
     * @param component            The component
     * @param context              The context
     * @param configuration        The node parameters
     * @throws Exception 
     */
    private static void initializeRESTletComponent(Component component,
                                                   Context context,
                                                   ImageServiceConfiguration configuration) 
        throws Exception
    {
        Guard.check(component, context, configuration);
        log_.debug("Initializing the RESTlet component");
        
        Engine.getInstance().getRegisteredClients().clear();
        Engine.getInstance().getRegisteredClients().add(new HttpClientHelper(null)); 
        
        component.getClients().add(Protocol.HTTP);
        Server jettyServer = new Server(
                context,
                Protocol.HTTP, 
                configuration.getNetworkingSettings().getListen().getControlDataAddress().getPort(),
                component);
        
        component.getServers().add(jettyServer);
    }
    
    /** 
     * Main routine to start the node.
     *  
     * @param imageServiceConfiguration    The node configuration
     * @throws Exception 
     */
    private static void startNode(ImageServiceConfiguration imageServiceConfiguration) 
        throws Exception 
    {
        Guard.check(imageServiceConfiguration);
        log_.debug("Starting the node initialization");
                
        Component component = new Component();
        Context context = component.getContext().createChildContext();
        initializeRESTletComponent(component, context, imageServiceConfiguration);
        
        Application application = null;
       
        log_.debug("Starting the image service");
        application = new ImageServiceApplication(context);
        attachApplication(component, application);
        ImageServiceBackend backend = new ImageServiceBackend(imageServiceConfiguration);
        context.getAttributes().put("backend", backend);
       
    }

    /**
     * Attaches the application to RESTlet component.
     * 
     * @param component        The component
     * @param application      The application
     * @throws Exception       The exception
     */
    private static void attachApplication(Component component, Application application) 
        throws Exception
    {
        Guard.check(component, application);
        log_.debug("Attaching application to the RESTlet component");
        component.getDefaultHost().attach(application);
        component.start();
        log_.debug("RESTlet component started!");
    }
}
