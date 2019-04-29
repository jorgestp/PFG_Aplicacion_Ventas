/**
 * WS_NuevoArticuloServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uned.pfg.ws;

public class WS_NuevoArticuloServiceLocator extends org.apache.axis.client.Service implements uned.pfg.ws.WS_NuevoArticuloService {

    public WS_NuevoArticuloServiceLocator() {
    }


    public WS_NuevoArticuloServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WS_NuevoArticuloServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WS_NuevoArticulo
    private java.lang.String WS_NuevoArticulo_address = "http://localhost:8080/Aplicacion_Web/services/WS_NuevoArticulo";

    public java.lang.String getWS_NuevoArticuloAddress() {
        return WS_NuevoArticulo_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WS_NuevoArticuloWSDDServiceName = "WS_NuevoArticulo";

    public java.lang.String getWS_NuevoArticuloWSDDServiceName() {
        return WS_NuevoArticuloWSDDServiceName;
    }

    public void setWS_NuevoArticuloWSDDServiceName(java.lang.String name) {
        WS_NuevoArticuloWSDDServiceName = name;
    }

    public uned.pfg.ws.WS_NuevoArticulo getWS_NuevoArticulo() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WS_NuevoArticulo_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWS_NuevoArticulo(endpoint);
    }

    public uned.pfg.ws.WS_NuevoArticulo getWS_NuevoArticulo(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            uned.pfg.ws.WS_NuevoArticuloSoapBindingStub _stub = new uned.pfg.ws.WS_NuevoArticuloSoapBindingStub(portAddress, this);
            _stub.setPortName(getWS_NuevoArticuloWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWS_NuevoArticuloEndpointAddress(java.lang.String address) {
        WS_NuevoArticulo_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (uned.pfg.ws.WS_NuevoArticulo.class.isAssignableFrom(serviceEndpointInterface)) {
                uned.pfg.ws.WS_NuevoArticuloSoapBindingStub _stub = new uned.pfg.ws.WS_NuevoArticuloSoapBindingStub(new java.net.URL(WS_NuevoArticulo_address), this);
                _stub.setPortName(getWS_NuevoArticuloWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WS_NuevoArticulo".equals(inputPortName)) {
            return getWS_NuevoArticulo();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.pfg.uned", "WS_NuevoArticuloService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.pfg.uned", "WS_NuevoArticulo"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WS_NuevoArticulo".equals(portName)) {
            setWS_NuevoArticuloEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
