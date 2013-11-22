package org.inria.myriads.snoozeimages.volumeparser.api;

/**
 * 
 * Volume Parser API.
 * 
 * @author msimonin
 *
 */
public interface VolumeParser 
{
    
    /**
     * 
     * Gets the name from the description.
     * 
     * @param xmlDescription    the xml description.
     * @return  the name
     */
    String getName(String xmlDescription);
    
    /**
     * 
     * Gets the path.
     * 
     * @param xmlDescription    the xml description.
     * @return the path.
     */
    String getPath(String xmlDescription);
    
    
    /**
     * 
     * Gets the format.
     * 
     * @param xmlDescription    the xml description.
     * @return  the format
     */
    String getFormatType(String xmlDescription);
    
}
