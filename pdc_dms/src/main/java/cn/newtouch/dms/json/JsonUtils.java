package cn.newtouch.dms.json;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtils {
	
	/** logger. */
	private static final Log logger = LogFactory.getLog(JsonUtils.class);
	
	/** objectMapper. */
	private static ObjectMapper objectMapper = null;
	
	static {
		initializeObjectMapper();
	}
	
	private static void initializeObjectMapper() {
		objectMapper = new ObjectMapper();
		// 增加json缩进，提高视觉上的可读性
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		// 配置mapper忽略空属性
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);
	}
	
	public static String writeObject(Object value) {
		try {
			return objectMapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			logger.error("将[" + value + "]转换成JSON时发生错误。\n" + e.getMessage());
			return null;
		}
	}
	
	public static <T> T readObject(String jsonStr, Class<T> clazz) {
		try {
			return objectMapper.readValue(jsonStr, clazz);
		} catch (IOException e) {
			logger.error("读取对象[" + clazz + "]时发生错误！\n" + e.getMessage());
		}
		return null;
	}
	
	public static <T> List<T> readList(String jsonStr, Class<T> clazz) {
		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, clazz);
		try {
			return objectMapper.readValue(jsonStr, javaType);
		} catch (IOException e) {
			logger.error("读取对象[" + clazz + "]时发生错误！\n" + e.getMessage());
		}
		return null;
	}
}
