package org.inria.myriads.snoozeimages.volumeparser.api.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.inria.myriads.libvirt.volume.LibvirtConfigVolume;
import org.inria.myriads.snoozeimages.imagerepository.api.impl.LibvirtRepository;
import org.inria.myriads.snoozeimages.volumeparser.api.VolumeParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LibvirtVolumeParser implements VolumeParser 
{
    /** Define the logger. */
    private static final Logger log_ = LoggerFactory.getLogger(LibvirtVolumeParser.class);
    
    /** Context. */
    private JAXBContext context_;

    /** Unmarshaller. */
    private Unmarshaller unmarshaller_;

    /**
     * Constructor. 
     * @throws JAXBException 
     */
    public LibvirtVolumeParser() throws JAXBException
    {
        context_ = JAXBContext.newInstance(LibvirtConfigVolume.class);
        unmarshaller_ = context_.createUnmarshaller();
    }
    @Override
    public String getName(String xmlDescription) 
    {
        InputStream input = new ByteArrayInputStream(xmlDescription.getBytes());
        try 
        {
            LibvirtConfigVolume volume = (LibvirtConfigVolume) unmarshaller_.unmarshal(input);
            return volume.getName();
        } 
        catch (JAXBException e) 
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getPath(String xmlDescription) 
    {
        InputStream input = new ByteArrayInputStream(xmlDescription.getBytes());
        try 
        {
            LibvirtConfigVolume volume = (LibvirtConfigVolume) unmarshaller_.unmarshal(input);
            return volume.getTarget().getPath();
        } 
        catch (JAXBException e) 
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getFormatType(String xmlDescription) 
    {
        InputStream input = new ByteArrayInputStream(xmlDescription.getBytes());
        try 
        {
            LibvirtConfigVolume volume = (LibvirtConfigVolume) unmarshaller_.unmarshal(input);
            return volume.getTarget().getFormatType();
        } 
        catch (JAXBException e) 
        {
            e.printStackTrace();
            return null;
        }
    }

}
