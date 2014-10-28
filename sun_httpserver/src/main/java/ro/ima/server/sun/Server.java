package ro.ima.server.sun;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class Server {
	public static void main(String[] args) {
		String host = System.getProperty("host", "0.0.0.0");
		String port = System.getProperty("port", "8081");
		
		InetSocketAddress socketAddress = new InetSocketAddress(host, Integer.parseInt(port));
		
		try {
			HttpServer server = HttpServer.create(socketAddress,0);
			server.createContext("/", new Handler());
//			server.setExecutor(Executors.newCachedThreadPool());
			server.start();
			System.out.println("started on port " + port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
