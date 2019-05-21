/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws_soap.jaxws;

import ws_soap.returnDetailedMessage;
import ws_soap.returnMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Mantas
 */

@XmlRootElement(name = "addUserResponse", namespace = "http://ws_soap/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addUserResponse", namespace = "http://ws_soap/")
public class AddUserResponse {

    @XmlElement(name = "return", namespace = "")
    private returnDetailedMessage _return;

    public returnDetailedMessage getReturn() {
        return this._return;
    }

    public void setReturn(returnDetailedMessage _return) {
        this._return = _return;
    }

}
