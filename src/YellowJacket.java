

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class YellowJacket
 */
@WebServlet("/YellowJacket")
public class YellowJacket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	enum Pays {France, Pologone, Allemagne};
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YellowJacket() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<html>");
		this.printPage(response.getWriter());
		
		Pays p = (request.getParameter("list")==null)?null:Pays.valueOf(request.getParameter("list"));
		
		if(p != null)
		{
			this.printNbYellowJacket(p, response.getWriter());
		}
		response.getWriter().append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void printPage(PrintWriter print) {
		print.append("<form ><select name=\"list\" >\n");
		for(Pays p : Pays.values())
		{
			print.append("<option>").append(p.name()).append("</option>");
		}
		print.append("</select><input type=\"submit\" value=\"Valider!\"></form>");
	}
	
	private void printNbYellowJacket(Pays p, PrintWriter print)
	{
		for(int i = 0 ; i < 10 ; i++)
			print.append("<br>");
		
		print.append(p.name());
		int tmp = (new Random()).nextInt();
		print.append(": ").append(String.valueOf((tmp<0)?tmp*(-1):tmp));
	}

}
