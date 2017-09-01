package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat extends SimpleDateFormat {
	private static final long serialVersionUID = 2371168145105228746L;

	private String[] patterns = new String[] { "yyyyMMdd", "yyyy-MM-dd HH:mm", "HH:mm", "yyyy-MM-dd" };

	public Date parse(String source) throws ParseException {
		try {
			if (source == null)
				source = "";
			if (toPattern().length() == source.length())
				return super.parse(source);
			for (int i = 0; i < patterns.length; i++) {
				if (patterns[i].length() == source.length()) {
					applyPattern(patterns[i]);
					return super.parse(source);
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public DateFormat() {
		super();
	}

	public DateFormat(String pattern) {
		super(pattern);
	}
}
