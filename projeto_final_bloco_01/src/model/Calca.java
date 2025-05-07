package model;

public class Calca extends Produto {
	
	private String tecido;
	
	public Calca(String nome, String tipo, int codigo, float preco, int quantidade, String tamanho, String tecido) {
		super(nome, tipo, codigo, preco, quantidade, tamanho);
		this.tecido = tecido;
	}

	public String getTecido() {
		return tecido;
	}

	public void setTecido(String tecido) {
		this.tecido = tecido;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Tecido: " + this.tecido);
	}
}
