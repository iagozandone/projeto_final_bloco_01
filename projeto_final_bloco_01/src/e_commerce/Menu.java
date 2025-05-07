package e_commerce;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                     UniqueWear                      ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Produto                        ");
			System.out.println("            2 - Listar todas as Produtos             ");
			System.out.println("            3 - Buscar Produto por Numero            ");
			System.out.println("            4 - Atualizar Dados da Produto           ");
			System.out.println("            5 - Apagar Produto                       ");
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
					System.out.println("Consultar Produto por número\n");

					keyPress();
					break;
				case 4:
					System.out.println("Atualizar dados da Produto\n");
					
					keyPress();
					break;
				case 5:
					System.out.println("Apagar a Produto\n");
					
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
