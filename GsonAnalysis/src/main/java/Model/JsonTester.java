/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author Lasith
 */
public class JsonTester {

    public static void main(String[] args) {

        //received json string from the request
        String requestString = "{'requestId':'54564','requestDate':'2022-12-11','method':'searchUser','user':{'name':'lasith','age':'23'}}";

        //parse the json string into a JsonElement object
        JsonElement jsonElement = JsonParser.parseString(requestString);

        //get the json element as a json object
        JsonObject jsonObj = jsonElement.getAsJsonObject();

        //this object can be contverted back into json string
        System.out.println("Received Json object:"+jsonObj);

        //we can read json properties by name 
        JsonElement requestId = jsonObj.get("requestId");
        System.out.println("Received Request Id:"+requestId);

        //we can get an object inside object and map it to a class as well
        JsonElement user = jsonObj.get("user");
        Student student = new Gson().fromJson(user.toString(), Student.class);
        System.out.println("Received Student Name:"+student.getName());
        System.out.println("Received Student Age:"+student.getAge());

        //create an json object to send as response
        String responseString = "{'requestId':'54564','responseCode':0,'method':'searchUser','user':" + new Gson().toJson(student) + "}";
        System.out.println("Response String:"+responseString);
        
        //parse into json 
        JsonElement response = JsonParser.parseString(responseString);
        
        //create json object
        JsonObject responseObject = response.getAsJsonObject();
        
        //create json string to send
        String toBeSend = new Gson().toJson(responseObject);
        System.out.println("Response Json:"+toBeSend);

    }

}
