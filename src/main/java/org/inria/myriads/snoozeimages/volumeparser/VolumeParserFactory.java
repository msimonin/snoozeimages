package org.inria.myriads.snoozeimages.volumeparser;

import javax.xml.bind.JAXBException;

import org.inria.myriads.snoozeimages.configurator.repositorysettings.ImageRepositorySettings;
import org.inria.myriads.snoozeimages.volumeparser.api.VolumeParser;
import org.inria.myriads.snoozeimages.volumeparser.api.impl.LibvirtVolumeParser;

public class VolumeParserFactory 
{
    /**
     * Hide Constructor.
     */
    private VolumeParserFactory() 
    {
       throw new UnsupportedOperationException();
    }
    
    
    /**
     * 
     * Creates a new Image Repository.
     * 
     * @param settings  The settings
     * @return  the image repository
     * @throws JAXBException 
     */
    public VolumeParser newVolumeParser(ImageRepositorySettings settings) throws Exception
    {
        try
        {
            return new LibvirtVolumeParser();
        }
        catch (Exception e)
        {
            throw new Exception("Unable to initialized the volume parser.");
        }
    }
}
