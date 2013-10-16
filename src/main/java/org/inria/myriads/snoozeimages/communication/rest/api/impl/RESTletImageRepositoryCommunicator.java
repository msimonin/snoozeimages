package org.inria.myriads.snoozeimages.communication.rest.api.impl;


import java.util.ArrayList;

import org.inria.myriads.snoozecommon.communication.NetworkAddress;
import org.inria.myriads.snoozeimages.communication.rest.api.ImageRepositoryAPI;
import org.inria.myriads.snoozeimages.virtualmachineimage.VirtualMachineImage;
import org.restlet.resource.ClientResource;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RESTletImageRepositoryCommunicator implements ImageRepositoryAPI
{
    /** Define the logger. */
    private static final Logger log_ = LoggerFactory.getLogger(RESTletImageRepositoryCommunicator.class);
    
    /** Address.*/
    private NetworkAddress address_;
    
    /**
     * Constructor.
     * 
     * @param groupManagerAddress  The  group manager address
     */
    public RESTletImageRepositoryCommunicator(NetworkAddress address) 
    {
        log_.debug("Initializing REST image repository communicator");
        address_ = address;
    }

    /**
     * Creates a client resource.
     * 
     * @return     The client resource
     */
    private ClientResource createClientResource()
    {
        log_.debug("Creating client resource");
        String address = address_.getAddress();
        String port = String.valueOf(address_.getPort());
        ClientResource clientResource = new ClientResource("http://" + address + ":" + port + "/images"); 
        return clientResource;
    }


    @Override
    public ArrayList<VirtualMachineImage> getImagesList()
    {
        log_.debug("Sending to the image repository a images list request");
        ClientResource clientResource = null;
        
        try 
        {
            clientResource = createClientResource();
            ImageRepositoryAPI imageRepository = clientResource.wrap(ImageRepositoryAPI.class); 
            ArrayList<VirtualMachineImage> images = imageRepository.getImagesList();
            return images;
        } 
        catch (Exception exception)
        {
            log_.debug("Errort while retrieving the image list");
        }
        finally
        {
            if (clientResource != null)
            {
                clientResource.release();
            }
        }
        return null;
    }

    @Override    
    public VirtualMachineImage getImage(String imageIdentifier)
    {
        log_.debug("Sending to the image repository a image detail request");
        ClientResource clientResource = null;
        
        try 
        {
            clientResource = createClientResource();
            ImageRepositoryAPI imageRepository = clientResource.wrap(ImageRepositoryAPI.class); 
            VirtualMachineImage image = imageRepository.getImage(imageIdentifier);
            return image;
        } 
        catch (Exception exception)
        {
            log_.debug("Error while retrieving the image list");
        }
        finally
        {
            if (clientResource != null)
            {
                clientResource.release();
            }
        }
        return null;
    }
}
