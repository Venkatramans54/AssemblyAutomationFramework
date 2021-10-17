package utilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import frameworkConstants.FrameworkConstants;

public final class JSONUtils {

	public static Map<String, String> readJSONData(String fileName) throws Exception {
		Map<String, String> testDetails = new HashMap<>();
		String filePath = FrameworkConstants.getJsonPath() + fileName+".json";
		try {
			testDetails = new ObjectMapper().readValue(new File(filePath),
					new TypeReference<HashMap<String, String>>() {
					});
		} catch (Exception e) {
			throw new Exception("Unable to Read Data from JSON File. "+e.getMessage());
		}

		return testDetails;
	}

}
