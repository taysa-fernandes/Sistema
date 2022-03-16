package Sistema.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import Sistema.DAO.TarefaDao2;
import Sistema.entity.Tarefa;

public class Main {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		ControllerTarefa controller = new ControllerTarefa();

		controller.save(new Tarefa(9L, "teste3", "exec", "joão", "baixa", "12/05/2022", "em andamento"));
		Tarefa tarefa2 = new Tarefa();
		ArrayList<Tarefa> tarefas = (ArrayList) TarefaDao2.buscarTarefa(tarefa2);
		tarefas = (ArrayList) TarefaDao2.listTarefa();

		tarefa2.setId(6L);
		TarefaDao2.delete(tarefa2);

		for (Tarefa tarefa : tarefas) {
			System.out.println(tarefa.getId());
			System.out.println(tarefa.getTitulo());
			System.out.println(tarefa.getResponsavel());
		}

	}
}
