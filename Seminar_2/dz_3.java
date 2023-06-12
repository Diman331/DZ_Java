package Seminar_2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class dz_3 {

    public static void main(String[] args) {
        String jsonFilePath = "Seminar_2/file.json";

        try {
            String jsonString = readJsonFile(jsonFilePath);
            JSONArray jsonArray = new JSONArray(jsonString);
            parseJsonArray(jsonArray);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    private static String readJsonFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }

    private static void parseJsonArray(JSONArray jsonArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String surname = jsonObject.getString("фамилия");
            String grade = jsonObject.getString("оценка");
            String subject = jsonObject.getString("предмет");

            sb.append("Студент ")
                    .append(surname)
                    .append(" получил ")
                    .append(grade)
                    .append(" по предмету ")
                    .append(subject)
                    .append(".")
                    .append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }
}
