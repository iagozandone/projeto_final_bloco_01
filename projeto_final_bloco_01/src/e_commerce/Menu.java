package e_commerce;

import java.util.Scanner;

import controller.ProdutoController;
import model.Camiseta;
import model.Calca;
import model.Produto;

public class Menu {

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);

        int opcao, codigo, quantidade, tipo;
        float preco;
        String nome, genero, tamanho, estampa;

        ProdutoController produtoController = new ProdutoController();

        while (true) {

            System.out.println("*****************************************************");
            System.out.println("                     UniqueWear                      ");
            System.out.println("*****************************************************");
            System.out.println("            1 - Cadastrar Produto                    ");
            System.out.println("            2 - Listar todas as Produtos             ");
            System.out.println("            3 - Venda de um produto                  ");
            System.out.println("            4 - Buscar Produto por Numero            ");
            System.out.println("            5 - Atualizar Dados da Produto           ");
            System.out.println("            6 - Apagar Produto                       ");
            System.out.println("            0 - Sair                                 ");
            System.out.println("*****************************************************");
            System.out.println("Entre com a opção desejada:                          ");

            opcao = leia.nextInt();
            leia.nextLine(); // Para consumir a linha pendente do nextInt()

            if (opcao == 0) {
                System.out.println("\nFinalizando programa...");
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o tipo do Produto (1 - Camiseta | 2 - Calça): ");
                    tipo = leia.nextInt();
                    leia.nextLine();  // Consumir a linha após o nextInt()

                    if (tipo == 1) {
                        nome = "Camiseta";
                    } else if (tipo == 2) {
                        nome = "Calça";
                    } else {
                        System.out.println("Tipo de produto inválido!");
                        keyPress();
                        break;
                    }

                    System.out.print("Digite o gênero (1 - Masculino | 2 - Feminino): ");
                    int opGenero = leia.nextInt();
                    leia.nextLine();  // Consumir a linha após o nextInt()

                    if (opGenero == 1) {
                        genero = "Masculino";
                    } else if (opGenero == 2) {
                        genero = "Feminino";
                    } else {
                        System.out.println("Opção de gênero inválida!");
                        keyPress();
                        break;
                    }

                    System.out.print("Digite o tamanho: ");
                    tamanho = leia.nextLine().toUpperCase();

                    System.out.print("Digite a quantidade: ");
                    quantidade = leia.nextInt();

                    System.out.print("Digite o preço: ");
                    preco = leia.nextFloat();
                    leia.nextLine(); // Consumir a linha pendente

                    Produto produto;
                    if (tipo == 1) {
                        System.out.print("Digite o tipo da estampa: ");
                        estampa = leia.nextLine();
                        produto = new Camiseta(nome, genero, produtoController.gerarCodigo(), preco, quantidade, tamanho, estampa);
                    } else {
                        System.out.print("Digite o tipo de tecido: ");
                        String tecido = leia.nextLine();
                        produto = new Calca(nome, genero, produtoController.gerarCodigo(), preco, quantidade, tamanho, tecido);
                    }

                    produtoController.cadastrar(produto);
                    System.out.println("Produto cadastrado com sucesso!");

                    keyPress();
                    break;
                case 2:
                    System.out.println("Listar todos os Produtos\n");
                    produtoController.listarTodos();
                    keyPress();
                    break;
                case 3:
                    System.out.println("Venda de Produto\n");
                    System.out.print("Digite o código do produto que deseja vender: ");
                    codigo = leia.nextInt();
                    System.out.print("Digite a quantidade que deseja vender: ");
                    quantidade = leia.nextInt();
                    produtoController.venderProduto(codigo, quantidade);
                    keyPress();
                    break;
                case 4:
                    System.out.println("Buscar Produto por Número\n");
                    System.out.print("Digite o código do produto: ");
                    codigo = leia.nextInt();
                    leia.nextLine(); // limpar o buffer

                    Produto produtoEncontrado = produtoController.procurarPorCodigo(codigo);

                    if (produtoEncontrado != null) {
                        System.out.println("Produto encontrado:");
                        produtoEncontrado.visualizar();
                    } else {
                        System.out.println("Produto não encontrado.");
                    }

                    keyPress();
                    break;

                case 5:
                	System.out.println("Atualizar Dados do Produto\n");
                    System.out.print("Digite o código do produto que deseja atualizar: ");
                    codigo = leia.nextInt();
                    leia.nextLine();  // Consumir a linha após o nextInt()
                    produtoEncontrado = produtoController.procurarPorCodigo(codigo);
                    if (produtoEncontrado != null) {
                        System.out.println("Produto encontrado: ");
                        produtoEncontrado.visualizar();

                        // Atualizar dados do produto
                        System.out.println("\nDigite as novas informações do produto (pressione Enter para manter o valor atual):");

                        System.out.print("Novo nome (atual: " + produtoEncontrado.getNome() + "): ");
                        nome = leia.nextLine();
                        if (!nome.isEmpty()) {
                            produtoEncontrado.setNome(nome);
                        }

                        System.out.print("Novo gênero (atual: " + produtoEncontrado.getGenero() + "): ");
                        String novoGenero = leia.nextLine();
                        if (!novoGenero.isEmpty()) {
                            produtoEncontrado.setGenero(novoGenero);
                        }

                        System.out.print("Novo tamanho (atual: " + produtoEncontrado.getTamanho() + "): ");
                        tamanho = leia.nextLine();
                        if (!tamanho.isEmpty()) {
                            produtoEncontrado.setTamanho(tamanho.toUpperCase());
                        }

                        System.out.print("Nova quantidade (atual: " + produtoEncontrado.getQuantidade() + "): ");
                        String novaQuantidade = leia.nextLine();
                        if (!novaQuantidade.isEmpty()) {
                            produtoEncontrado.setQuantidade(Integer.parseInt(novaQuantidade));
                        }

                        System.out.print("Novo preço (atual: " + produtoEncontrado.getPreco() + "): ");
                        String novoPreco = leia.nextLine();
                        if (!novoPreco.isEmpty()) {
                            produtoEncontrado.setPreco(Float.parseFloat(novoPreco));
                        }

                        // Atualizar estampa ou tecido
                        if (produtoEncontrado instanceof Camiseta) {
                            System.out.print("Nova estampa (atual: " + ((Camiseta) produtoEncontrado).getEstampa() + "): ");
                            String novaEstampa = leia.nextLine();
                            if (!novaEstampa.isEmpty()) {
                                ((Camiseta) produtoEncontrado).setEstampa(novaEstampa);
                            }
                        } else if (produtoEncontrado instanceof Calca) {
                            System.out.print("Novo tecido (atual: " + ((Calca) produtoEncontrado).getTecido() + "): ");
                            String novoTecido = leia.nextLine();
                            if (!novoTecido.isEmpty()) {
                                ((Calca) produtoEncontrado).setTecido(novoTecido);
                            }
                        }

                        produtoController.atualizar(produtoEncontrado);
                        System.out.println("Produto atualizado com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }

                    keyPress();
                    break;
                case 6:
                    System.out.println("Apagar Produto\n");
                    System.out.print("Digite o código do produto: ");
                    codigo = leia.nextInt();
                    produtoController.deletar(codigo);
                    keyPress();
                    break;
                default:
                    System.out.println("\nOpção Inválida!\n");
                    break;
            }
        }
    }

    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por: Iago Zandone  ");
        System.out.println("https://github.com/iagozandone");
        System.out.println("*********************************************************");
    }

    public static void keyPress() {
        Scanner leia = new Scanner(System.in);
        System.out.println("\n\nPressione Enter para Continuar...");
        leia.nextLine(); // Aguarda o usuário pressionar Enter
    }
}
