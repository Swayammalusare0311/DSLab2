import com.sun.net.httpserver.*;
import java.io.*;
import java.net.*;

public class Assignment8 {

    public static void main(String[] args)
            throws Exception {

        // Create HTTP server
        HttpServer server =
                HttpServer.create(
                        new InetSocketAddress(8000),
                        0
                );

        // ADD service
        server.createContext("/add", (exchange) -> {

            String query =
                    exchange.getRequestURI()
                            .getQuery();

            String[] params =
                    query.split("&");

            int a = Integer.parseInt(
                    params[0].split("=")[1]);

            int b = Integer.parseInt(
                    params[1].split("=")[1]);

            int result = a + b;

            String response =
                    "Result = " + result;

            exchange.sendResponseHeaders(
                    200,
                    response.length()
            );

            OutputStream os =
                    exchange.getResponseBody();

            os.write(response.getBytes());

            os.close();
            //http://localhost:8000/add?a=10&b=20
        });

        // SUBTRACTION service
        server.createContext("/sub", (exchange) -> {

            String query =
                    exchange.getRequestURI()
                            .getQuery();

            String[] params =
                    query.split("&");

            int a = Integer.parseInt(
                    params[0].split("=")[1]);

            int b = Integer.parseInt(
                    params[1].split("=")[1]);

            int result = a - b;

            String response =
                    "Result = " + result;

            exchange.sendResponseHeaders(
                    200,
                    response.length()
            );

            OutputStream os =
                    exchange.getResponseBody();

            os.write(response.getBytes());

            os.close();
           // http://localhost:8000/sub?a=50&b=20
        });

        // Start server
        server.start();

        System.out.println(
                "Server running at http://localhost:8000");
    }
}