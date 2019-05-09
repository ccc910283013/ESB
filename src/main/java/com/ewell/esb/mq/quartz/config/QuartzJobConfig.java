package com.ewell.esb.mq.quartz.config;


public class QuartzJobConfig {
    private String jobName;
    private String beanName;
    private String methodName;
    private String params;
    private String cronExpression;
    /**
     * 获取任务
     * @param taskName 任务名称
     * @return
     */
    public static QuartzJobConfig getInstance(String taskName){
        QuartzJobConfig jobConfig = new QuartzJobConfig();
        switch (taskName){
            case "ESBEventMonitor":
                jobConfig.jobName = taskName;
                jobConfig.beanName = "BuninessTask";
                jobConfig.methodName = "taskMonitorEvent";
                jobConfig.params = null;
            default:
        }
        return jobConfig;
    }
    public static String getCronExpression(String timeInternal){

        return "";
    }
    public String getJobName() {
        return jobName;
    }

    public String getBeanName() {
        return beanName;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getParams() {
        return params;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }


}
