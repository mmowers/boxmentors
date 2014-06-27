import com.box.boxjavalibv2.*;
import com.box.boxjavalibv2.dao.*;
import com.box.boxjavalibv2.exceptions.*;
import com.box.boxjavalibv2.jsonparsing.BoxJSONParser;
import com.box.boxjavalibv2.jsonparsing.BoxResourceHub;
import com.box.boxjavalibv2.requests.requestobjects.*;
import com.box.restclientv2.exceptions.*;
import com.box.restclientv2.requestsbase.BoxOAuthRequestObject;

import java.io.*;
import java.awt.Desktop;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class HelloWorld {

    public static final int PORT = 4000;
    public static final String key = "YOUR API KEY HERE";
    public static final String secret = "YOUR OAUTH2 SECRET HERE";

    public static void main(String[] args) throws AuthFatalFailureException, BoxServerException, BoxRestException {

        if (key.startsWith("YOUR")) {
            System.out.println("Before this sample app will work, you will need to change the");
            System.out.println("'key' and 'secret' values in the source code.");
            return;
        }

        String code = "";
        String url = "https://www.box.com/api/oauth2/authorize?response_type=code&client_id=" + key + "&redirect_uri=http%3A//localhost%3A" + PORT;
        try {
            Desktop.getDesktop().browse(java.net.URI.create(url));
            code = getCode();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BoxClient client = getAuthenticatedClient(code);

        BoxFolder boxFolder= client.getFoldersManager().getFolder("0",null);
        ArrayList<BoxTypedObject> folderEntries = boxFolder.getItemCollection().getEntries();
        int folderSize = folderEntries.size();
        for (int i = 0; i <= folderSize-1; i++){
            BoxTypedObject folderEntry = folderEntries.get(i);
            String name = (folderEntry instanceof BoxItem) ? ((BoxItem)folderEntry).getName() : "(unknown)";
            System.out.println("i:" + i + ", Type:" + folderEntry.getType() + ", Id:" + folderEntry.getId() + ", Name:" + name);
        }
    }

    private static BoxClient getAuthenticatedClient(String code) throws BoxRestException,     BoxServerException, AuthFatalFailureException {
        BoxResourceHub hub = new BoxResourceHub();
        BoxJSONParser parser = new BoxJSONParser(hub);
        IBoxConfig config = (new BoxConfigBuilder()).build();
        BoxClient client = new BoxClient(key, secret, hub, parser, config);
        BoxOAuthToken bt = client.getOAuthManager().createOAuth(code, key, secret, "http://localhost:" + PORT);
        client.authenticate(bt);
        return client;
    }


    private static String getCode() throws IOException {

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
    }

}
