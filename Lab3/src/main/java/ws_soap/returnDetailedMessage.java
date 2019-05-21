/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws_soap;

/**
 *
 * @author Mantas
 */
public class returnDetailedMessage {
    public String message;
    public UserWithInfo data;
    public returnDetailedMessage(){}
    public returnDetailedMessage(String msg){
        message = msg;
    }
}
