/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws_soap.jaxws;

import ws_soap.User;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Mantas
 */
@XmlRootElement(name = "getUsersResponse", namespace = "http://ws_soap/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUsersResponse", namespace = "http://ws_soap/")
public class GetUsersResponse {
    @XmlElement(name = "return", namespace = "")
    private User[] _return;
    public User[] getReturn() {
        return this._return;
    }
}