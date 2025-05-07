package repository;

import model.Produto;

public interface ProdutoRepository {
	
	public Produto procurarPorCodigo(int codigo);
	public void listarTodos();
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int codigo);
	public void venderProduto(int codigo, int quantidade);
}
