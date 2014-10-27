package ro.ima.server.grizzly;

import java.io.IOException;

import org.glassfish.grizzly.http.server.HttpServer;

public class GrizzlyServer {

	public static void main(String[] args) throws IOException, InterruptedException {

		String host = System.getProperty("host", "0.0.0.0");
		String port = System.getProperty("port", "8081");
		
		HttpServer server = HttpServer.createSimpleServer(".", host, Integer.parseInt(port));
		server.getServerConfiguration().addHttpHandler(new GrizzlyHandler());
		server.start();
		//Press CTRL^C to exit
		Thread.currentThread().join();
	}
}
