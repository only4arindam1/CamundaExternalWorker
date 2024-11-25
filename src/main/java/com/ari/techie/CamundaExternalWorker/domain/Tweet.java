package com.ari.techie.CamundaExternalWorker.domain;


public class Tweet {
    String comment;
    int noOfLikes;


    public Tweet() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getNoOfLikes() {
        return noOfLikes;
    }

    public void setNoOfLikes(int noOfLikes) {
        this.noOfLikes = noOfLikes;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "comment='" + comment + '\'' +
                ", noOfLikes=" + noOfLikes +
                '}';
    }
}
