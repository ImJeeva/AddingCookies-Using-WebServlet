package Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/callingCooki")
public class CookieProgram extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		Cookie c = new Cookie(name,email); // creating Cookie object and stored the data.
		res.addCookie(c);
		PrintWriter out  = res.getWriter();
		out.print("Hey "+ name +" your Cookie is stored  successfully in your System. "
				+ "\nYou can see by clicking inspect then click application");
		
		Cookie [] arr =req.getCookies();
		for(Cookie cookie:arr) {
			System.out.println(cookie.getName()+" "+ cookie.getValue());
			
		}
		
	}

}
