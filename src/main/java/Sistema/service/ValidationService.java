package Sistema.service;

import java.util.Date;

public class ValidationService {
	public boolean validateTitulo(String titulo) {
		if (titulo != null && !titulo.trim().isEmpty() && !titulo.contains("1")) {
			return true;
		}

		return false;
	}

	public boolean validateDescricao(String descricao) {
		if (descricao != null && !descricao.trim().isEmpty()) {
			return true;
		}

		return false;
	}

	public boolean validateResponsavel(String responsavel) {
		if (responsavel != null && !responsavel.trim().isEmpty() && responsavel.contains("1")) {
			return true;
		}

		return false;
	}

	public boolean validatePrioridade(String responsavel) {
		if (responsavel != null && !responsavel.trim().isEmpty()
				&& (responsavel == "alta" || responsavel == "média" || responsavel == "baixa")) {
			return true;
		}

		return false;
	}

	public boolean validateData(Date data) {
		if (data != null) {
			return true;
		}

		return false;
	}
}
