package org.inria.myriads.snoozeimages.configurator.repositorysettings;

/**
 * 
 * Libvirt settings.
 * 
 * @author msimonin
 *
 */
public class LibvirtSettings 
{
    /** address.*/
    private String address_;
    
    /** port. */
    private int port_;
    
    /** hypervisor.*/
    private String hypervisor_;
    
    /** transport.*/
    private String transport_;
    
    /** pool. */
    private String pool_;
    
    

    /**
     * Empty constructor. 
     */
    public LibvirtSettings() 
    {
    }

    /**
     * @return the port
     */
    public int getPort() 
    {
        return port_;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) 
    {
        port_ = port;
    }

    /**
     * @return the address
     */
    public String getAddress()
    {
        return address_;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address)
    {
        address_ = address;
    }

    /**
     * @return the hypervisor
     */
    public String getHypervisor()
    {
        return hypervisor_;
    }

    /**
     * @param hypervisor the hypervisor to set
     */
    public void setHypervisor(String hypervisor)
    {
        hypervisor_ = hypervisor;
    }

    /**
     * @return the transport
     */
    public String getTransport()
    {
        return transport_;
    }

    /**
     * @param transport the transport to set
     */
    public void setTransport(String transport)
    {
        transport_ = transport;
    }

    /**
     * @return the pool
     */
    public String getPool()
    {
        return pool_;
    }

    /**
     * @param pool the pool to set
     */
    public void setPool(String pool)
    {
        pool_ = pool;
    }
    
    
}
