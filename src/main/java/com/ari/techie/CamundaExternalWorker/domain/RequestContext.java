package com.ari.techie.CamundaExternalWorker.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinition;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestContext {
    public String requestId;
    public String witnessId;
    public boolean isSpecificWitness;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getWitnessId() {
        return witnessId;
    }

    public void setWitnessId(String witnessId) {
        this.witnessId = witnessId;
    }

    @Override
    public String toString() {
        return "RequestContext{" +
                "requestId='" + requestId + '\'' +
                ", witnessId='" + witnessId + '\'' +
                '}';
    }
}
