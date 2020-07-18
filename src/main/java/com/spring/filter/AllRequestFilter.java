package com.spring.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.beans.AllServices;
import com.spring.service.AllServicesservice;

@Controller
public class AllRequestFilter implements Filter {

	private static Logger logger = LoggerFactory.getLogger(AllRequestFilter.class);
	
	@Autowired
	AllServicesservice allServService;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//logger.info("FILTER:: Filtration started.");
		HttpServletRequest servletReq = (HttpServletRequest) request;
		HttpServletResponse servletRes = (HttpServletResponse) response;
		//logger.info("FILTER:: Requested servlet path: "+servletReq.getServletPath());
		//logger.info("FILTER:: Requested servlet context: "+servletReq.getServletContext());
		servletReq.setAttribute("reqURI1", servletReq.getRequestURI());
		
		
		if(servletReq.getRequestURI().startsWith("/assets")) {
			chain.doFilter(request, new SendRedirectOverloadedResponse(servletReq, servletRes));
		}
		else {
			logger.info("FILTER:: Requested URI: "+servletReq.getRequestURI()+" Login? "+servletReq.getSession().getAttribute("uNm"));
			logger.info("FILTER:: Details of client -> IP: "+ servletReq.getRemoteAddr());
			logger.info("FILTER:: Details of client -> User: "+ servletReq.getRemoteUser());
			List<AllServices> requestedURIList = allServService.findByServiceURI(servletReq.getRequestURI());
			if(requestedURIList==null || requestedURIList.size()==0) {
				if(servletReq.getRequestURI().startsWith("/startService") || servletReq.getRequestURI().startsWith("/stopService")
						|| servletReq.getRequestURI().startsWith("/approveAdmin") || servletReq.getRequestURI().startsWith("/approveUser")
						|| servletReq.getRequestURI().startsWith("/approveContri")) {
					if(servletReq.getSession().getAttribute("uNm")!=null && servletReq.getSession().getAttribute("userRole").toString().equals("Admin")) {
						logger.info("FILTER:: Restricted URI: "+servletReq.getRequestURI());
						logger.info("FILTER:: Restricted URI access granted to: "+servletReq.getSession().getAttribute("uNm").toString());
						chain.doFilter(request, new SendRedirectOverloadedResponse(servletReq, servletRes));
					}
					else {
						//servletReq.getSession().invalidate();
						servletRes.sendRedirect("/unauthorizedAccess");
					}
				}
				else {
					chain.doFilter(request, new SendRedirectOverloadedResponse(servletReq, servletRes));
				}
			}
			else if(requestedURIList.size()>0 && requestedURIList.get(0).isServiceStatus()) {
				chain.doFilter(request, new SendRedirectOverloadedResponse(servletReq, servletRes));
			}
			else {
				if(servletReq.getRequestURI().equals("/")) {
					servletRes.sendRedirect("/websiteClosed");
				}
				else {
					servletRes.sendRedirect("/closedService");
				}
			}
		}
		//logger.info("FILTER:: Filtration ended.");
		
	}

}
