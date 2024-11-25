package com.ari.techie.CamundaExternalWorker.TaskHandler;

import com.ari.techie.CamundaExternalWorker.domain.Message;
import com.ari.techie.CamundaExternalWorker.domain.ProcessVariables;
import com.ari.techie.CamundaExternalWorker.domain.Questions;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ExternalTaskSubscription("sendRmail")
public class SendEmailHandler implements ExternalTaskHandler {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void execute(ExternalTask externalTask,
                        ExternalTaskService externalTaskService) {

        String key = externalTask.getBusinessKey();
//        double number = Math.floor((Math.random() * 100) + 1);
//        if(Math.random()/2 ==0){
//
//        }
 //       VariableMap varMap = Variables.createVariables();
 //       varMap.putValue("isEscalation",false);
 //       externalTaskService.complete(externalTask,varMap);

        String url = "http://localhost:8080/engine-rest/message";
        Questions questions = new Questions();
        questions.setType("String");
        questions.setValue("Checking the Event Subprocess  event");
        Message msg = new Message();
        ProcessVariables variables = new ProcessVariables();
        variables.setQuestions(questions);
        msg.setBusinessKey(key);
        msg.setMessageName("travelTime");
        msg.setProcessVariables(variables);
//        Gson gson = new Gson();
//        String msgJson =gson.toJson(msg);
   //     System.out.println("msg in json"+ msgJson);
        restTemplate = new RestTemplate();
        HttpEntity<Message> request = new HttpEntity<>(msg);
        String businessKey = externalTask.getBusinessKey();
        VariableMap map = Variables.createVariables();
        map.putValue("customerId",businessKey);
     //   ResponseEntity response = restTemplate.postForObject(url,request, ResponseEntity.class);
        externalTaskService.setVariables(externalTask,map);
        externalTaskService.complete(externalTask);
        System.out.println(" Completing the SendEmailHandler method call 123");
    }
}
