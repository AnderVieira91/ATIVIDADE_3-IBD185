package br.gov.sp.fatec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.service.DetranService;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		DetranService detran = (DetranService) context.getBean("detranService");

		detran.cadastrarVeiculo1();
		detran.cadastrarVeiculo2();
		detran.imprimirVeiculo1();
		detran.imprimirVeiculo2();
		detran.deletarVeiculo1();
		detran.deletarVeiculo2();

		try {
			detran.registroDeVeiculos();
		} catch (Exception e) {
			System.out.println("\n\n\n\n\nErro esperado! Rollback realizado!\n");
			System.out.println("Acabou o erro\n\n\n\n");
		}

	}
}
