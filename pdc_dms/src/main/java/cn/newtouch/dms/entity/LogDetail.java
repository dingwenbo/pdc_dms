package cn.newtouch.dms.entity;

import java.math.BigDecimal;
import java.util.Date;

public class LogDetail {

	private Task task;

	private Member member;

	private Date day;

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

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "LogDetail [task=" + task + ", member=" + member + ", day=" + day + ", workTime=" + workTime
				+ ", absent=" + absent + "]";
	}

}