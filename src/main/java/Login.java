import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.HttpCookie;


public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String testSession="not new";
        HttpSession session=request.getSession();
        String userName=request.getParameter("user");
        String rememberMe=request.getParameter("rememberMe");



        if(rememberMe!=null){
            Cookie usrName=new Cookie("userName",userName);
            usrName.setMaxAge(43200*60);
            response.addCookie(usrName);

            Cookie remMe=new Cookie("rememberMe",rememberMe);
            remMe.setMaxAge(43200*60);
            response.addCookie(remMe);

        }else{
            Cookie[] cok=request.getCookies();
            for(Cookie c: cok){
                if(c.getName().equals("userName") || c.getName().equals("rememberMe")){
                    c.setMaxAge(-1);
                    response.addCookie(c);
                }


            }
        }


        request.getSession().setAttribute("logout","0");
        String htmlText="<div><a href='http://localhost:8086/wapServlet2_war_exploded/login'>Logout....</a></div>";

        response.getWriter().println(htmlText);





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("logout").equals("0")) {
            HttpSession session=request.getSession();
            if(session.isNew()==false){
                session.invalidate();
            }
        }
        response.sendRedirect("index.jsp");



    }
}
