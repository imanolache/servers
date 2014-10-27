package ro.ima.undertow;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

public class UndertowHandler implements HttpHandler {

	public void handleRequest(HttpServerExchange exchange) throws Exception {
		exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/html;charset=utf-8");
		exchange.getResponseSender().send("<h1>Hello World Undertow.io</h1>"
						+ System.currentTimeMillis());
	}

}
