package lwt.lab;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.entity.ContentType;

import lwt.lab.utils.ResponseUtils;

/**
 * Servlet implementation class ServletInfo
 */
@WebServlet("/ServletInfo")
public class ServletInfo extends HttpServlet {
    private static final String SERVLET_CONTEXT_SERVER_INFO_LABEL = "Servlet context server info: ";
    private static final String REQUEST_SERVLET_CONTEXT_SERVER_INFO_LABEL = "Request-Servlet context server info: ";
    private static final String SERVLET_CONTEXT_MINOR_VERSION_LABEL = "Servlet context minor version: ";
    private static final String REQUEST_SERVLET_CONTEXT_MINOR_VERSION_LABEL = "Request-Servlet context minor version: ";
    private static final String SERVLET_CONTEXT_MAJOR_VERSION_LABEL = "Servlet context major version: ";
    private static final String REQUEST_SERVLET_CONTEXT_MAJOR_VERSION_LABEL = "Request-Servlet context major version: ";
    private static final String SERVLET_CONTEXT_PATH_LABEL = "Servlet context path: ";
    private static final String REQUEST_SERVLET_CONTEXT_PATH_LABEL = "Request-Servlet context path: ";
    private static final String SERVLET_CONTEXT_NAME_LABEL = "Servlet context name: ";
    private static final String REQUEST_SERVLET_CONTEXT_NAME_LABEL = "Request-Servlet context name: ";
    private static final String REQUEST_SERVER_PORT_LABEL = "Request server port: ";
    private static final String REQUEST_SERVER_NAME_LABEL = "Request server name: ";
    private static final String REQUEST_PROTOCOL_LABEL = "Request protocol: ";
    private static final String REQUEST_LOCAL_PORT_LABEL = "Request local port: ";
    private static final String REQUEST_LOCAL_NAME_LABEL = "Request local name: ";
    private static final String SERVLET_NAME_LABEL = "Servlet name: ";
    private static final String SERVLET_INFO_LABEL = "Servlet info: ";
    private static final String CSS_PATH = "/css/style.css";
    private static final String TITLE = "Info";
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInfo() {
	super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType(ContentType.TEXT_HTML.getMimeType());
	StringBuilder bodyBuilder = new StringBuilder();

	bodyBuilder.append(ResponseUtils.appendP(SERVLET_INFO_LABEL));
	log(SERVLET_INFO_LABEL);
	String servletName = SERVLET_NAME_LABEL + getServletName();
	bodyBuilder.append(ResponseUtils.appendP(servletName));
	log(servletName);

	String requestLocalName = REQUEST_LOCAL_NAME_LABEL + request.getLocalName();
	bodyBuilder.append(ResponseUtils.appendP(requestLocalName));
	log(requestLocalName);

	String requestLocalPort = REQUEST_LOCAL_PORT_LABEL + request.getLocalPort();
	bodyBuilder.append(ResponseUtils.appendP(requestLocalPort));
	log(requestLocalPort);

	String requestProtocol = REQUEST_PROTOCOL_LABEL + request.getProtocol();
	bodyBuilder.append(ResponseUtils.appendP(requestProtocol));
	log(requestProtocol);

	String requestServerName = REQUEST_SERVER_NAME_LABEL + request.getServerName();
	bodyBuilder.append(ResponseUtils.appendP(requestServerName));
	log(requestServerName);

	String requestServerPort = REQUEST_SERVER_PORT_LABEL + request.getServerPort();
	bodyBuilder.append(ResponseUtils.appendP(requestServerPort));
	log(requestServerPort);

	ServletContext requestServletContext = request.getServletContext();
	ServletContext servletContext = getServletContext();

	String requestServletContextName = REQUEST_SERVLET_CONTEXT_NAME_LABEL
		+ requestServletContext.getServletContextName();
	bodyBuilder.append(ResponseUtils.appendP(requestServletContextName));
	log(requestServletContextName);

	String servletContextName = SERVLET_CONTEXT_NAME_LABEL + servletContext.getServletContextName();
	bodyBuilder.append(ResponseUtils.appendP(servletContextName));
	log(servletContextName);

	String requestServletContextPath = REQUEST_SERVLET_CONTEXT_PATH_LABEL + requestServletContext.getContextPath();
	bodyBuilder.append(ResponseUtils.appendP(requestServletContextPath));
	log(requestServletContextPath);

	String servletContextPath = SERVLET_CONTEXT_PATH_LABEL + servletContext.getContextPath();
	bodyBuilder.append(ResponseUtils.appendP(servletContextPath));
	log(servletContextPath);

	String requestServletContextMajorVersion = REQUEST_SERVLET_CONTEXT_MAJOR_VERSION_LABEL
		+ requestServletContext.getMajorVersion();
	bodyBuilder.append(ResponseUtils.appendP(requestServletContextMajorVersion));
	log(requestServletContextMajorVersion);

	String servletContextMajorVersion = SERVLET_CONTEXT_MAJOR_VERSION_LABEL + servletContext.getMajorVersion();
	bodyBuilder.append(ResponseUtils.appendP(servletContextMajorVersion));
	log(servletContextMajorVersion);

	String requestServletContextMinorVersion = REQUEST_SERVLET_CONTEXT_MINOR_VERSION_LABEL
		+ requestServletContext.getMinorVersion();
	bodyBuilder.append(ResponseUtils.appendP(requestServletContextMinorVersion));
	log(requestServletContextMinorVersion);

	String servletContextMinorVersion = SERVLET_CONTEXT_MINOR_VERSION_LABEL + servletContext.getMinorVersion();
	bodyBuilder.append(ResponseUtils.appendP(servletContextMinorVersion));
	log(servletContextMinorVersion);

	String requestServletContextServerInfo = REQUEST_SERVLET_CONTEXT_SERVER_INFO_LABEL
		+ requestServletContext.getServerInfo();
	bodyBuilder.append(ResponseUtils.appendP(requestServletContextServerInfo));
	log(requestServletContextServerInfo);

	String servletContextServerInfo = SERVLET_CONTEXT_SERVER_INFO_LABEL + servletContext.getServerInfo();
	bodyBuilder.append(ResponseUtils.appendP(servletContextServerInfo));
	log(servletContextServerInfo);

	response.getWriter().append(ResponseUtils.titleBodyStyleHTML(TITLE, bodyBuilder.toString(), CSS_PATH));
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doGet(request, response);
    }

}
