package myapp;

import java.io.IOException;
import javax.servlet.http.*;

public class MentorMatchServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("[ " +
                "{ " +
                "\"name\": \"Heidi\"," +
                "\"department\": \"Engineering\"," +
                "\"years at box\": \"1.5\"," +
                "\"mentoring interests\": \"management, work-life balance\"," +
                "\"personal interests\": \"soccer, reading\"," +
                "\"email\": \"heidi@box.com\"" +
                " }" +
                " ]");
    }
}
