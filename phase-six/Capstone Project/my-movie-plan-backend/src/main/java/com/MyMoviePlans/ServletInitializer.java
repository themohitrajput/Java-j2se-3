package com.MyMoviePlans;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilderconfigure(SpringApplicationBuilder application) {
		return application.sources(MyMoviePlanApplication.class);
	}

}
