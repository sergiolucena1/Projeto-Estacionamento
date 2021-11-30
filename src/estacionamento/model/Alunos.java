package estacionamento.model;

import estacionamento.model.enums.Cursos;
import estacionamento.model.enums.TiposDePessoas;

public class Alunos extends Pessoas {

	private Integer matricula;
	private Cursos curso;
	
	public Alunos(String nome, String cpf, TiposDePessoas tipo, Integer matricula, Cursos curso) {
		super(nome, cpf, tipo);
		this.matricula = matricula;
		this.curso = curso;
	}
	
	public Alunos getAluno(Alunos aluno) {
		return aluno;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public Cursos getCurso() {
		return curso;
	}

	public void setCurso(Cursos curso) {
		this.curso = curso;
	}
	
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {	
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Matrícula: %-10s ,Curso: %-25s", matricula, curso));
		return super.toString() + sb.toString();
	}

}
