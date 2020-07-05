package com.abc.xyz;

import javax.annotation.Resource;
import javax.servlet.MultipartConfigElement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import com.abc.xyz.service.ProductImageService;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ProjectGstLiteAbcxyzApplication {

	@Resource
	ProductImageService storageService;
    public static void main(String[] args)throws Exception {
        SpringApplication.run(ProjectGstLiteAbcxyzApplication.class, args);
    }
    
    public void run(String... arg) throws Exception {
//      storageService.deleteAll();
      storageService.init();
    }
    
//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//		MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setMaxRequestSize("5120KB");
//        factory.setMaxFileSize("5120KB");
//        return factory.createMultipartConfig();
//    }
//	
//	public static void main(String[] args) {
//		SpringApplication.run(ProjectGstLiteAbcxyzApplication.class, args);
//	}
//	
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(applicationClass);
//    }
//
//    private static Class<ProjectGstLiteAbcxyzApplication> applicationClass = ProjectGstLiteAbcxyzApplication.class;

}