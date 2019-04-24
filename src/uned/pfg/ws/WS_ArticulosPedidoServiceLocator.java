/**
 * WS_ArticulosPedidoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uned.pfg.ws;

public class WS_ArticulosPedidoServiceLocator extends org.apache.axis.client.Service implements uned.pfg.ws.WS_ArticulosPedidoService {

    public WS_ArticulosPedidoServiceLocator() {
    }


    public WS_ArticulosPedidoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WS_ArticulosPedidoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WS_ArticulosPedido
    private java.lang.String WS_ArticulosPedido_address = "http://localhost:8080/Aplicacion_Web/services/WS_ArticulosPedido";

    public java.lang.String getWS_ArticulosPedidoAddress() {
        return WS_ArticulosPedido_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WS_ArticulosPedidoWSDDServiceName = "WS_ArticulosPedido";

    public java.lang.String getWS_ArticulosPedidoWSDDServiceName() {
        return WS_ArticulosPedidoWSDDServiceName;
    }

    public void setWS_ArticulosPedidoWSDDServiceName(java.lang.String name) {
        WS_ArticulosPedidoWSDDServiceName = name;
    }

    public uned.pfg.ws.WS_ArticulosPedido getWS_ArticulosPedido() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WS_ArticulosPedido_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWS_ArticulosPedido(endpoint);
    }

    public uned.pfg.ws.WS_ArticulosPedido getWS_ArticulosPedido(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            uned.pfg.ws.WS_ArticulosPedidoSoapBindingStub _stub = new uned.pfg.ws.WS_ArticulosPedidoSoapBindingStub(portAddress, this);
            _stub.setPortName(getWS_ArticulosPedidoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWS_ArticulosPedidoEndpointAddress(java.lang.String address) {
        WS_ArticulosPedido_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (uned.pfg.ws.WS_ArticulosPedido.class.isAssignableFrom(serviceEndpointInterface)) {
                uned.pfg.ws.WS_ArticulosPedidoSoapBindingStub _stub = new uned.pfg.ws.WS_ArticulosPedidoSoapBindingStub(new java.net.URL(WS_ArticulosPedido_address), this);
                _stub.setPortName(getWS_ArticulosPedidoWSDDServiceName());
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
        if ("WS_ArticulosPedido".equals(inputPortName)) {
            return getWS_ArticulosPedido();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.pfg.uned", "WS_ArticulosPedidoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.pfg.uned", "WS_ArticulosPedido"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WS_ArticulosPedido".equals(portName)) {
            setWS_ArticulosPedidoEndpointAddress(address);
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
