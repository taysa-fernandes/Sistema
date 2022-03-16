<%@page import="java.util.ArrayList"%>
<%@page import="Sistema.DAO.TarefaDao2"%>
<%@page import="Sistema.entity.Tarefa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
ArrayList<Tarefa> tarefas = (ArrayList) TarefaDao2.listTarefa();
pageContext.setAttribute("tarefas", tarefas);

try {
	if (request.getParameter("buscar") != null) {
		Tarefa tarefa = new Tarefa();
		if (request.getParameter("numero").equals("")) {
	tarefa.setId(0L);
		} else {
	tarefa.setId(Long.parseLong(request.getParameter("numero")));
		}

		tarefa.setTitulo(request.getParameter("titulo"));
		tarefa.setResponsavel(request.getParameter("responsavel"));
		tarefas = (ArrayList) TarefaDao2.buscarTarefa(tarefa);
		pageContext.setAttribute("tarefas", tarefas);
	}
} catch (Exception ex) {
	ex.printStackTrace();
}
%>


<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="styles.css" />
<title>Listagem de Tarefas</title>
</head>
<body>
	<div class="cadastrar">
		<ui:define name="title">
		Listagem de tarefas
		</ui:define>
	</div>

	<form action="#" method="get">
		<h3>Número:</h3>
		<input type="number" name="numero" value="" /> <br></br>

		<h3>Título/Descrição:</h3>
		<input type="text" name="titulo" value="" /><br></br>

		<h3>Responsável:</h3>
		<select onchange="this.nextElementSibling.value=this.value"
			name="responsavel" value="">
			<option value=""></option>
			<option value="João">João</option>
			<option value="Antônio">Antônio</option>
		</select>

		<h3>situação:</h3>
		<select onchange="this.nextElementSibling.value=this.value"
			name="situacao" />
		<option value="Em andamento">Em andamento</option>
		</select>
		<form action="#" method="get">
			<input type="submit" value="Buscar tarefas" name="buscar" />
		</form>
		<form action="/Sistema/ControllerTarefaDelete">
			<table class="tabela">
				<thead>
					<tr>
						<th>Número</th>
						<th>Título</th>
						<th>Responsável</th>
						<th>Ações</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${tarefas}" var="tarefa">
						<tr>
							<td><c:out value="${tarefa.id}" /></td>
							<td><c:out value="${tarefa.titulo}" /></td>
							<td><c:out value="${tarefa.responsavel}" /></td>
							<td>
								<button id="editar" name="editar" value="${tarefa.id}">Editar</button>
								|
								<button id="excluir" name="excluir" value="${tarefa.id}">Excluir</button>
								|
								<button type="submit" id="concluir" name="concluir"
									value="${tarefa.id}">Concluir</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
</body>
</html>
