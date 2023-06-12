package Seminar_2;

import org.json.JSONObject;

public class dz_1 {

    public static void main(String[] args) {
        String inputStr = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        JSONObject jsonObject = new JSONObject(inputStr);
        StringBuilder whereClause = new StringBuilder();

        for (String key : jsonObject.keySet()) {
            String value = jsonObject.getString(key);
            if (!value.equalsIgnoreCase("null")) {
                if (whereClause.length() > 0) {
                    whereClause.append(" AND ");
                }
                whereClause.append(key).append("=").append(value);
            }
        }

        String sqlQuery = "select * from students WHERE " + whereClause.toString();
        System.out.println(sqlQuery);
    }
}
