package com.change.github.reflect;

 public class Emp {
    private String ename;
    private String Job;
    private String skill;

    public String getEName() {
        return ename;
    }

    public void setEname(String name) {
        this.ename = name;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        this.Job = job;
    }

    public String getSkill() {
         return skill;
    }

    public void setSkill(String skill) {
         this.skill = skill;
    }

     @Override
     public String toString() {
         return "Emp{" +
                 "ename='" + ename + '\'' +
                 ", Job='" + Job + '\'' +
                 ", skill='" + skill + '\'' +
                 '}';
     }
 }
