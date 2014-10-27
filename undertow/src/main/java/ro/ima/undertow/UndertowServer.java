package ro.ima.undertow;

import io.undertow.Undertow;

public class UndertowServer {
	public static void main(final String[] args) {
		String hostIp = System.getProperty("host", "0.0.0.0");
		String port = System.getProperty("port", "8081");

		Undertow server = Undertow.builder()
				.addHttpListener(Integer.parseInt(port), hostIp)
				.setHandler(new UndertowHandler()).build();
		server.start();
	}
}
