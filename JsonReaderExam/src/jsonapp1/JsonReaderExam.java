package jsonapp1;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class JsonReaderExam {

    public static void main(String[] args) throws Exception {

        JsonReaderExam http = new JsonReaderExam();
        String url = "http://localhost:8080/hello/helloworld";
        url = args[0];

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        con.setDoInput(true);
        con.setDoOutput(true);

        con.setRequestProperty("Accept", "application/json");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        StringBuilder response;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }

        System.out.println(response.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        Generic9 g9 = objectMapper.readValue(response.toString(), Generic9.class);
        System.out.println(g9.toString());
        printAdditionalProperties(g9.getAdditionalProperties());
        List<Document> documents = g9.getDocuments();
        long runningTotal = 0;
        for (Document d : documents) {
            printAdditionalProperties(d.getAdditionalProperties());
            long printNumbers = printNumbers(runningTotal, d.getNumbers());
            runningTotal += printNumbers;
        }
        System.out.println("finalRunningTotal: " + runningTotal);
    }

    public static void printAdditionalProperties(Map<String, Object> ap) {
        ap.keySet().forEach((key) -> {
//            Object get = ap.get(key);
//            System.out.println("key:" + key + " :value: " + get.toString());
            System.out.println("key:" + key);
        });
    }

    private static long printNumbers(long runningTotal, List<Long> numbers) {
        long itemTotal = 0;
        for (long i : numbers) {
            itemTotal += i;
            System.out.println(
                    "runningTotal:" + (runningTotal + itemTotal)
                    + ": itemTotal:" + itemTotal
                    + ": number: " + i);
        }
        return itemTotal;
    }
}
