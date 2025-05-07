package controller;

import java.util.ArrayList;
import java.util.Optional;

import model.Produto;
import repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {
    
    private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

    int codigo = 100;

    public void venderProduto(int codigo, int quantidade) {
        Optional<Produto> produto = buscarNaCollection(codigo);

        if (produto.isPresent()) {
            Produto vendaProduto = produto.get();

            if (vendaProduto.getQuantidade() >= quantidade) {

                vendaProduto.setQuantidade(vendaProduto.getQuantidade() - quantidade);
                System.out.println("\nVenda realizada com sucesso!");
                System.out.println("Produto: " + vendaProduto.getNome());
                System.out.println("Quantidade vendida: " + quantidade);
                System.out.println("Quantidade restante: " + vendaProduto.getQuantidade());
            } else {
                System.out.println("\nQuantidade insuficiente no estoque!");
            }
        } else {
            System.out.println("\nProduto com código " + codigo + " não encontrado!");
        }
    }

    @Override
    public Produto procurarPorCodigo(int codigo) {
        Optional<Produto> produto = buscarNaCollection(codigo);
        
        if (produto.isPresent()) {
            return produto.get(); 
        } else {
            return null;
        }
    }



    @Override
    public void listarTodos() {
        if (listaProdutos.isEmpty()) {
            System.out.println("A lista está vazia!");
        } else {
            System.out.println("Lista de todos os produtos:\n");
            for (Produto produto : listaProdutos) {
                produto.visualizar(); 
            }
        }
    }


    @Override
    public void cadastrar(Produto produto) {
        listaProdutos.add(produto);
        System.out.println("O produto foi Cadastrado com sucesso!\n");
    }

    @Override
    public void atualizar(Produto produto) {
        Optional<Produto> produtoExistente = buscarNaCollection(produto.getCodigo());

        if (produtoExistente.isPresent()) {
            listaProdutos.set(listaProdutos.indexOf(produtoExistente.get()), produto);
            System.out.println("\nO Produto com código " + produto.getCodigo() + " foi atualizado com sucesso!");
        } else {
            System.out.println("\nO Produto com código " + produto.getCodigo() + " não foi encontrado");
        }
    }

    @Override
    public void deletar(int codigo) {
        Optional<Produto> produto = buscarNaCollection(codigo);
        if (produto.isPresent()) {
            if (listaProdutos.remove(produto.get())) {
                System.out.println("\nO produto com o código " + codigo + " foi deletado do sistema!");
            }
        } else {
            System.out.println("\nO Produto número " + codigo + " não foi encontrado!");
        }
    }

    // Métodos Auxiliares

    public int gerarCodigo() {
        return ++codigo;
    }

    public Optional<Produto> buscarNaCollection(int codigo) {
        for (var produto : listaProdutos) {
            if (produto.getCodigo() == codigo) {
                return Optional.of(produto);
            }
        }
        return Optional.empty();
    }
}
