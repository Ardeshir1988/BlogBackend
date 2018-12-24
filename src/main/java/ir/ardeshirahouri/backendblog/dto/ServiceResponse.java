package ir.ardeshirahouri.backendblog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ServiceResponse {
    private String status;
    private Object model;
    public ServiceResponse(){}
    public ServiceResponse(String status, Object model) {
        this.status = status;
        this.model = model;
    }
}
