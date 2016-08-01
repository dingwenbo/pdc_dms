package cn.newtouch.dms.json;

import java.io.OutputStream;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	private static OutputStream os = null;
	private static JsonGenerator jsonGenerator = null;
	private static ObjectMapper objectMapper = null;
	
	static {
		objectMapper = new ObjectMapper();
	}
	
	public String writeObject(Object value) {
		//TODO:
		return "";
	}
}
