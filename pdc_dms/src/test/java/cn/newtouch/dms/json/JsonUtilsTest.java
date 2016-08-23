package cn.newtouch.dms.json;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 类JsonUtils的测试类
 * @author JiaLong.Wang
 *
 */
public class JsonUtilsTest {
	
	/** logger. */
	private static Log logger = LogFactory.getLog(JsonUtilsTest.class);
	
	/** test1. */
	private TempObject test1 = new TempObject();
	/** test2. */
	private TempObject test2 = new TempObject();
	
	/** testJsonStr1. */
	private String testJsonStr1 = new StringBuilder()
			.append("{\n")
			.append("  \"varInt\" : 1,\n")
			.append("  \"varLong\" : 3,\n")
			.append("  \"varIntO\" : 2,\n")
			.append("  \"str\" : \"Test String\",\n")
			.append("  \"dateObj\" : \"2016-08-01 01:02:03\",\n")
			.append("  \"innerObj\" : {\n")
			.append("    \"varInnerInt\" : 4,\n")
			.append("    \"innerStr\" : \"Inner str\"\n")
			.append("  }\n")
			.append("}\n")
			.toString();
	
	private String testJsonList = new String("[{\"varInt\" : 1,\"varLong\" : 3,\"varIntO\" : 2,\"str\" : \"Test String\","
			+ "\"dateObj\" : \"2016-08-01 01:02:03\",\"innerObj\" : {\"varInnerInt\" : 4,\"innerStr\" : \"Inner str\"}}, {"
			+ "\"varInt\" : 5,\"varLong\" : 7,\"varIntO\" : 6,\"str\" : \"Test String 2\",\"dateObj\" : \"2016-02-02 02:02:02\","
			+ "\"innerObj\" : {\"varInnerInt\" : 8,\"innerStr\" : \"Inner str\"}}]");
	
	@Before
	public void init() {
		test1.setStr("Test String");
		test1.setStrIgnore("Test String Ignore");
		test1.setVarInt(1);
		test1.setVarIntO(Integer.valueOf(2));
		test1.setVarLong(3L);
		test1.setDateObj(new LocalDateTime(2016, 8, 01, 01, 02, 03).toDate());
		test1.setInnerObj(new Inner("Inner str", 4));
		
		test2.setStr("Test String 2");
		test2.setStrIgnore("Test String Ignore");
		test2.setVarInt(5);
		test2.setVarIntO(Integer.valueOf(6));
		test2.setVarLong(7L);
		test2.setDateObj(new LocalDateTime(2016, 02, 02, 02, 02, 02).toDate());
		test2.setInnerObj(new Inner("Inner str", 8));
	}
	
	@Test
	public void testWriteJson() {
		String jsonStr = JsonUtils.writeObject(test1);
		logger.info(jsonStr);
//		assertNotNull(jsonStr);
//		assertTrue(compareJsonStr(jsonStr, testJsonStr1));
	}
	
	@Test
	public void testWriteJsonList() {
		List<TempObject> list = new ArrayList<>();
		list.add(test1);
		list.add(test2);
		String jsonStr = JsonUtils.writeObject(list);
		logger.info(jsonStr);
	}
	
	@Test
	public void testReadJsonStr() {
		TempObject temp = JsonUtils.readObject(testJsonStr1, TempObject.class);
		assertNotNull(temp);
		assertTrue(temp.equals(test1));
	}
	
	@Test
	public void testReadJsonStrList() {
		List<TempObject> list = JsonUtils.readList(testJsonList, TempObject.class);
		logger.info(list);
	}
	
	@SuppressWarnings("unused")
	private boolean compareJsonStr(String str1, String str2) {
		//TODO : to compare json string.
		String regex = "[\r\n]";
		return StringUtils.equals(
				StringUtils.replacePattern(str1, regex, ""), 
				StringUtils.replacePattern(str2, regex, ""));
	}
}

class TempObject {
	
	int varInt;
	long varLong;
	Integer varIntO;
	String str;
	@JsonIgnore
	String strIgnore;
	String nullObj;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	Date dateObj;
	Inner innerObj;
	
	public TempObject() {
	}
	
	public int getVarInt() {
		return varInt;
	}

	public void setVarInt(int varInt) {
		this.varInt = varInt;
	}

	public long getVarLong() {
		return varLong;
	}

	public void setVarLong(long varLong) {
		this.varLong = varLong;
	}

	public Integer getVarIntO() {
		return varIntO;
	}

	public void setVarIntO(Integer varIntO) {
		this.varIntO = varIntO;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getStrIgnore() {
		return strIgnore;
	}

	public void setStrIgnore(String strIgnore) {
		this.strIgnore = strIgnore;
	}

	public Date getDateObj() {
		return dateObj;
	}

	public void setDateObj(Date dateObj) {
		this.dateObj = dateObj;
	}

	public Inner getInnerObj() {
		return innerObj;
	}

	public void setInnerObj(Inner innerObj) {
		this.innerObj = innerObj;
	}
	
	public String getNullObj() {
		return nullObj;
	}

	public void setNullObj(String nullObj) {
		this.nullObj = nullObj;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(varInt)
				.append(varLong)
				.append(varIntO)
				.append(str)
				.append(nullObj)
				.append(dateObj)
				.append(innerObj)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TempObject)) {
			return false;
		}
		TempObject to = (TempObject) obj;
		return new EqualsBuilder()
				.append(varInt, to.getVarInt())
				.append(varLong, to.getVarLong())
				.append(varIntO, to.getVarIntO())
				.append(str, to.getStr())
				.append(nullObj, to.getNullObj())
				.append(dateObj, to.getDateObj())
				.append(innerObj, to.getInnerObj())
				.isEquals();
	}
}

class Inner {
	int varInnerInt;
	String innerStr;
	
	public Inner() {
		
	}
	
	public int getVarInnerInt() {
		return varInnerInt;
	}
	public void setVarInnerInt(int varInnerInt) {
		this.varInnerInt = varInnerInt;
	}
	public String getInnerStr() {
		return innerStr;
	}
	public void setInnerStr(String innerStr) {
		this.innerStr = innerStr;
	}
	public Inner(String str, int varInt) {
		this.innerStr = str;
		this.varInnerInt = varInt;
	}
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(varInnerInt)
				.append(innerStr)
				.toHashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Inner)) {
			return false;
		}
		Inner inner = (Inner) obj;
		return new EqualsBuilder()
				.append(varInnerInt, inner.getVarInnerInt())
				.append(innerStr, inner.getInnerStr())
				.isEquals();
	}
	
}
