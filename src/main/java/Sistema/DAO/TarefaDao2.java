package Sistema.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Sistema.config.ConnectionFactory;
import Sistema.entity.Tarefa;

public class TarefaDao2 {
	public static int insert(Tarefa tarefa) throws SQLException, ClassNotFoundException {
		int idTarefa = -1;
		Connection connection = (Connection) ConnectionFactory.conexao();
		ResultSet rs = null;
		String sql = "INSERT INTO tarefa(\r\n"
				+ "	\"Data\", \"Titulo\", \"Descricao\", \"Responsavel\", \"Prioridade\", \"Situacao\")\r\n"
				+ "	VALUES (?, ?, ?, ?, ?, ?);";
		PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ps.setString(1, tarefa.getData());
		ps.setString(2, tarefa.getTitulo());
		ps.setString(3, tarefa.getDescricao());
		ps.setString(4, tarefa.getResponsavel());
		ps.setString(5, tarefa.getPrioridade());
		ps.setString(6, tarefa.getSitucao());

		int i = ps.executeUpdate();

		rs = ps.getGeneratedKeys();

		if (rs.next()) {
			idTarefa = rs.getInt(1);
		}

		return idTarefa;

	}

	public static List<Tarefa> listTarefa() throws ClassNotFoundException, SQLException {

		List<Tarefa> tarefas = new ArrayList<>();
		Connection connection = ConnectionFactory.conexao();
		Tarefa tarefa;

		String sql = "SELECT * FROM Tarefa";

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = null;

			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setTitulo(rs.getString("titulo"));
				tarefa.setResponsavel(rs.getString("responsavel"));
				;

				tarefas.add(tarefa);

			}

		} catch (SQLException ex) {
			System.err.println("Erro ao listar");
			ex.printStackTrace();
		}
		return tarefas;
	}

	public static int delete(Tarefa tarefa) throws SQLException, ClassNotFoundException {
		int idTarefa = -1;
		Connection connection = (Connection) ConnectionFactory.conexao();
		ResultSet rs = null;
		String sql = "DELETE FROM tarefa\r\n" + "	WHERE id=?;";
		PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ps.setLong(1, tarefa.getId());

		int i = ps.executeUpdate();
		return i;
	}

	public static List<Tarefa> buscarTarefa(Tarefa tarefa) throws ClassNotFoundException, SQLException {

		List<Tarefa> tarefas = new ArrayList<>();
		Connection connection = ConnectionFactory.conexao();

		String sql = "SELECT id, \"Titulo\", \"Descricao\", \"Responsavel\", \"Prioridade\", \"Situacao\", \"Data\"\r\n"
				+ "	FROM tarefa WHERE id=? or \"Titulo\" =? or \"Responsavel\"=?;";

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = null;
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setLong(1, tarefa.getId());
			ps.setString(2, tarefa.getTitulo());
			ps.setString(3, tarefa.getResponsavel());

			rs = ps.executeQuery();

			while (rs.next()) {
				tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setTitulo(rs.getString("titulo"));
				tarefa.setResponsavel(rs.getString("responsavel"));
				;

				tarefas.add(tarefa);

			}

		} catch (SQLException ex) {
			System.err.println("Erro ao listar");
			ex.printStackTrace();
		}
		return tarefas;
	}

}
