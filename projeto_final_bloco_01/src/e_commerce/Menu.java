package e_commerce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Calca;
import model.Camiseta;
import model.Produto;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);

		int opcao;
		    	
        // Teste direto

        // Criação das camisetas
        Camiseta camiseta1 = new Camiseta("Camiseta Oversized", "Camiseta", 101, 89.90f, 10, "M", "Arte Abstrata");

        // Criação das calças
        Calca calca1 = new Calca("Calça Jeans Skinny", "Calça", 201, 149.90f, 8, "38", "Jeans");


        // Adicionando os produtos na lista
        camiseta1.visualizar();
        calca1.visualizar();


        
		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                     UniqueWear                      ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Produto                        ");
			System.out.println("            2 - Listar todas as Produtos             ");
			System.out.println("            3 - Venda de um produto                  ");
			System.out.println("            4 - Buscar Produto por Numero            ");
			System.out.println("            5 - Atualizar Dados da Produto           ");
			System.out.println("            6 - Apagar Produto                       ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");
			

			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println("\nFinalizando programa...");
				sobre();
                 leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Criar Produto\n");

					keyPress();
					break;
				case 2:
					System.out.println("Listar todas as Produtos\n");

					keyPress();
					break;
				case 3:
					System.out.println("Venda de Produto\n");

					keyPress();
					break;
				case 4:
					System.out.println("Buscar Produto por Numero\n");
					
					keyPress();
					break;
				case 5:
					System.out.println("Atualizar Dados da Produto\n");
					
					keyPress();
					break;
				case 6:
					System.out.println("Apagar Produto\n");
					
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
	    try {
	        System.out.println("\n\nPressione Enter para Continuar...");
	        
	        // Lê até o usuário pressionar Enter
	        int input;
	        while ((input = System.in.read()) != '\n') {
	            if (input == -1) {
	                throw new IOException("Entrada encerrada inesperadamente");
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Erro ao capturar tecla: " + e.getMessage());
	    }
	}
}
