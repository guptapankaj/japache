package util;


import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by pgupta10 on 27/08/16.
 */
public class PropertiesReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesReader.class);

    private static final Configurations configs = new Configurations();

    private static final String STATIC_CONTENT_DIR_PROP = "static.content.dir";
    private static final String HTTP_PORT_PROP = "http.port";

    private static Configuration config;
    static {
        try {
            config = configs.properties(new File("japache.conf"));
        } catch (ConfigurationException e){
            LOGGER.error("Failed to read configs, EXITING!");
            LOGGER.error(e.getMessage());
        }
    }

    public static String getStaticContentDir() {
        String staticContentDir = config.getString(STATIC_CONTENT_DIR_PROP);
        LOGGER.trace("Static content dir : " + staticContentDir);
        return staticContentDir;
    }

    public static Integer getHttpPort(){
        Integer httpPort = config.getInt(HTTP_PORT_PROP);
        LOGGER.trace("HTTP port : " + httpPort);
        return httpPort;
    }
}
