package com.spring.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SendRedirectOverloadedResponse extends HttpServletResponseWrapper
{
	private static Logger Log = LoggerFactory.getLogger(SendRedirectOverloadedResponse.class);
	private HttpServletRequest m_request;
	private String prefix = null;
	public SendRedirectOverloadedResponse(HttpServletRequest inRequest
			, HttpServletResponse response)
	{
		super(response);
		m_request = inRequest;
		prefix = getPrefix(inRequest);
	}

	public void sendRedirect(String location) throws IOException
	{
		Log.info("Going originally to:" + location);
		String finalurl = null;

		if (isUrlAbsolute(location))
		{
			Log.info("This url is absolute. No scheme changes will be attempted");
			finalurl = location;
		}
		else
		{
			finalurl = fixForScheme(prefix + location);
			Log.info("Going to absolute url:" + finalurl);
		}
		super.sendRedirect(finalurl);
	}

	public boolean isUrlAbsolute(String url)
	{
		String lowercaseurl = url.toLowerCase();
		if (lowercaseurl.startsWith("http") == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public String fixForScheme(String url)
	{
		//alter the url here if you were to change the scheme
		return url;
	}

	public String getPrefix(HttpServletRequest request)
	{
		StringBuffer str = request.getRequestURL();
		String url = str.toString();
		String uri = request.getRequestURI();
		if(!url.contains("assets"))
			Log.info("Request URL:" + url);
		int offset = url.indexOf(uri);
		String prefix = url.substring(0,offset);
		return prefix;
	}
}