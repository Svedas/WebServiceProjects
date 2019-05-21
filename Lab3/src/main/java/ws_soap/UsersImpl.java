/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws_soap;

import javax.jws.WebService;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/**
 *
 * @author Mantas
 */
@WebService(endpointInterface = "ws_soap.Users")
public class UsersImpl implements Users{

    @Override
    public User[] getUsers() {
        User[] users = null;
        try {
            URL url = new URL("http://web:5001/users");
//            URL url = new URL("http://0.0.0.0:5001/users");
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            String jsonString = JSONConverter.getJsonStringFromConnection(conn);
            users = JSONConverter.jsonToUsers(jsonString);
            conn.disconnect();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    } 
    
    @Override
    public UserWithInfo[] getUsersWithInfo() {
        UserWithInfo[] users = null;
        try {
            URL url = new URL("http://web:5001/users?embedded=users");
//            URL url = new URL("http://0.0.0.0:5001/users");
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            String jsonString = JSONConverter.getJsonStringFromConnection(conn);
            users = JSONConverter.jsonToUsersWithInfo(jsonString);
            conn.disconnect();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    } 

    @Override
    public returnDetailedMessage addUser(String email, String role, String accessLevel) {
        returnDetailedMessage returnval = null;
        try {
            String jsonPutString = "{";
            if (email != null)
                jsonPutString+= "\"email\": \"" + email + "\",";

            if (role != null)
                jsonPutString += "\"role\": \"" + role + "\",";
            
            if (accessLevel != null)
                jsonPutString += "\"accessLevel\": \"" + accessLevel + "\",";

            if(jsonPutString.endsWith(","))
            {
                jsonPutString = jsonPutString.substring(0,jsonPutString.length() - 1);
            }
            jsonPutString += "}";
            URL url = new URL("http://web:5001/users");
//            URL url = new URL("http://0.0.0.0:5001/users");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json");
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(jsonPutString);
            out.close();
            conn.getInputStream(); // questionable
            System.out.println(jsonPutString);
//            conn.getInputStream();
            String jsonString = JSONConverter.getJsonStringFromConnection(conn);

            returnval = JSONConverter.jsonToReturnDetailedMsg(jsonString);
            if (conn.getResponseCode() > 300) {
                throw new RuntimeException("Failed : HTTP error code from REST service was returned: "
                        + conn.getResponseCode());
            }
            conn.disconnect();
        } catch (ProtocolException e) {
            e.printStackTrace();
            returnval = new returnDetailedMessage();
            returnval.message = "error";
        } catch (IOException e) {
            e.printStackTrace();
            returnval = new returnDetailedMessage();
            returnval.message = "bad input";
        }
        return returnval;
    }

    @Override
    public UserWithInfo getUser(String email) {
        UserWithInfo user = null;
        if (email == null) {
            throw new RuntimeException("no user email specified");
        }
//        System.out.println(email);
        try {
            URL url = new URL("http://web:5001/users/" + email);
//            URL url = new URL("http://0.0.0.0:5001/users" + email);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() > 300) {
                throw new RuntimeException("Failed : HTTP error code from REST service was returned: "
                        + conn.getResponseCode());
            }
            String jsonString = JSONConverter.getJsonStringFromConnection(conn);
            user = JSONConverter.jsonToUserWithInfo(jsonString, email);
            conn.disconnect();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public returnDetailedMessage putUser(String email, String role, String accessLevel) {
        returnDetailedMessage returnval = null;
        if (email == null) {
            throw new RuntimeException("no user email specified");
        }
        try {
            String jsonPutString = "{";
            if (email != null)
                jsonPutString+= " \"email\" : \"" + email + "\",";

            if (role != null)
                jsonPutString += "\"role\" : \"" + role + "\",";
            
            if (accessLevel != null)
                jsonPutString += "\"accessLevel\" : \"" + accessLevel + "\",";


            if(jsonPutString.endsWith(","))
            {
                jsonPutString = jsonPutString.substring(0,jsonPutString.length() - 1);
            }
            jsonPutString += "}";
            URL url = new URL("http://web:5001/users/" + email);
//            URL url = new URL("http://0.0.0.0:5001/users" + email);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json");
            OutputStreamWriter out = new OutputStreamWriter(
                    conn.getOutputStream());
            out.write(jsonPutString);
            out.close();
            conn.getInputStream();
            String jsonString = JSONConverter.getJsonStringFromConnection(conn);
            returnval = JSONConverter.jsonToReturnDetailedMsg(jsonString);
            if (conn.getResponseCode() > 300) {
                throw new RuntimeException("Failed : HTTP error code from REST service was returned: "
                        + conn.getResponseCode());
            }
            conn.disconnect();
        } catch (ProtocolException e) {
            e.printStackTrace();
            returnval = new returnDetailedMessage();
            returnval.message = "error";
        } catch (IOException e) {
            e.printStackTrace();
            returnval = new returnDetailedMessage();
            returnval.message = "bad input";
        }
        return returnval;
    }


    @Override
    public returnMessage deleteUser(String email) {
        returnMessage returnval = null;
        HttpURLConnection conn = null;
        if (email == null) {
            throw new RuntimeException("no user email specified");
        }
        try {

            URL url = new URL("http://web:5001/users/" + email);
//            URL url = new URL("http://0.0.0.0:5001/users" + email);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Accept", "application/x-www-form-urlencoded");
            conn.connect();
            String jsonString = JSONConverter.getJsonStringFromConnection(conn);
            //returnval = JSONConverter.jsonToReturnMsg(jsonString);
            if (conn.getResponseCode() == 204) {
                return new returnMessage("Successfully deleted user with email: " + email);
            }
            if (conn.getResponseCode() > 300) {
                throw new RuntimeException("Failed : HTTP error code from REST service was returned: "
                        + conn.getResponseCode());
            }
            conn.disconnect();
        } catch (ProtocolException e) {
            throw new RuntimeException("bad input");
        } catch (IOException e) {
            throw new RuntimeException("bad input");
        }
        return returnval;
    }   
}
