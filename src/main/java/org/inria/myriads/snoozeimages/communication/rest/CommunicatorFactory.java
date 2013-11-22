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
import org.inria.myriads.snoozeimages.communication.rest.api.ImagesRepositoryAPI;
import org.inria.myriads.snoozeimages.communication.rest.api.impl.RESTletImageRepositoryCommunicator;
import org.inria.myriads.snoozeimages.communication.rest.api.impl.RESTletImagesRepositoryCommunicator;


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
     * Creates a new images communicator instance.
     * 
     * @param address   The images repository address
     * @return          The images repository communicator instance.
     */
    public static ImagesRepositoryAPI newImagesRepositoryCommunicator(NetworkAddress address) 
    {
        return new RESTletImagesRepositoryCommunicator(address);
    }
    
    /**
     * Creates a new image communicator instance.
     * 
     * @param address           The image repository address.
     * @param imageIdentifier   The image identifier.
     * @return  The image communicator instance.                  
     */
    public static ImageRepositoryAPI newImageRepositoryCommunicator(NetworkAddress address, String imageIdentifier) 
    {
        return new RESTletImageRepositoryCommunicator(address, imageIdentifier);
    }
 
}
