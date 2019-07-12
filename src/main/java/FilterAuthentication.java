import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(
        filterName = "FilterAuthentication",
        urlPatterns = {"/login"},
        servletNames = {"login"}
)
public class FilterAuthentication implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String user=(String) req.getParameter("user");
        String password=(String) req.getParameter("password");
        User userLogin=new User(user,password);
        UserData urData=new UserData();

        if(urData.searchUser(userLogin)){
            chain.doFilter(req, resp);
        }else{
            RequestDispatcher rqDis=req.getRequestDispatcher("index.jsp");
            rqDis.forward(req,resp);
        }



    }

    public void init(FilterConfig config) throws ServletException {

    }

}
