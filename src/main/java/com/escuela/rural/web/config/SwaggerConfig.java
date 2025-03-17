package com.escuela.rural.web.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;

@OpenAPIDefinition(
        info=@Info(
                title="API Gestión educativa Escuela Rural",
                description = "La presente api consiste en establecer los parámetros básicos de una institución educativa de carácter rural en colombia ",
                termsOfService = "https://github.com/Ronald-ICastroG/api-rest_gestion_educativa",
                version = "1.0.0",
                summary = "La aplicación permite gestionar los aspectos básicos para la gestión educativa, creación de grupos, asignaturas, periodos, docentes, estuadiantes y calificaciones",
                contact = @Contact(
                         name="Ronald I. Castro G.",
                        url = "https://github.com/Ronald-ICastroG",
                        email = "ronaldivan.121068@correo.uis.edu.co"
                ),
                license = @License(
                        name= "Standar Software Use License for Rc8.corp",
                        url="https://github.com/Ronald-ICastroG/api-rest_gestion_educativa",
                        identifier = "127.0.0.1"

                )


        ),servers ={
                @Server(
                        description = "DEV SERVER",
                        url = "https://localhost:8080/dev/api/v1/geducativa"
                ),
                @Server(description = "PROD SERVER",
                        url = "https://localhost:8090/prod/api/v1/geducativa"
                ),
                @Server(description="QA SERVER",
                        url="http://localhost:8082/qa/api/v1/geducativa"
                )
}
)
public class SwaggerConfig {
}
