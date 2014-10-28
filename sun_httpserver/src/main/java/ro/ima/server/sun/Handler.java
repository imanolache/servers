package ro.ima.server.sun;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Handler implements HttpHandler {

	public void handle(HttpExchange t) throws IOException {
		Headers h = t.getResponseHeaders();
		h.set("Content-Type", "text/html;charset=utf-8");

		String response = "<h1>Hello World [Sun HTTP Server]</h1>" + System.currentTimeMillis();
		t.sendResponseHeaders(200, response.length());
		
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}

}
