package com.tide.hessian.server;

import com.caucho.hessian.server.HessianServlet;

public class HessianServiceImpl extends HessianServlet implements HessianService {

	@Override
	public String runHession(String val) {
		System.out.println("server HessianServiceImpl==="+val);
		return "ffffffff";
	}

}
