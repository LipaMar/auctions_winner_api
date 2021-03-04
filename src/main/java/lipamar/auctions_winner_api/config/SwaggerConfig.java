package lipamar.auctions_winner_api.config;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeResolver;
import com.fasterxml.classmate.types.ResolvedArrayType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.method.HandlerMethod;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.readers.operation.HandlerMethodResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("lipamar.auctions_winner_api.controller"))
                .build();
    }

    @Bean
    @Primary
    public HandlerMethodResolver fluxMethodResolver(TypeResolver resolver) {
        return new HandlerMethodResolver(resolver) {
            @Override
            public ResolvedType methodReturnType(HandlerMethod handlerMethod) {
                var retType = super.methodReturnType(handlerMethod);

                // unwrap Mono, Flux, and ResponseEntity
                while (
                        retType.getErasedType() == Mono.class
                                || retType.getErasedType() == Flux.class
                                || retType.getErasedType() == ResponseEntity.class
                ) {
                    if ( retType.getErasedType() == Flux.class ) {
                        // treat it as an array
                        var type = retType.getTypeBindings().getBoundType(0);
                        retType = new ResolvedArrayType(type.getErasedType(), type.getTypeBindings(), type);
                    } else {
                        retType = retType.getTypeBindings().getBoundType(0);
                    }
                }

                return retType;
            }
        };
    }
}
