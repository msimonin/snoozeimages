package org.inria.myriads.snoozeimages.volumeparser;


import org.inria.myriads.snoozeimages.configurator.repositorysettings.ImageRepositorySettings;
import org.inria.myriads.snoozeimages.volumeparser.api.VolumeParser;
import org.inria.myriads.snoozeimages.volumeparser.api.impl.LibvirtVolumeParser;

/**
 * 
 * Volume parser factory.
 * 
 * @author msimonin
 *
 */
public final class VolumeParserFactory 
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
     * @param settings  The image repository settings
     * @return  volume parser.
     * @throws Exception   
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
