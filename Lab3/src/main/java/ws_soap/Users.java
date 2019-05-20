/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws_soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

/**
 *
 * @author Mantas
 */
//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL, parameterStyle= SOAPBinding.ParameterStyle.WRAPPED)

public interface Users {
    @WebMethod User[] getUsers();
    
    @WebMethod returnMessage addUser( @WebParam(name="email") String email,
					@WebParam(name="role") String role,
					@WebParam(name="accessLevel") String accessLevel);
    
    @WebMethod User getUser( @WebParam(name="email") String email);
    
    @WebMethod returnMessage putUser( @WebParam(name="email") String email,
					@WebParam(name="role") String role,
					@WebParam(name="accessLevel") String accessLevel);

    @WebMethod returnMessage deleteUser( @WebParam(name="email") String email);
}