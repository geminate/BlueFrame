package tools;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public class Ognl {

	public static boolean isEmpty(Object o) throws IllegalArgumentException {
		if (o == null)
			return true;
		if (o instanceof String) {
			return StringUtils.isEmpty((String) o);
		} else if (o instanceof Collection) {
			return CollectionUtils.isEmpty((Collection<?>) o);
		} else if (o.getClass().isArray()) {
			return ArrayUtils.isEmpty((Object[]) o);
		} else if (o instanceof Map) {
			MapUtils.isEmpty((Map<?, ?>) o);
		} else if (o instanceof Date) {
			return o == null;
		} else if (o instanceof Number) {
			return o == null;
		} else if (o instanceof Boolean) {
			return o == null;
		} else {
			throw new IllegalArgumentException("Illegal argument type,must be : Map,Collection,Array,String. but was:" + o.getClass());
		}
		return false;
	}

	public static boolean isNotEmpty(Object o) {
		return !isEmpty(o);
	}
}
