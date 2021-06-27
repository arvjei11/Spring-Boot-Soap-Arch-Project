package com.arvind.soap.webservices.soapcoursemanagement.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/* The web service config file needs two annotations to enable springboot to recognise it as wsconfig file */

@EnableWs
@Configuration
public class WebServiceConfig {

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		// create a mds
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		// set the context for the created mds
		messageDispatcherServlet.setApplicationContext(context);
		// create wsdl configuration for the mds

		messageDispatcherServlet.setTransformWsdlLocations(true);
		// return the mapped servlet to the required url
		return new ServletRegistrationBean(messageDispatcherServlet, "/ws");
	}

	// define the wsdl

	@Bean(name = ("courses")) /* create a bean that with user defined url path */
	public DefaultWsdl11Definition defaultwsdl11Definition(XsdSchema coursesSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		// set the url to be exposed, the namespace,the schema class and the port type
		// for the wsdl definition requirements
		definition.setPortTypeName("CoursePort");
		definition.setTargetNamespace("http://arvind.com/courses");
		definition.setLocationUri("/ws");
		definition.setSchema(coursesSchema);
		return definition;
	}

	@Bean // bean that returns the needed schema for the wsdl definition
	public XsdSchema coursesSchema() {

		return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));

	}
}
