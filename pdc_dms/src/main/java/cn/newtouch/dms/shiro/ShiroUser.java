package cn.newtouch.dms.shiro;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;

import com.google.common.base.Objects;

/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
 */
public class ShiroUser implements Serializable {
	
	private static final long serialVersionUID = -1373760761780840081L;
	public Integer id;
	public String pdcId;
	public String name;

	public ShiroUser(Integer id, String pdcId, String name) {
		this.id = id;
		this.pdcId = pdcId;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPdcId() {
		return pdcId;
	}

	public void setPdcId(String pdcId) {
		this.pdcId = pdcId;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ShiroUser [id=" + id + ", pdcId=" + pdcId + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, pdcId);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ShiroUser) {
			ShiroUser user = (ShiroUser) obj;
			return new EqualsBuilder()
					.append(id, user.getId())
					.append(pdcId, user.getPdcId())
					.isEquals();
		}
		return false;
	}
}
