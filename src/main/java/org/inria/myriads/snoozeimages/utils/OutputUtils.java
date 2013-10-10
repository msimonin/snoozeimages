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
package org.inria.myriads.snoozeimages.utils;

import org.inria.myriads.snoozecommon.guard.Guard;
import org.inria.myriads.snoozeimages.configurator.api.ImageServiceConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Output utility.
 * 
 * @author Matthieu Simonin
 */
public final class OutputUtils 
{
    /** Define the logger. */
    private static final Logger log_ = LoggerFactory.getLogger(OutputUtils.class);
    
    /**
     * Hide the consturctor.
     */
    private OutputUtils() 
    {
        throw new UnsupportedOperationException();
    }

  
    
    /**
     * Display node parameterss.
     * 
     * @param configuration     The node configuration
     */
    public static void printNodeConfiguration(ImageServiceConfiguration configuration)
    {
        Guard.check(configuration);
        
        log_.debug("------------------ System configuration -------------");
        log_.debug("Node settings:");
        log_.debug("-----------------");
        log_.debug(String.format("listen address : %s", 
                configuration.getNetworkingSettings().getListen().getControlDataAddress().getAddress()));
        log_.debug(String.format("listen port : %s", 
                configuration.getNetworkingSettings().getListen().getControlDataAddress().getPort()));
        log_.debug("--------------------------------------");
        
    }   

}
