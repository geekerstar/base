package com.geekerstar.configure.swagger;

import com.github.xiaoymin.knife4j.spring.annotations.EnableSwaggerBootstrapUi;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author geekerstar
 * date: 2019-12-21 14:13
 * description:
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUi
@Profile({"dev","test"})
@EnableConfigurationProperties(SwaggerInfo.class)
public class SwaggerConfig {

	@Autowired
	private SwaggerInfo swaggerInfo;

	@Bean
	public Docket allApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName(swaggerInfo.getGroupName())
				.useDefaultResponseMessages(false)
				.enableUrlTemplating(false)
				.forCodeGeneration(true)
				.useDefaultResponseMessages(false)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(swaggerInfo.getBasePackage()))
				.paths(PathSelectors.any())
				.build();
	}


	/**
	 * 设置api信息
	 *
	 * @return 返回ApiInfo
	 */
	private ApiInfo apiInfo() {
		StringVendorExtension vendorExtension = new StringVendorExtension("", "");
		Collection<VendorExtension> vendorExtensions = Lists.newArrayList();
		vendorExtensions.add(vendorExtension);
		Contact contact = new Contact("Geekerstar", "https://www.geekerstar.com", "247507792@qq.com");
		return new ApiInfo(
				swaggerInfo.getTitle(),
				swaggerInfo.getDescription(),
				swaggerInfo.getVersion(),
				"", contact, "11", "11",
				vendorExtensions);
	}
}
