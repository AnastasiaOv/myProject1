package ru.javawebinar.topjava.to;

import java.math.BigDecimal;

/**
 * Created by Анастасия on 06.12.2017.
 */
public class RateTo {
    public RateTo() {
    }

    public RateTo(String positionName, String userName, int rateId, boolean isOwner, boolean isExecutor, boolean isResponsible, BigDecimal rateAmount) {
        this.positionName = positionName;
        this.userName = userName;
        this.rateId = rateId;
        this.isOwner = isOwner;
        this.isExecutor = isExecutor;
        this.isResponsible = isResponsible;
        this.rateAmount = rateAmount;
    }

    public RateTo(String positionName, String userName, int rateId, boolean isOwner, boolean isExecutor, boolean isResponsible, BigDecimal rateAmount, int processId) {
        this.positionName = positionName;
        this.userName = userName;
        this.rateId = rateId;
        this.isOwner = isOwner;
        this.isExecutor = isExecutor;
        this.isResponsible = isResponsible;
        this.rateAmount = rateAmount;
        this.processId = processId;
    }

    private String positionName;

    private String userName;

    private int rateId;
    private int processId;

    private boolean isOwner;

    private boolean isExecutor;

    private boolean isResponsible;

    private BigDecimal rateAmount;

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public BigDecimal getRateAmount() {
        return rateAmount;
    }

    public void setRateAmount(BigDecimal rateAmount) {
        this.rateAmount = rateAmount;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    public boolean isExecutor() {
        return isExecutor;
    }

    public void setExecutor(boolean executor) {
        isExecutor = executor;
    }

    public boolean isResponsible() {
        return isResponsible;
    }

    public void setResponsible(boolean responsible) {
        isResponsible = responsible;
    }
}
