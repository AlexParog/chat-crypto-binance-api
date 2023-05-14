package com.application;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Точка входа в приложение Spring Boot.
 * <p>
 * Класс {@code Application} является точкой входа в приложение Spring Boot.
 * Он помечен аннотацией {@code @SpringBootApplication} для включения функций автоконфигурации и сканирования компонентов,
 * предоставляемых Spring Boot. Кроме того, он реализует интерфейс {@code AppShellConfigurator}
 * для настройки оболочки приложения Vaadin.
 */
@SpringBootApplication
@Theme(value = "cryptochat")
public class Application implements AppShellConfigurator {

    /**
     * Главный метод приложения.
     * Он запускает приложение Spring Boot, вызывая метод {@code SpringApplication.run()}.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
