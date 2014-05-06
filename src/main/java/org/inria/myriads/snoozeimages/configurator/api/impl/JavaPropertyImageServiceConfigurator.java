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
package org.inria.myriads.snoozeimages.configurator.api.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import org.inria.myriads.images.exception.ImageServiceConfiguratorException;
import org.inria.myriads.snoozecommon.communication.NetworkAddress;
import org.inria.myriads.snoozecommon.guard.Guard;
import org.inria.myriads.snoozecommon.util.NetworkUtils;
import org.inria.myriads.snoozeimages.configurator.api.ImageServiceConfiguration;
import org.inria.myriads.snoozeimages.configurator.api.ImageServiceConfigurator;
import org.inria.myriads.snoozeimages.configurator.networking.NetworkingSettings;
import org.inria.myriads.snoozeimages.configurator.repositorysettings.ImageRepositorySettings;
import org.inria.myriads.snoozeimages.imagerepository.ImageRepositoryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Node configurator.
 * 
 * @author Matthieu Simonin
 */
public final class JavaPropertyImageServiceConfigurator 
    implements ImageServiceConfigurator
{
    
    /** Define the logger. */
    private static final Logger log_ = LoggerFactory.getLogger(JavaPropertyImageServiceConfigurator.class);
    
    /** NodeParams. */
    private ImageServiceConfiguration imageServiceConfiguration_;
        
    /** Properties. */
    private Properties properties_;
    
    /**
     * Initialize parameters.
     *  
     * @param configurationFile             The configuration file
     * @throws ImageServiceConfiguratorException  exception 
     * @throws IOException exception
     */
    public JavaPropertyImageServiceConfigurator(String configurationFile) 
        throws ImageServiceConfiguratorException, IOException
    {
        Guard.check(configurationFile);
        imageServiceConfiguration_ = new ImageServiceConfiguration();
          
        properties_ = new Properties();    
        FileInputStream fileInput = new FileInputStream(configurationFile);
        properties_.load(fileInput); 
        
        setNetworkingSettings();
        setImageServiceSettings();
        
        fileInput.close();
    }



    @Override
    public ImageServiceConfiguration getImageServiceConfiguration() 
    {
        return imageServiceConfiguration_;
    }
    
    /**
     * Set the network settings.
     * 
     * @throws ImageServiceConfiguratorException    The configuration exception
     * @throws UnknownHostException         The unknown host exception
     */
    private void setNetworkingSettings() 
        throws ImageServiceConfiguratorException, UnknownHostException 
    {
        NetworkingSettings networkingSettings = imageServiceConfiguration_.getNetworkingSettings();
        String listenAddress = properties_.getProperty("network.listen.address");
        if (listenAddress != null)
        {
            listenAddress = listenAddress.trim();
        } else
        {
            listenAddress = InetAddress.getLocalHost().getHostAddress();
        }
          
        int controlDataPort = Integer.valueOf(getProperty("network.listen.controlDataPort"));  
        NetworkAddress controlDataAddress = 
                NetworkUtils.createNetworkAddress(listenAddress, controlDataPort);
        networkingSettings.getListen().setControlDataAddress(controlDataAddress);
        
    }

    
    /**
     * 
     * Sets the image service settings.
     * 
     * @throws ImageServiceConfiguratorException    The configuration exception
     * @throws UnknownHostException                 The unknown host exception
     */
    private void setImageServiceSettings() 
            throws ImageServiceConfiguratorException, UnknownHostException 
    {
        ImageRepositorySettings imageServiceSettings = imageServiceConfiguration_.getImageRepositorySettings();
        String type = properties_.getProperty("repository.type");
        imageServiceSettings.setType(ImageRepositoryType.valueOf(type));
        
        String libvirtPort = properties_.getProperty("repository.libvirt.port");
        imageServiceSettings.getLibvirtSettings().setPort(Integer.valueOf(libvirtPort));
        String libvirtAddress = properties_.getProperty("repository.libvirt.address");
        imageServiceSettings.getLibvirtSettings().setAddress(libvirtAddress);
        String libvirtHypervisor = properties_.getProperty("repository.libvirt.hypervisor");
        imageServiceSettings.getLibvirtSettings().setHypervisor(libvirtHypervisor);
        String libvirtTransport = properties_.getProperty("repository.libvirt.transport");
        imageServiceSettings.getLibvirtSettings().setTransport(libvirtTransport);
        String libvirtPool = properties_.getProperty("repository.libvirt.pool");
        imageServiceSettings.getLibvirtSettings().setPool(libvirtPool);
        
    }
    
    /**
     * Returns the content of a properties.
     * 
     * @param tag                           The tag
     * @return                              The content string
     * @throws ImageServiceConfiguratorException    The configuration exception
     */
    private String getProperty(String tag) 
        throws ImageServiceConfiguratorException
    {
        String content = properties_.getProperty(tag);
        if (content == null) 
        {
            throw new ImageServiceConfiguratorException(String.format("%s entry is missing", tag));
        }
        
        content = content.trim();
        return content;             
    }

}
