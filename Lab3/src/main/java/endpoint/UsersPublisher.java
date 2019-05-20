/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endpoint;

import javax.xml.ws.Endpoint;
import ws_soap.UsersImpl;

/**
 *
 * @author Mantas
 */
public class UsersPublisher {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Endpoint.publish("http://0.0.0.0:5005/users", new UsersImpl());
    }
}
