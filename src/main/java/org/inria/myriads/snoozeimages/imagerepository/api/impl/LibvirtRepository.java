package org.inria.myriads.snoozeimages.imagerepository.api.impl;

import java.util.ArrayList;

import org.inria.myriads.snoozeimages.configurator.repositorysettings.LibvirtSettings;
import org.inria.myriads.snoozeimages.imagerepository.api.ImageRepository;
import org.inria.myriads.snoozecommon.virtualmachineimage.VirtualMachineImage;
import org.inria.myriads.snoozecommon.virtualmachineimage.VirtualMachineImageList;
import org.inria.myriads.snoozeimages.volumeparser.api.impl.LibvirtVolumeParser;
import org.libvirt.Connect;
import org.libvirt.LibvirtException;
import org.libvirt.StoragePool;
import org.libvirt.StorageVol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Libvirt pool based repository.
 * 
 * @author msimonin
 *
 */
public class LibvirtRepository implements ImageRepository 
{
    
    /** Define the logger. */
    private static final Logger log_ = LoggerFactory.getLogger(LibvirtRepository.class);
    
    /** Libvirt connection. */
    private Connect connect_;

    /** The storage pool.*/
    private StoragePool storage_;

    private LibvirtVolumeParser volumeParser_; 
    
    /**
     * Constructor.
     * @param libvirtSettings 
     */
    public LibvirtRepository(LibvirtSettings libvirtSettings) 
    {
        log_.debug("Connection to the libvirt driver in progress");
        try
        {
        String connection = createConnection(libvirtSettings);   
        connect_ = new Connect(connection);
        String storagePool = libvirtSettings.getPool();
        log_.debug("Storage pool : " + storagePool);
        storage_ = connect_.storagePoolLookupByName(storagePool);
        storage_.refresh(0);
        volumeParser_ = new LibvirtVolumeParser();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        log_.debug("Connection to th libvirt driver established");
    }

    private String createConnection(LibvirtSettings libvirtSettings)
    {
        String hypervisor = libvirtSettings.getHypervisor();
        String transport = libvirtSettings.getTransport();
        String address = libvirtSettings.getAddress();
        String port = String.valueOf(libvirtSettings.getPort());
        String connection = hypervisor + "+" + transport + "://" + address + ":" + port + "/system";
        log_.debug("connection to" + connection);
        return connection;
    }

    @Override
    public VirtualMachineImageList getImagesList() 
    {        
        VirtualMachineImageList imageList = new VirtualMachineImageList();
        ArrayList<VirtualMachineImage> images = imageList.getImages();
        
        try
        {
            storage_.refresh(0);
            for (String volume : storage_.listVolumes())
            {
                try
                {
                    VirtualMachineImage image = toImage(storage_.storageVolLookupByName(volume));
                    images.add(image);
                }
                catch (LibvirtException exception)
                {
                    log_.error("Unable to retrieve image information from the storage pool");
                    log_.debug(exception.getMessage());
                    continue;
                }
            }
        }
        catch (LibvirtException exception)
        {
            log_.error("Unable to retrive the volume list from the storage pool");
            log_.debug(exception.getMessage());
        }
       return imageList;
       
    }

    
    /**
     * 
     * Fill image object.
     * 
     * @param volume            The volume
     * @return  the image
     * @throws LibvirtException libvirt exceotion.
     */
    private VirtualMachineImage toImage(StorageVol volume) throws LibvirtException
    {
        VirtualMachineImage image = new VirtualMachineImage();
        image.setName(volume.getName());
        image.setPath(volume.getPath());
        image.setFormat(volumeParser_.getFormatType(volume.getXMLDesc(0)));
        image.setAllocation(volume.getInfo().allocation);
        image.setCapacity(volume.getInfo().capacity);
        return image;
    }

    @Override
    public VirtualMachineImage getImage(String imageIdentifier) 
    {
        VirtualMachineImage image = null;
        try 
        {
            storage_.refresh(0);
            StorageVol volume = storage_.storageVolLookupByName(imageIdentifier);
            image = toImage(volume);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return image;
    }

}
