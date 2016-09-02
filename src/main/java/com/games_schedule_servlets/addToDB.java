package com.games_schedule_servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.games_schedule.DAO;
import com.games_schedule.GameInfo;

/**
 * Servlet implementation class addToDB
 */
@WebServlet("/addToDB")
public class addToDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToDB() {
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

		GameInfo addToDB = new GameInfo();
		
		addToDB.setGameLevel(request.getParameter("gameLevel"));
		addToDB.setGameLocation(request.getParameter("gameLocation"));
		addToDB.setDate(request.getParameter("date"));
		addToDB.setTime(request.getParameter("time"));
		addToDB.setHomeTeam(request.getParameter("homeTeam"));
		addToDB.setAwayTeam(request.getParameter("awayTeam"));
		addToDB.setHomeTeamScore(request.getParameter("homeTeamScore"));
		addToDB.setAwayTeamScore(request.getParameter("awayTeamScore"));
		addToDB.setGameWinner(request.getParameter("gameWinner"));
		
		DAO.insertToDB(addToDB);
		
		request.getRequestDispatcher("index.html").forward(request, response);
		
	}//doPost

}//class
