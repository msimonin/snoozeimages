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
package org.inria.myriads.snoozeimages.communication.rest;

import org.inria.myriads.snoozecommon.communication.NetworkAddress;
import org.inria.myriads.snoozeimages.communication.rest.api.ImageRepositoryAPI;
import org.inria.myriads.snoozeimages.communication.rest.api.impl.RESTletImageRepositoryCommunicator;


/**
 * Component communicator factory.
 * 
 * @author Eugen Feller
 */
public final class CommunicatorFactory 
{
    /** Hide constructor. */
    private CommunicatorFactory()
    {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Creates a new bootstrap communicator instance.
     * 
     * @param bootstrapAddress     The bootstrap address
     * @return                     The bootstrap communicator instance
     */
    public static ImageRepositoryAPI newImageRepositoryCommunicator(NetworkAddress address) 
    {
        return new RESTletImageRepositoryCommunicator(address);
    }
 
}
