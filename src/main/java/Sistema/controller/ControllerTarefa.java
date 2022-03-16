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
 * Servlet implementation class ControllerTarefa
 */
@WebServlet("/ControllerTarefa")
public class ControllerTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerTarefa() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Tarefa tarefa = new Tarefa();
		try {
			tarefa.setData(request.getParameter("data"));
			tarefa.setDescricao(request.getParameter("descricao"));
			tarefa.setPrioridade(request.getParameter("prioridade"));
			tarefa.setResponsavel(request.getParameter("responsavel"));
			tarefa.setSituacao(request.getParameter("situacao"));
			tarefa.setTitulo(request.getParameter("titulo"));
			System.out.println(tarefa.getData() + tarefa.getDescricao() + tarefa.getPrioridade()
					+ tarefa.getResponsavel() + tarefa.getSitucao() + tarefa.getTitulo());
			if (tarefa.getData() != null && tarefa.getDescricao() != null && tarefa.getPrioridade() != null
					&& tarefa.getResponsavel() != null && tarefa.getSitucao() != null && tarefa.getTitulo() != null) {
				System.out.println("Entrou no if");
				this.save(tarefa);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/Sistema/TarefaListJView.jsp");
	}

	/**
	 * @throws ClassNotFoundException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void save(Tarefa tarefa) throws SQLException, ClassNotFoundException {
		TarefaDao2.insert(tarefa);

		System.err.println("Tarefa criada: " + tarefa.getTitulo());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Tarefa tarefa = new Tarefa();
		try {

			tarefa.setData(request.getParameter("data"));
			tarefa.setDescricao(request.getParameter("descricao"));
			tarefa.setPrioridade(request.getParameter("prioridade"));
			tarefa.setResponsavel(request.getParameter("responsavel"));
			tarefa.setSituacao(request.getParameter("situacao"));
			tarefa.setTitulo(request.getParameter("titulo"));
			if (tarefa.getData() != null && tarefa.getDescricao() != null && tarefa.getPrioridade() != null
					&& tarefa.getResponsavel() != null && tarefa.getSitucao() != null && tarefa.getTitulo() != null) {
				this.save(tarefa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
