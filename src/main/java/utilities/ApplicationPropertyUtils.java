package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import frameworkConstants.FrameworkConstants;
import frameworkEnums.ConfigProperties;

public final class ApplicationPropertyUtils {
	
	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();
	
	static {
		try(FileInputStream file = new FileInputStream(FrameworkConstants.getConfigfilepath())) {
			property.load(file);
			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()).toLowerCase(), String.valueOf(entry.getValue()).trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		} 
	}
	
	public static String get(ConfigProperties key)  {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new RuntimeException("Property name is not Valid.");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
