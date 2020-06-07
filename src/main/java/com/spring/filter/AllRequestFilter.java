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
import com.spring.repository.AllServiceRepository;

@Controller
public class AllRequestFilter implements Filter {

	private static Logger logger = LoggerFactory.getLogger(AllRequestFilter.class);
	
	@Autowired
	AllServiceRepository allServiceRepo;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		logger.info("FILTER:: Filtration started.");
		HttpServletRequest servletReq = (HttpServletRequest) request;
		HttpServletResponse servletRes = (HttpServletResponse) response;
		logger.info("FILTER:: Requested URI: "+servletReq.getRequestURI());
		logger.info("FILTER:: Requested servlet path: "+servletReq.getServletPath());
		logger.info("FILTER:: Requested servlet context: "+servletReq.getServletContext());
		
		if(servletReq.getRequestURI().startsWith("/assets")) {
			chain.doFilter(request, response);
		}
		else {
			List<AllServices> requestedURIList = allServiceRepo.findByServiceURI(servletReq.getRequestURI());
			if(requestedURIList==null || requestedURIList.size()==0) {
				chain.doFilter(request, response);
			}
			else if(requestedURIList.size()>0 && requestedURIList.get(0).isServiceStatus()) {
				chain.doFilter(request, response);
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
		logger.info("FILTER:: Filtration ended.");
		
	}

}
