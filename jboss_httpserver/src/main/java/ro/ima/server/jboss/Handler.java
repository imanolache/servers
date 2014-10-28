package ro.ima.server.jboss;

import java.io.IOException;
import java.io.OutputStream;

import org.jboss.com.sun.net.httpserver.Headers;
import org.jboss.com.sun.net.httpserver.HttpExchange;
import org.jboss.com.sun.net.httpserver.HttpHandler;

public class Handler implements HttpHandler{

	public void handle(HttpExchange t) throws IOException {
		Headers h = t.getResponseHeaders();
		h.set("Content-Type", "text/html;charset=utf-8");

		String response = "<h1>Hello World [Lightweight HTTP Server by JBoss]</h1>" + System.currentTimeMillis();
		t.sendResponseHeaders(200, response.length());
		
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}

}
