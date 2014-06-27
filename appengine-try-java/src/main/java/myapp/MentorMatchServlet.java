package myapp;

import javax.servlet.http.*;
import java.io.IOException;

import com.box.boxjavalibv2.exceptions.AuthFatalFailureException;
import com.box.boxjavalibv2.exceptions.BoxServerException;
import com.box.restclientv2.exceptions.BoxRestException;
import main.java.myapp.MentorProfilesBuilder;


public class MentorMatchServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println(getProfiles());
    }

    private String getTestProfiles()
    {
        return "[ " +
                        "{ " +
                        "\"department\": \"Engineering\", " +
                        "\"gender\": \"Female\", " +
                        "\"mentees\": \"2\", " +
                        "\"office\": \"SF\", " +
                        "\"years experience\": \"1.5\", " +
                        "\"personal interests\": \"soccer, reading\", " +
                        "\"mentoring strengths\": \"management, work-life balance\", " +
                        "\"management style\": \"benevolent dictator?\", " +
                        "\"career challenges\": \"going into mgmt, taking risks, bad managers\", " +
                        "\"professional interests\": \"leadership, organizational health and effectiveness\", " +
                        "\"email address\": \"heidi@box.com\", " +
                        "\"name\": \"Barbara\" " +
                        " }" +
                        " ]";
    }

    private String getProfiles()
    {
        try {
            MentorProfilesBuilder profilesBuilder = new MentorProfilesBuilder();
            return profilesBuilder.profiles;
        } catch (BoxServerException e) {
            e.printStackTrace();
        } catch (BoxRestException e) {
            e.printStackTrace();
        } catch (AuthFatalFailureException e) {
            e.printStackTrace();
        }

        return "";
    }
}
