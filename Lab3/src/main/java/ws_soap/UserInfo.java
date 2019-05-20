/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws_soap;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mantas
 */

@XmlRootElement
public class UserInfo {
    public String firstName;
    public String lastName;
    public String email;
}
