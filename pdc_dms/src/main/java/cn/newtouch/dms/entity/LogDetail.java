package cn.newtouch.dms.entity;

import java.math.BigDecimal;

public class LogDetail extends LogDetailKey {
    private BigDecimal workTime;

    private String absent;

    public BigDecimal getWorkTime() {
        return workTime;
    }

    public void setWorkTime(BigDecimal workTime) {
        this.workTime = workTime;
    }

    public String getAbsent() {
        return absent;
    }

    public void setAbsent(String absent) {
        this.absent = absent == null ? null : absent.trim();
    }
}