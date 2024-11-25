package com.ari.techie.CamundaExternalWorker.TaskHandler;

import com.ari.techie.CamundaExternalWorker.domain.RequestContext;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@ExternalTaskSubscription("loanGranter")
public class ProvideScoreHandlerTest implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        VariableMap variables = Variables.createVariables();
        Integer retries=0;
        try {

            retries = externalTask.getRetries();
            if (retries == null) {
                System.out.println(" retry is null");
                retries = 4;
            }

           ObjectValue requestContextJsonValue = externalTask.getVariableTyped("reqContext");
            RequestContext reqContext = (RequestContext) requestContextJsonValue.getValue();
            reqContext.setSpecificWitness(true);
            variables.putValue("reqContext", reqContext);
//
//
//            // complete the external task
            System.out.println("Inside loanGranter" );
            externalTaskService.complete(externalTask, variables);
        }catch(Exception ex){
            ex.printStackTrace();
            String exceptionMsg = ExceptionUtils.getStackTrace(ex);
            System.out.println(exceptionMsg);
            if(retries >1) {
                System.out.println("Retry Count "+retries);
                externalTaskService.handleFailure(externalTask, "one More",
                        "change content", retries - 1, 10000);

            }else{
                variables.putValue("errorMsg001", "Error Korecho Guru");
                externalTaskService.handleBpmnError(externalTask,"ERROR_CD_1" ,exceptionMsg);
            }
        }
    }
}
