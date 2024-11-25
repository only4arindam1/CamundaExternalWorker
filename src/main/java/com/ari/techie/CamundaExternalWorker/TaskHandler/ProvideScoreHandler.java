package com.ari.techie.CamundaExternalWorker.TaskHandler;

import com.ari.techie.CamundaExternalWorker.domain.RequestContext;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.slf4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription("scoreProvider")
public class ProvideScoreHandler implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {



        VariableMap variables = Variables.createVariables();
      //  String context = externalTask.getVariable("reqContext");

       // System.out.println("Request details :"+ context);
        externalTaskService.complete(externalTask, variables);
    }
}
