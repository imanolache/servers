package ro.ima.server.grizzly;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;

public class GrizzlyHandler extends HttpHandler{

	@Override
	public void service(Request request, Response response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(200);
		response.getWriter().write("<h1>Hello World Grizzly</h1>" + System.currentTimeMillis());
	}

}
