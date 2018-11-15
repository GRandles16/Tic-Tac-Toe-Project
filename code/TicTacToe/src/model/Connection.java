/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import ttt.james.server.TTTWebService;
import ttt.james.server.TTTWebService_Service;

/**
 *
 * @author gtara
 */
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
