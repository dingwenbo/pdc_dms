package cn.newtouch.dms.entity;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Member {
	
    private Integer id;

    private String pdcId;

    private String password;
    
    private String salt;

    private String name;

    private String gender;

    private Integer roleId;

    private Integer supervisorId;

    private boolean backup;

    private String phone;

    private Date registerDate;

    private String plainPassword;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @NotBlank
    public String getPdcId() {
        return pdcId;
    }

    public void setPdcId(String pdcId) {
        this.pdcId = pdcId == null ? null : pdcId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }

    public boolean isBackup() {
		return backup;
	}
    
    public void setBackup(boolean backup) {
		this.backup = backup;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
	}

    // 设定JSON序列化时的日期格式
 	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
    
    /**
     * 系统传进的密码，不记录到数据库中。
     * @return String 未加密的密码
     */
    @JsonIgnore
	public String getPlainPassword() {
		return plainPassword;
	}

    /**
     * Setter方法。
     * @param plainPassword String
     */
	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}
}