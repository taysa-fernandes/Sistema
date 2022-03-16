package Sistema.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Sistema.DAO.TarefaDao2;
import Sistema.entity.Tarefa;

/**
 * Servlet implementation class ControllerTarefaDelete
 */
@WebServlet("/ControllerTarefaDelete")
public class ControllerTarefaDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Tarefa tarefa = new Tarefa();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerTarefaDelete() {
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
		try {
			tarefa.setId(Long.parseLong(request.getParameter("concluir")));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (this.tarefa.getId() != null) {
			try {
				TarefaDao2.delete(tarefa);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect("/Sistema/TarefaListJView.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
