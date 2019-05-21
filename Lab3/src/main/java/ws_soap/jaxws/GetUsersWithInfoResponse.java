/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws_soap.jaxws;

import ws_soap.User;
import ws_soap.UserWithInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 *
 * @author Mantas
 */
@XmlRootElement(name = "getUsersWithInfoResponse", namespace = "http://ws_soap/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUsersWithInfoResponse", namespace = "http://ws_soap/")
public class GetUsersWithInfoResponse {
    @XmlElement(name = "return", namespace = "")
    private UserWithInfo[] _return;
    
    public UserWithInfo[] getReturn() {
        return this._return;
    }

    public void setReturn(UserWithInfo[] _return) {
        this._return = _return;
    }
}
