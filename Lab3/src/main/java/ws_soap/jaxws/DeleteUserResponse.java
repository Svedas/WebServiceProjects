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
/**
 *
 * @author Mantas
 */


@XmlRootElement(name = "deleteUserResponse", namespace = "http://ws_soap/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteUserResponse", namespace = "http://ws_soap/")
public class DeleteUserResponse {

    @XmlElement(name = "return", namespace = "")
    private returnMessage _return;


    public returnMessage getReturn() {
        return this._return;
    }

    public void setReturn(returnMessage _return) {
        this._return = _return;
    }

}

