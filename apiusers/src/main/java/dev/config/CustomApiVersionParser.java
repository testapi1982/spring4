package dev.config;

import org.springframework.web.accept.ApiVersionParser;

public class CustomApiVersionParser implements ApiVersionParser {

    @Override
    public Comparable parseVersion(String version) {
        if (version.startsWith("v") || version.startsWith("V")) {
            version = version.substring(1);
        }

        if (!version.contains(".")) {
            version = version + ".0";
        }
        return version;
    }

}
