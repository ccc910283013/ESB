package com.ewell.esb.bean;

public class ESBEventInfo {
    /**
     * 自增内码,QMGR.P63
     */
    private String logNo;
    /**
     * 消息管理器连接名
     */
    private String queueConnectName;
    /**
     * 集成平台服务ID
     */
    private String serviceId;
    /**
     * 消息队列序号
     */
    private String queueSeq;
    /**
     * 集成平台消息ID（非平台返回日志可为空）
     */
    private String messageId;
    /**
     * 消息内容
     */
    private String message;
    /**
     * 记录时间
     */
    private String recDate;
    /**
     * 服务器IP
     */
    private String serverIP;
    /**
     * 日志处理状态  0-已处理  1-待处理  2-处理失败
     */
    private String logStatus;
    /**
     * 消息类型  0-平台推送出去的消息 1-平台监听获得的消息
     */
    private String logType;
    /**
     * 上次更新时间，用来记录处理 锁定超时情况
     */
    private String lastUpdate;
    /**
     * 交易事务的全局唯一标识符，贯穿整个交易的生命周期
     */
    private String logGuid;
    /**
     * 集成平台服务ID
     */
    private String serviceName;

    @Override
    public String toString() {
        return "ESBEventInfo{" +
                "logNo='" + logNo + '\'' +
                ", queueConnectName='" + queueConnectName + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", queueSeq='" + queueSeq + '\'' +
                ", messageId='" + messageId + '\'' +
                ", message='" + message + '\'' +
                ", recDate='" + recDate + '\'' +
                ", serverIP='" + serverIP + '\'' +
                ", logStatus='" + logStatus + '\'' +
                ", logType='" + logType + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", logGuid='" + logGuid + '\'' +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }

    public String getLogNo() {
        return logNo;
    }

    public void setLogNo(String logNo) {
        this.logNo = logNo;
    }

    public String getQueueConnectName() {
        return queueConnectName;
    }

    public void setQueueConnectName(String queueConnectName) {
        this.queueConnectName = queueConnectName;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getQueueSeq() {
        return queueSeq;
    }

    public void setQueueSeq(String queueSeq) {
        this.queueSeq = queueSeq;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecDate() {
        return recDate;
    }

    public void setRecDate(String recDate) {
        this.recDate = recDate;
    }

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public String getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(String logStatus) {
        this.logStatus = logStatus;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLogGuid() {
        return logGuid;
    }

    public void setLogGuid(String logGuid) {
        this.logGuid = logGuid;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
