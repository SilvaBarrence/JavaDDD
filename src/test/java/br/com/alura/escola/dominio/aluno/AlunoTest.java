package br.com.alura.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoTest {

	private Aluno aluno;

	@BeforeEach
	void before() {
		this.aluno = new Aluno(new CPF("000.000.000-00"), "fulano de tal", new Email("fulano@email.com"));
	}

	@Test
	void realizarCadastroDeUmTelefone() {
		aluno.adicionarTelefone("11", "12345689");
		assertNotNull(aluno.getTelefones());
	}

	@Test
	void realizarCadastroDeDoisTelefone() {
		aluno.adicionarTelefone("11", "12345689");
		aluno.adicionarTelefone("11", "12345612");
		assertNotNull(aluno.getTelefones().get(1));
	}

	@Test
	void realizarCadastroDeTresTelefone() {
		assertThrows(IllegalArgumentException.class, () -> {
			aluno.adicionarTelefone("11", "12345689");
			aluno.adicionarTelefone("11", "12345123");
			aluno.adicionarTelefone("11", "12345345");
		});

	}
}
