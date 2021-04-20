package co.edu.poli.mongodb.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket customerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
                .select()                 
                .apis(RequestHandlerSelectors.basePackage("co.edu.poli.mongodb.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(mongoCustomerApiInfo());
	}
	
	private ApiInfo mongoCustomerApiInfo() {
		return new ApiInfoBuilder().
				title("Ｐｏｌｉ Ｂｌｏｇｒ＇ｓ").
				description("Somos una pagina dedicada a la informacion actualizada de lo mas reciente del Poli")
				.contact(new Contact("PBTeam", "www.poliblogrs.com","poliblogrs@gmail.com"))
				.version("0.0.1").
				build();
	}
}