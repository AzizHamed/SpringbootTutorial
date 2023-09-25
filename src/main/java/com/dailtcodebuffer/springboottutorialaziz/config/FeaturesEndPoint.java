package com.dailtcodebuffer.springboottutorialaziz.config;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features")
public class FeaturesEndPoint {
    private final Map<String,Feature> featureMap = new ConcurrentHashMap<>();


    public FeaturesEndPoint() {
        featureMap.put("Department", new Feature(true));
        featureMap.put("User", new Feature(false));
        featureMap.put("Authentication", new Feature(false));
    }
    @ReadOperation
    public Map<String,Feature> features(){
        return featureMap;
    }
    @ReadOperation
    public Feature feature(@Selector String featureName){
        return featureMap.get(featureName);
    }

    private static class Feature{
        private boolean isEnabled;

        public Feature(boolean isEnabled) {
            this.isEnabled = isEnabled;
        }

        public Feature() {
        }

        public boolean isEnabled() {
            return isEnabled;
        }

        public void setEnabled(boolean enabled) {
            isEnabled = enabled;
        }
    }

}
