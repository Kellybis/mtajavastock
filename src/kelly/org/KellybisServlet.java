package kelly.org;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class KellybisServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		//1
		int r=50;
		double pi =3.1415;
		double area =pi*r*r;
		String line1= new String("Calculation 1: Area of circle with radius "+r+" is " +area+"square-cm.");
		
		
		
		
		//2
		int angleB=30;
		int hyp=50;
		double radians= Math.toRadians(angleB);
		double opp=radians*hyp;
		
		
		String line2= new String("Claculation 2: Lenght of opposite where angle B is 30 degrees ans hyppotenuse lenght is 50 cm is : " +opp);
		
		//3
		int base=20;
		int exp=13;
		int result=1;
		
		for(int i=0;i<exp;i++)
		{
			result= result*base;
		}
		String line3= new String("Claculation 3: Power of 20 with exp of 13 is : " +result );
		
		String resultStr = line1 + "<br>" + line2 + "<br>" +line3;
		resp.getWriter().println(resultStr);
		

		

		
	}
}
