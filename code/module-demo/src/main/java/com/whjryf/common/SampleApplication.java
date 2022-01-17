package com.whjryf.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {"com.whjryf.base"})
//@ServletComponentScan
//@ImportResource(locations = {"classpath:security.xml"})
//@EnableConfigurationProperties({LiquibaseProperties.class})
//@EnableScheduling
//@EnableCaching
@Slf4j
public class SampleApplication {

    private static final String SERVER_SSL_KEY_STORE = "server.ssl.key-store";

    public static void main(String[] args) throws UnknownHostException {
        String active = System.getenv("spring.profiles.active");
        String location = "classpath:/config/";

        if (ArrayUtils.isNotEmpty(args)) {
            for (String arg : args) {
                if (arg.contains("spring.profiles.active")) {
                    active = StringUtils.substringAfter(arg, "=").trim();
                    System.out.println("use profile: " + active);
                    continue;
                }
                if (arg.contains("spring.config.location")) {
                    location = StringUtils.substringAfter(arg, "=").trim();
                    System.out.println("config location: " + location);
                }
            }
        }
        if (StringUtils.isNotBlank(active)) {
            location = location + "," + location + active + "/";
        } else {
            active = "";
        }

        String[] properties = new String[]{
                "spring.config.name:server,context",
                "spring.config.location:" + location
        };
        System.out.println("total location: " + location);
        ConfigurableApplicationContext applicationContext =
                new SpringApplicationBuilder(SampleApplication.class)
                        .properties(properties)
                        .build().run(args);

        ConfigurableEnvironment env = applicationContext.getEnvironment();

        String protocol = "http";
        if (env.getProperty(SERVER_SSL_KEY_STORE) != null) {
            protocol = "https";
        }
        String context = StringUtils.isNotBlank(env.getProperty("server.servlet.context-path")) ?
                env.getProperty("server.servlet.context-path") : "";
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}{}\n\t" +
                        "External: \t{}://{}:{}{}\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                env.getProperty("server.port"),
                context,
                protocol,
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                context,
                active);
    }

}
