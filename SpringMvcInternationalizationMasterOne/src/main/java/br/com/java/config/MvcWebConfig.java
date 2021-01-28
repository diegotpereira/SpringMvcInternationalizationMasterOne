package br.com.java.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.CacheControl;
import org.springframework.ui.context.ThemeSource;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor; 
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.context.MessageSource;

@Configuration
@EnableWebMvc
@ComponentScan("br.com.java")
public class MvcWebConfig implements WebMvcConfigurer {

	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");

	}

public void addResourceHandlers(ResourceHandlerRegistry registry) {
   //Add css file resource url here
     registry.addResourceHandler("/cssresources/**" 
    ).addResourceLocations("WEB-INF/css/")
     .setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());

 
     // Register resource handler for images
     registry.addResourceHandler("/images/**" 
    ).addResourceLocations("/WEB-INF/images/")
           .setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());

     // Register resource handler for multiple themes
     registry.addResourceHandler("/resources/**" 
     ).addResourceLocations("/staticresources/")
      .setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());
   }

//locale resolver for registering properties files for supporting intenationalization
	@Bean("messageSource")
	public MessageSource messageBundleSource() {
		ReloadableResourceBundleMessageSource messageBundleSource = new ReloadableResourceBundleMessageSource();
		messageBundleSource.setBasename("classpath:locale/language");
		messageBundleSource.setDefaultEncoding("UTF-8");
		messageBundleSource.setUseCodeAsDefaultMessage(true);
		return messageBundleSource;
	}

//locale resolver for supporting multi language
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver localeChangeResolver = new CookieLocaleResolver();
		return localeChangeResolver;
	}

	@Bean
	public ThemeSource themeSource() {
		ResourceBundleThemeSource themeSource = new ResourceBundleThemeSource();
		themeSource.setBasenamePrefix("theme/");
		return themeSource;
	}

	@Bean
	public ThemeResolver themeResolver() {
		CookieThemeResolver resolver = new CookieThemeResolver();
		resolver.setDefaultThemeName("cerulean");
		return resolver;
	}

	public void addInterceptors(InterceptorRegistry registry) {
		ThemeChangeInterceptor themeChangeInterceptor = new ThemeChangeInterceptor();
		themeChangeInterceptor.setParamName("themeresources");
		registry.addInterceptor(themeChangeInterceptor);

		// for multiple language support in your web appliation
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");
		registry.addInterceptor(localeChangeInterceptor);
	}

}
