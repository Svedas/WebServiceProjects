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
public class User {
    public String email;
    public String role;
    public String accessLevel;
    public UserInfo userInfo;
}
