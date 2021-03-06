/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws_soap;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Mantas
 */
public class JSONConverter {
    public static String getJsonStringFromConnection(HttpURLConnection conn ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String output = "";
        String temp;
        while ((temp = br.readLine()) != null) {
            output+=temp;
        }
        br.close();
        return output;
    }
    
    public static User[] jsonToUsers(String jsonInString){
        ObjectMapper mapper = new ObjectMapper();
        User[] users = null;
//        System.out.println("JSON: \n" + jsonInString);
        
        int start = jsonInString.indexOf("[");
        jsonInString = jsonInString.substring(start, jsonInString.length());
        
        try {
            users = mapper.readValue(jsonInString, User[].class);
        } catch (IOException ex) {
            Logger.getLogger(JSONConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    public static UserWithInfo[] jsonToUsersWithInfo(String jsonInString){
        ObjectMapper mapper = new ObjectMapper();
        UserWithInfo[] users = null;
        
        int start = jsonInString.indexOf("\"data\":") + 7;
        jsonInString = jsonInString.substring(start, jsonInString.length());
        try {
            users = mapper.readValue(jsonInString, UserWithInfo[].class);

        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("Collected " + users.length + " users.");
        return users;

    }
    
    public static User jsonToUser(String jsonInString, String email){
        ObjectMapper mapper = new ObjectMapper();
        User user = null;
        try {
            user = mapper.readValue(jsonInString, User.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        user.email = email;
        return user;
    }
    
    public static UserWithInfo jsonToUserWithInfo(String jsonInString, String email){
        ObjectMapper mapper = new ObjectMapper();
        UserWithInfo user = null;
        
        int start = jsonInString.indexOf("\"data\":") + 7;
        jsonInString = jsonInString.substring(start, jsonInString.length());
        
        try {
            user = mapper.readValue(jsonInString, UserWithInfo.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        user.email = email;
        return user;
    }
    
    public static returnMessage jsonToReturnMsg(String jsonInString){
        ObjectMapper mapper = new ObjectMapper();
        returnMessage val = null;
        try {
            val = mapper.readValue(jsonInString, returnMessage.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return val;
    }
    public static returnDetailedMessage jsonToReturnDetailedMsg(String jsonInString){
        ObjectMapper mapper = new ObjectMapper();
        returnDetailedMessage val = null;
        
//        System.out.println("JSON: \n" + jsonInString);

        try {
            val = mapper.readValue(jsonInString, returnDetailedMessage.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return val;
    }
}