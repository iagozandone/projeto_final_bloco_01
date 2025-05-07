package model;

public class Camiseta extends Produto {
	
	private String estampa;

	public Camiseta(String nome, String tipo, int codigo, float preco, int quantidade, String tamanho, String estampa) {
		super(nome, tipo, codigo, preco, quantidade, tamanho);
		this.estampa = estampa;
	}

	public String getEstampa() {
		return estampa;
	}

	public void setEstampa(String estampa) {
		this.estampa = estampa;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Estampa: " + this.estampa);
	}

}
