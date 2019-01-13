package cn.sunline.tiny;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogModFilter implements Filter {
	private static final Logger LOG = LoggerFactory.getLogger(LogModFilter.class);

	public void destroy() {
		LOG.info("----filter destory----");
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		LOG.info("----doFilter----");
        if(req instanceof HttpServletRequest) {  
            HttpServletRequest httpServletRequest = (HttpServletRequest) req;
            
            
            String sessionId =httpServletRequest.getRequestedSessionId();
    		if(sessionId == null || "".equals(sessionId)) {
    			sessionId = "default";
    		}
    		ThreadContext.put("sessionId", sessionId); 
        }

        chain.doFilter(req, resp);
		
	

		ThreadContext.clearAll();
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		LOG.info("----filter init----");
	}

}
