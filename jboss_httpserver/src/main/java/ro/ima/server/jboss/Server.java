package ro.ima.server.jboss;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.jboss.com.sun.net.httpserver.HttpServer;
import org.jboss.sun.net.httpserver.HttpServerImpl;

public class Server {
	public static void main(String[] args) {
		String host = System.getProperty("host", "0.0.0.0");
		String port = System.getProperty("port", "8081");

		InetSocketAddress socketAddress = new InetSocketAddress(host,
				Integer.parseInt(port));

		try {
			HttpServer server = HttpServerImpl.create(socketAddress, 10);
			server.createContext("/", new Handler());
			// server.setExecutor(Executors.newCachedThreadPool());
			server.start();
			System.out.println("Lightweight HTTP Server by JBoss, started on port "	+ port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
