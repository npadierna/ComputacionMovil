package co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

abstract class AbstractContextWS {

	private static final String TAG = AbstractContextWS.class.getSimpleName();

	private static final String AMPERSAND = "&";
	private static final String SLASH = "/";
	private static final String EQUAL = "=";

	public static final String CONTENT_TYPE_KEY = "content-type";
	public static final String CONTENT_TYPE_VALUE = "application/json";

	private Context context;
	private SharedPreferences sharedPreferences;

	public AbstractContextWS(Context context) {
		super();

		this.context = context;
		this.sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(this.context);
	}

	private String buildQueriesForPath(Map<String, String> parameters) {
		if ((parameters != null) && (!parameters.isEmpty())) {
			StringBuilder stringForQueries = new StringBuilder();
			Set<String> keySet = parameters.keySet();
			int counter = parameters.size();

			for (String key : keySet) {
				stringForQueries.append(key).append(EQUAL)
						.append(parameters.get(key));
				counter--;

				if (counter >= 1) {
					stringForQueries.append(AMPERSAND);
				}
			}

			return (stringForQueries.toString());
		}

		return (null);
	}

	private URI buildURIForHTTPMethod(String[] paths,
			Map<String, String> parameters) throws URISyntaxException {
		StringBuilder stringForPaths = new StringBuilder();

		if ((paths != null) && (paths.length != 0)) {
			for (String s : paths) {
				stringForPaths.append(s);
			}
		}

		Log.d(TAG, String.format("Total Paths: %s", stringForPaths.toString()));

		String httpProcol = this.sharedPreferences.getString("httpProtocol",
				null);
		String serverIP = this.sharedPreferences.getString("serverIP", null);
		String serverPort = this.sharedPreferences
				.getString("serverPort", null);
		String webApplicatonContext = this.sharedPreferences.getString(
				"webApplicatonContext", null);
		String webServiceContext = this.sharedPreferences.getString(
				"webServiceContext", null);

		URI uri = new URI(httpProcol, "", serverIP,
				Integer.parseInt(serverPort),
				SLASH + webApplicatonContext + SLASH + webServiceContext
						+ stringForPaths.toString(),
				this.buildQueriesForPath(parameters), null);

		Log.d(TAG, "URI Content: " + uri.toString());

		return (uri);
	}

	protected HttpEntity executeHTTPMethod(String[] paths,
			Map<String, String> parameters, HttpRequestBase httpRequestBase)
			throws URISyntaxException, ClientProtocolException, IOException {
		HttpClient httpClient = new DefaultHttpClient();

		httpRequestBase.setURI(this.buildURIForHTTPMethod(paths, parameters));
		httpRequestBase.setHeader(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);

		return (httpClient.execute(httpRequestBase).getEntity());
	}

	protected String formatToJSONArrayString(String jsonArray) {
		StringBuilder newFormatToArray = new StringBuilder(jsonArray);

		int indexOf = jsonArray.indexOf(":[");
		newFormatToArray.delete(0, (indexOf + 1));
		newFormatToArray.deleteCharAt(newFormatToArray.length() - 1);

		return (newFormatToArray.toString());
	}
}