package utilities;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

	@DataProvider(name = "FormDetails")
	public static Object[][] getFormDetails(Method method) throws Exception {
		Map<String, String> data = JSONUtils.readJSONData(method.getName());

		return new Object[][] { { data } };
	}

}
