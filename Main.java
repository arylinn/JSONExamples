package com.Amber;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.util.*;

/**
 * Created by Amber on 4/28/2016.
 */

class Todo
{
    private String body;
    private boolean done;
    private int id;
    private int priority;
    private String title;

    public String toString()
    {
        return (title + " " + body + " " + id + " " + priority + " " + done);

    }
}

class todoCollection extends HashMap<String, Todo[]>
{

}

public class Main {
    public static void main (String[] args)
    {
        String jsonData = "{\n" +
                "  \"todos\": [\n" +
                "    {\n" +
                "      \"body\": \"Walk the dog\",\n" +
                "      \"done\": false,\n" +
                "      \"id\": 0,\n" +
                "      \"priority\": 3,\n" +
                "      \"title\": \"dog\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"body\": \"Pay the bills\",\n" +
                "      \"done\": false,\n" +
                "      \"id\": 1,\n" +
                "      \"priority\": 1,\n" +
                "      \"title\": \"bills\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Gson gson = new Gson();
        todoCollection todos = gson.fromJson(jsonData, todoCollection.class);

        for(String key: todos.keySet())
        {
            Todo[] todoArray = todos.get(key);
            for(Todo todoitem: todoArray)
            {
                System.out.println(todoitem);
            }
        }

        String reserialization = gson.toJson(todos);
        System.out.println(reserialization);

    }
}
