package org.inria.myriads.snoozeimages.application;

import org.inria.myriads.snoozeimages.resource.ImageResource;
import org.inria.myriads.snoozeimages.resource.ImagesResource;
import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 * 
 * Image service application.
 * 
 * @author msimonin
 *
 */
public class ImageServiceApplication extends Application 
{

    /**
     * 
     * Constructor.
     * 
     * @param context   the context.
     */
    public ImageServiceApplication(Context context) 
    {
        super(context);
    }
    
    /**
     * Creates the root restlet.
     * 
     * @return  The restlet router
     */
    public Restlet createInboundRoot() 
    {  
         Router router = new Router(getContext());  
         router.attach("/images", ImagesResource.class);
         router.attach("/images/{imageIdentifier}", ImageResource.class);
         return router;  
    }

}
