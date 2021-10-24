package br.com.nilo.userapi.config;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfigurationTest {

    @Test
    public void validar_inicio_api(){

        SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration();

        Docket api = swaggerConfiguration.api();

        Assertions.assertEquals("user-API", api.getGroupName());
    }
}
