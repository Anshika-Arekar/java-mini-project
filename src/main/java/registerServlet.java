
import net.Read_Ace.hibernate.dao.UserDao;
import net.Read_Ace.hibernate.model.User;

import java.io.IOException;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class registerServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    String username, password, email;
    public registerServlet() {
        super();
    }

	public void service(HttpServletRequest req, HttpServletResponse res) {
		username = req.getParameter("username");
		password = req.getParameter("password");
		email = req.getParameter("email");
		UserDao udao = new UserDao();
		User user = new User(username, password, email);
		udao.saveUser(user);
		try { res.sendRedirect("Login.jsp"); }
		catch (Exception e) { System.out.println(e); }
	}

}
