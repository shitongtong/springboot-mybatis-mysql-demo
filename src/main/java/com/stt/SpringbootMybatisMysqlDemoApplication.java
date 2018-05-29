package com.stt;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shitt7 on 2018/5/25.
 */
@SpringBootApplication
@MapperScan("com.stt.mapper")
public class SpringbootMybatisMysqlDemoApplication extends WebMvcConfigurerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootMybatisMysqlDemoApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(SpringbootMybatisMysqlDemoApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        Map<String, Object> defaultMap = new HashMap<>();
        defaultMap.put("spring.profiles.active", "dev");
        app.setDefaultProperties(defaultMap);
        app.run(args);
        LOGGER.debug("容器启动成功!");
    }

    /**
     * 解决跨域问题
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }
}
