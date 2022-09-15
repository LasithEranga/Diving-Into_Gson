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


        String jsonString
                = "{'name':'Lasith Eranda', 'age':23,'verified':true,'marks': [100,90,85]}";

        //create tree from JSON 
        JsonElement rootNode = JsonParser.parseString(jsonString);
        
        JsonObject details = rootNode.getAsJsonObject();
        JsonElement nameNode = details.get("name");
        System.out.println("Name: " + nameNode.getAsString());
        JsonElement ageNode = details.get("age");
        System.out.println("Age: " + ageNode.getAsInt());
    }

}
