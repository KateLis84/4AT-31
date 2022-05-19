package day_5;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import day_4.task2Reflection.newClass;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class serialization {

    public static void main(String[] args) {

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("field1","value1");
        System.out.println(jsonObject);

        ObjectMapper objectMapper = new ObjectMapper();
        newClass object=
                null;
        try {
            object = objectMapper.readValue(jsonObject.toString(), newClass.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(object);
        object.setField3(666);
        JSONObject jsonObject2=new JSONObject(object);
        System.out.println(jsonObject2);

        File file = new File("tmp.json");

        try {
            FileWriter fileWriter=new FileWriter(file);
            fileWriter.write(jsonObject2.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String content = Files.readString(Path.of(file.getAbsolutePath()));
            System.out.println(new JSONObject(content));
        } catch (IOException e) {
            e.printStackTrace();
        }


        jsonObject2.put("arrayField",new JSONArray());
        jsonObject2.getJSONArray("arrayField")
                .put(new JSONObject("{\"field666\":\"666\"}"));

        System.out.println(jsonObject2);


        Map<String,Object> jsonMap=jsonObject2.toMap();
        System.out.println(jsonMap);

        jsonMap.put("mapField","mapField");
        System.out.println(new JSONObject(jsonMap));
    }
}