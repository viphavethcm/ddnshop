package com.ddnshop.rolesservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("roles-service")
public class Configuration {
    private int maxium;
    private int minium;

    public int getMaxium() {
        return maxium;
    }

    public void setMaxium(int maxium) {
        this.maxium = maxium;
    }

    public int getMinium() {
        return minium;
    }

    public void setMinium(int minium) {
        this.minium = minium;
    }
}
