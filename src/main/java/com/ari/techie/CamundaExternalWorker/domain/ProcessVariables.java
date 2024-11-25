package com.ari.techie.CamundaExternalWorker.domain;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "questions"
})
@Generated("jsonschema2pojo")
public class ProcessVariables {

    @JsonProperty("questions")
    private Questions questions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("questions")
    public Questions getQuestions() {
        return questions;
    }

    @JsonProperty("questions")
    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}