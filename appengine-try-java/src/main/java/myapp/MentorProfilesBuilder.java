package main.java.myapp;

import com.box.boxjavalibv2.*;
import com.box.boxjavalibv2.dao.*;
import com.box.boxjavalibv2.exceptions.*;
import com.box.restclientv2.exceptions.*;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.ArrayList;

/**
 * Created by hwilliams on 6/26/14.
 */
public class MentorProfilesBuilder {

    public static final int PORT = 8080;
    public static final String key = "zg2ju7ki20lsm0a6ekjmqy5vidg8llew";
    public static final String secret = "aL1t8jhD7DLqfGgdRj3ggUuBSVwcAgST";

    public String profiles = "";

    public MentorProfilesBuilder() throws AuthFatalFailureException, BoxServerException, BoxRestException {

        if (key.equals("YOUR API KEY HERE")) {
            System.out.println("Before this sample app will work, you will need to change the");
            System.out.println("'key' and 'secret' values in the source code.");
            return;
        }

        String code = "";
       /* String url = "https://www.box.com/api/oauth2/authorize?response_type=code&client_id=" + key;
        try {
            code = sendGet(url);
        } catch (IOException e) {
            e.printStackTrace();
        }*/


    /*    BoxClient client = getAuthenticatedClient(code);

        BoxFolder boxFolder= client.getFoldersManager().getFolder("0",null);
        ArrayList<BoxTypedObject> folderEntries = boxFolder.getItemCollection().getEntries();
        int folderSize = folderEntries.size();
        for (int i = 0; i <= folderSize-1; i++){
            BoxTypedObject folderEntry = folderEntries.get(i);
            String name = (folderEntry instanceof BoxItem) ? ((BoxItem)folderEntry).getName() : "(unknown)";
            System.out.println("i:" + i + ", Type:" + folderEntry.getType() + ", Id:" + folderEntry.getId() + ", Name:" + name);
        }*/

        String devToken="CnXnLPl7urOAJS3DN1oogUvFioAPjofY";

        String metadataURL1 = "https://api.box.com/2.0/files/18481853392/metadata/properties";
        String metadataURL2 = "https://api.box.com/2.0/files/18483098690/metadata/properties";
        String metadataURL3 = "https://api.box.com/2.0/files/18483108604/metadata/properties";
        String metadataURL4 = "https://api.box.com/2.0/files/18483108658/metadata/properties";
        String metadataProperties = "[";
        try {
            metadataProperties += sendGet(metadataURL1, devToken);
            metadataProperties += ", " + sendGet(metadataURL2, devToken);
            metadataProperties += ", " + sendGet(metadataURL3, devToken);
            metadataProperties += ", " + sendGet(metadataURL4, devToken);
            metadataProperties += "]";
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        profiles = metadataProperties;
    }

    private static BoxClient getAuthenticatedClient(String code) throws BoxRestException,     BoxServerException, AuthFatalFailureException {
        BoxClient client = new BoxClient(key, secret, null, null, null);
        BoxOAuthToken bt =  client.getOAuthManager().createOAuth(code, key, secret, "http://localhost:" + PORT);
        client.authenticate(bt);
        return client;
    }


    /*private static String getCode() throws IOException {

        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket socket = serverSocket.accept();
        BufferedReader in = new BufferedReader (new InputStreamReader (socket.getInputStream ()));
        while (true)
        {
            String code = "";
            try
            {
                BufferedWriter out = new BufferedWriter (new OutputStreamWriter (socket.getOutputStream ()));
                out.write("HTTP/1.1 200 OK\r\n");
                out.write("Content-Type: text/html\r\n");
                out.write("\r\n");

                code = in.readLine ();
                System.out.println (code);
                String match = "code";
                int loc = code.indexOf(match);

                if( loc >0 ) {
                    int httpstr = code.indexOf("HTTP")-1;
                    code = code.substring(code.indexOf(match), httpstr);
                    String parts[] = code.split("=");
                    code=parts[1];
                    out.write("Now return to command line to see the output of the HelloWorld sample app.");
                } else {
                    // It doesn't have a code
                    out.write("Code not found in the URL!");
                }

                out.close();

                return code;
            }
            catch (IOException e)
            {
                //error ("System: " + "Connection to server lost!");
                System.exit (1);
                break;
            }
        }
        return "";
    }*/

    private final String USER_AGENT = "Mozilla/5.0";

// HTTP GET request
	private String sendGet(String url, String token) throws Exception {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

        con.setRequestProperty("Authorization", "Bearer " + token);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
        String responseString = "";

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
            responseString += inputLine;
		}
		in.close();

		//print result
		System.out.println(response.toString());

        return responseString;

	}

	// HTTP POST request
	/*private void sendPost() throws Exception {

		String url = "https://selfsolve.apple.com/wcResults.do";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}*/

}