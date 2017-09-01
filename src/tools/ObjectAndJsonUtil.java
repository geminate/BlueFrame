package tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class ObjectAndJsonUtil {
	/**
	 * 实体Bean 转 Json 字符串
	 * @param obj 要传入的泛型对象
	 * @return Json 字符串
	 */
	public static <T> String beanToJson(T bean) {
		JSONObject json = JSONObject.fromObject(bean);
		return json.toString();
	}

	/**
	 * Json 字符串转 实体Bean
	 * @param jsonString 要转换的Json字符串
	 * @param beanClass 要转换成的对象的Bean类
	 * @return 转换后的bean对象
	 */
	public static Object jsonToBean(String jsonString, Class<?> beanClass) {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		Object bean = JSONObject.toBean(jsonObject, beanClass);
		return bean;
	}

	/**
	 * List 转Json字符串
	 * @param list
	 * @return 转换后的Json字符串
	 */
	public static <T> String listToJson(List<T> list) {
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
	}

	/**
	 * Json 字符串转 List<?>
	 * @param jsonString 要转换的Json字符串
	 * @param arg List里面泛型的实例：例如要转成List&lt;Person&gt;,此处就填写new Person()
	 * @return 转换后的List
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> jsonToList(String jsonString, Object arg) {
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		List<T> list = JSONArray.toList(jsonArray, arg, new JsonConfig());
		return list;
	}

	/**
	 * 将对象序列化为 Byte[]
	 * @param obj 要序列化的对象，要求实现Serializable接口
	 * @return 序列化后的Byte[]
	 * @see 序列化失败返回Null
	 */
	public static byte[] objectToSerializable(Object obj) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 将序列化的 byte[]转为对象
	 * @param serializable 序列化的 byte[]
	 * @return 转换后的对象
	 */
	public static Object serializableToObject(byte[] serializable) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(serializable));
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {

	}
}
