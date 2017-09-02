import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class ConsumeService {

	public static void main(String[] args) throws IOException {
		try {

			HttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost("http://ibm.biz/api/shorten");
			
			StringEntity input = new StringEntity("api_key=e7950e6426d42f43dc38652a82e688ba&url=https://prdrdmamp01.w3-969.ibm.com/mamportal/app/info");
			input.setContentType("application/x-www-form-urlencoded");
			postRequest.setEntity(input);
			
			// Request parameters and other properties.
			/*List params = new ArrayList(2);
			params.add(new BasicNameValuePair("api_key", "e7950e6426d42f43dc38652a82e688ba"));
			params.add(new BasicNameValuePair("url", "https://prdrdmamp01.w3-969.ibm.com/mamportal/app/info"));
			postRequest.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
*/
			
			HttpResponse response = httpClient.execute(postRequest);

			
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(
	                        new InputStreamReader((response.getEntity().getContent())));
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			
			}

			httpClient.getConnectionManager().shutdown();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
			/*String urlParameters  = "api_key=e7950e6426d42f43dc38652a82e688ba&url=https://prdrdmamp01.w3-969.ibm.com/mamportal/app/info";
			byte[] postData = urlParameters.getBytes( StandardCharsets.UTF_8 );
			int postDataLength = postData.length;
			String request = "http://ibm.biz/api/shorten";
			URL url = new URL( request );
			HttpURLConnection conn= (HttpURLConnection) url.openConnection();           
			conn.setDoOutput(true);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
			conn.setRequestProperty("charset", "utf-8");
			conn.setRequestProperty("Content-Length", Integer.toString(postDataLength ));
			conn.setUseCaches(false);
			try(DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
				wr.write( postData );
				System.out.println(postData);
			}
			finally{
				
			}

		}
		finally{
			
		}*/
		

	}
	}
