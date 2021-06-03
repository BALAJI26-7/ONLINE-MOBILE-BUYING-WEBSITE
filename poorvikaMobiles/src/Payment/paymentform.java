package Payment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class paymentform
 */
@WebServlet("/paymentform")
public class paymentform extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public paymentform() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n=request.getParameter("name");
		String ad=request.getParameter("address");
		String cno=request.getParameter("cardno");
		String cv=request.getParameter("cvv");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/information","root","admin");
			Statement stmt=con.createStatement();
			String srt="insert into pay values('"+n+"','"+ad+"','"+cno+"','"+cv+"')";
			stmt.executeUpdate(srt);
			con.close();
			response.sendRedirect("order.jsp");
		}
		catch(Exception e) {
			System.out.println(e);
			doGet(request, response);
		}
	}

}
