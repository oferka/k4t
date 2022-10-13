package org.karp.k4t;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.karp.k4t.data.content.loader.ContentLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import static org.karp.k4t.Application.*;

@SpringBootApplication
@Theme(value = THEME_NAME)
@PWA(name = APPLICATION_NAME, shortName = APPLICATION_SHORT_NAME, offlineResources = { APPLICATION_LOGO })
@NpmPackage(value = "line-awesome", version = "1.3.0")
public class    Application extends SpringBootServletInitializer implements AppShellConfigurator {

    public static final String THEME_NAME = "k4t";
    public static final String APPLICATION_NAME = "k4t";
    public static final String APPLICATION_SHORT_NAME = "k4t";
    public static final String APPLICATION_LOGO = "images/logo.png";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner ensureContentLoaded(ContentLoader contentLoader) {
        return args -> contentLoader.ensureContentLoaded();
    }
}
