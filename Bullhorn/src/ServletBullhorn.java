

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bullhorn;
import customTools.DBUtil;

/**
 * Servlet implementation class ServletBullhorn
 */
@WebServlet("/ServletBullhorn")
public class ServletBullhorn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBullhorn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String trig=(String) request.getAttribute("trig");
		String message="";
		if(trig==null){
		 message = "<form action='ServletBullhorn' method='post' style=text-align:center><label style=font-size:20px>Comments:</label><br></br>"
				+ "	<textarea rows='4' cols='50' name='post' style=text-align:center></textarea><br></br><br>"
				+ "<input type='submit' value='Submit'></input></form></div>";
		 	request.setAttribute("input", message);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String post = request.getParameter("post");
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		model.Bullhorn postObj = new model.Bullhorn();
		//model.Bullhorn postObj2 = em.find(model.Bullhorn.class, (long)1);
		System.out.println(post);
		postObj.setPost(post);
		Database.insert(postObj);
		List<Bullhorn> blogList = Database.getAllPost();
		
		String tableData ="";
		try {
			tableData="\r<table border=1 align=center>";
			tableData += "<tr>";
			tableData += "<thead text-align=center>";
			tableData += "<th>";
			tableData += "ID";
			tableData += "</th>";
			tableData += "<th>";
			tableData += "Post";
			tableData += "</th>";
			tableData += "</thead>";
			tableData += "</tr>\r";
			
	
			for(Bullhorn b : blogList){
				tableData += "<tr>";				
				tableData += "<td>";
				tableData +=b.getPostId();
				tableData += "</td>";
				tableData += "<td>";
				tableData +=b.getPost();
				tableData += "</td>";
				tableData+="</tr>\r";
			}
			tableData+="</table>\r";			
			
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
			System.out.println("Done!");
		}
		
		tableData +="<br><br><a href= 'ServletBullhorn' class='btn btn-primary'>Go Back</a>";
		request.setAttribute("message", tableData);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		
	}

}
