package model;

import java.text.NumberFormat;

public abstract class Produto {
	
    //Atributos da Classe Produto
	private String nome;
	private String genero; 
	private int codigo;
	private float preco;
	private int quantidade;
	private String tamanho;
	
	
    //Metodo construtor
	public Produto(String nome, String genero, int codigo, float preco, int quantidade, String tamanho) {
		this.nome = nome;
		this.genero = genero;
		this.codigo = codigo;
		this.preco = preco;
		this.quantidade = quantidade;
		this.tamanho = tamanho;
	}

    //Métodos Get e Set
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public float getPreco() {
		return preco;
	}



	public void setPreco(float preco) {
		if (preco > 0) {
			this.preco = preco;
		}else{
			System.out.println("Preço deve ser maior que zero");
	}
}


	public int getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



	public String getTamanho() {
		return tamanho;
	}



	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}



	public void visualizar (){
	   NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
	   System.out.println("\nNome: " + this.nome);
	   System.out.println("genero: " + this.genero);
	   System.out.println("Codigo: " + this.codigo);
	   System.out.println("Tamanho: " + this.tamanho);
	   System.out.println("Quantidade: " + this.quantidade);
	   System.out.println("Preço: " + nfMoeda.format(this.preco));
	}
}
