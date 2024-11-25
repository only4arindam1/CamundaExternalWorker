package com.ari.techie.CamundaExternalWorker.domain;


public class CustomTask {
    private String taskId;
    private String TaskName;

    public CustomTask() {
    }

    public CustomTask(String taskId, String taskName) {
        this.taskId = taskId;
        TaskName = taskName;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    @Override
    public String toString() {
        return "CustomTask{" +
                "taskId='" + taskId + '\'' +
                ", TaskName='" + TaskName + '\'' +
                '}';
    }


}
