package db;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class TestDB {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://chery.websoft.ru/default?mode=default&auth_err=1"); // URL адрес сервера
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST"); // Задаем метод запроса post
        con.setDoOutput(true); // Разрешаем отправку тела запроса

        // Данные для отправки
        String formParameters = "param1=i.g.bokov&param2=asdf54321";

        try (OutputStream outputStream = con.getOutputStream()) {
            byte[] input = formParameters.getBytes("utf-8");
            outputStream.write(input, 0, input.length);
        }

        // Получение и обработка ответа от сервера
        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response);
        }
    }
}