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
 * Servlet implementation class updateDB
 */
@WebServlet("/updateDB")
public class updateDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateDB() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		GameInfo updateDB = new GameInfo();

		updateDB.setGameLevel(request.getParameter("gameLevel"));
		updateDB.setGameLocation(request.getParameter("gameLocation"));
		updateDB.setDate(request.getParameter("date"));
		updateDB.setTime(request.getParameter("time"));
		updateDB.setHomeTeam(request.getParameter("homeTeam"));
		updateDB.setAwayTeam(request.getParameter("awayTeam"));
		updateDB.setHomeTeamScore(request.getParameter("homeTeamScore"));
		updateDB.setAwayTeamScore(request.getParameter("awayTeamScore"));
		updateDB.setGameWinner(request.getParameter("gameWinner"));

		updateDB.setGameNumber(request.getParameter("gameNumber"));
		
		DAO.updateDB(updateDB);

		request.getRequestDispatcher("index.html").forward(request, response);

	}

}
