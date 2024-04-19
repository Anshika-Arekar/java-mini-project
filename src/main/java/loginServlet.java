

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import net.Read_Ace.hibernate.dao.UserDao;
import net.Read_Ace.hibernate.model.User;
import net.Read_Ace.hibernate.util.HibernateUtil;
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginServlet() {
		super();
	}
	UserDao loginDao = new UserDao();
   public void service(HttpServletRequest req, HttpServletResponse res) {
	   String username = req.getParameter("username");
       String password = req.getParameter("password");

       if (loginDao.validate(username, password)) {
           RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
           try {
			dispatcher.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		} 
   }
}
}