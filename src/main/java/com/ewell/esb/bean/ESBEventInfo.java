package com.ewell.esb.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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

}
