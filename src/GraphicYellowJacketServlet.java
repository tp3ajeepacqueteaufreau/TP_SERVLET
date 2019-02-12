

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GraphicYellowJacketServlet
 */
@WebServlet("/YellowJacketGraphic")
public class GraphicYellowJacketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	enum Pays {France, Pologone, Allemagne};

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GraphicYellowJacketServlet() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		
		String paysString = request.getParameter("list");
		Pays pays = null;
		
		if(paysString != null)
		for(Pays p : Pays.values())
		{
			if(p.name().equals(paysString))
			{
				pays = Pays.valueOf(paysString);
				break;
			}
		}
		
		
		this.drawImage(pays, response.getOutputStream());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void drawImage(Pays p, ServletOutputStream servletOutputStream) {
		BufferedImage img = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();
		Color c = Color.black;
		
		if(p != null)
			switch (p) {
			case Allemagne:
					c = Color.red;
				break;
			case France:
					c = Color.blue;
				break;
			case Pologone:
					c = Color.green;
				break;
				
			}
		
		g2d.setColor(c);
		g2d.fill(new Ellipse2D.Float(0,0,200,100));
		
		g2d.dispose();
		try {
			ImageIO.write(img, "jpg", servletOutputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
