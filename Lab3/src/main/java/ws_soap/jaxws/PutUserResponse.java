/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws_soap.jaxws;

import ws_soap.returnMessage;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ws_soap.returnDetailedMessage;

/**
 *
 * @author Mantas
 */
@XmlRootElement(name = "putUserResponse", namespace = "http://ws_soap/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "putUserResponse", namespace = "http://ws_soap/")
public class PutUserResponse {

    @XmlElement(name = "return", namespace = "")
    private returnDetailedMessage _return;

    public returnDetailedMessage getReturn() {
        return this._return;
    }

    public void setReturn(returnDetailedMessage _return) {
        this._return = _return;
    }

}

