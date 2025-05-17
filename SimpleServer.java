import java.io.*;
import java.net.*;

public class SimpleServer {
    public static void main(String[] args) {
        int port = 8080;
        System.out.println("hello world");
        System.out.println("hello world");
        System.out.println("hello world");
        System.out.println("hello world");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("HTTP Server running on http://localhost:" + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                // Read HTTP request (not used, but needed to clear the buffer)
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String line;
                while ((line = in.readLine()) != null && !line.isEmpty()) {
                    System.out.println("Request: " + line); // optional
                }

                // Write HTTP response
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/html");
                out.println(); // blank line between headers and content
                out.println("<html><body><h1>Hello World</h1></body></html>");
                out.flush();

                clientSocket.close();
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

