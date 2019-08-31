package com.bigguy.spring.security.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintUtils {
	
	private static Logger LOG = LoggerFactory.getLogger(PrintUtils.class);
	
	public static void outPrint(HttpServletResponse response, Object obj){
		response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/json"); 
        
                
        PrintWriter out;
		try {
			out = response.getWriter();
			out.print(MapperUtils.toJson(obj));
			out.flush();
			out.close();
		} catch (IOException e) {
			LOG.error("outPring error.", e);
				
		}
	}
}

	