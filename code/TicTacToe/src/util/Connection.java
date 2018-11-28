
package util;

import ttt.james.server.TTTWebService;
import ttt.james.server.TTTWebService_Service;

//Used to connect to Web Service and reduce reused code

public class Connection {
    
    private static TTTWebService proxy;
    private static TTTWebService_Service link;
    
    public Connection() {
        link = new TTTWebService_Service();
        proxy = link.getTTTWebServicePort();
    }
    
    public TTTWebService getProxy() {
        return this.proxy;
    }
}
