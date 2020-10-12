package com.consorcio.pharmacy.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Esta clase se encarga de configurar el consumo de la api rest del servicio de comuna
 */
@ConfigurationProperties(prefix = "request.comuna")
@Component
public class ApiRestComunaConfig extends BaseRequestApi{

    private int[] regionId;

    public ApiRestComunaConfig() {
    }

    @Override
    public String getApi() {
        return super.getApi();
    }

    @Override
    public void setApi(String api) {
        super.setApi(api);
    }

    @Override
    public String[] getParameters() {
        return super.getParameters();
    }

    @Override
    public void setParameters(String[] parameters) {
        super.setParameters(parameters);
    }

    @Override
    public String getContentType() {
        return super.getContentType();
    }

    @Override
    public void setContentType(String contentType) {
        super.setContentType(contentType);
    }

    @Override
    public String getMethod() {
        return super.getMethod();
    }

    @Override
    public void setMethod(String method) {
        super.setMethod(method);
    }

    public int[] getRegionId() {
        return regionId;
    }

    public void setRegionId(int[] regionId) {
        this.regionId = regionId;
    }
}