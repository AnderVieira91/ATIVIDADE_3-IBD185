package br.gov.sp.fatec;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Montadora;
import br.gov.sp.fatec.model.Veiculo;
import br.gov.sp.fatec.repository.MontadoraRepository;
import br.gov.sp.fatec.repository.VeiculoRepository;
import br.gov.sp.fatec.service.DetranService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@Rollback
@Transactional
public class Testes extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private MontadoraRepository montadoraRepo;
	@Autowired
	private VeiculoRepository veiculoRepo;
	@Autowired
	private DetranService detranService;

	public DetranService getDetranService() {
		return detranService;
	}

	public void setDetranService(DetranService detranService) {
		this.detranService = detranService;
	}

	public VeiculoRepository getVeiculoRepo() {
		return veiculoRepo;
	}

	public void setVeiculoRepo(VeiculoRepository veiculoRepo) {
		this.veiculoRepo = veiculoRepo;
	}

	public MontadoraRepository getMontadoraRepo() {
		return montadoraRepo;
	}

	public void setMontadoraRepo(MontadoraRepository montadoraRepo) {
		this.montadoraRepo = montadoraRepo;
	}

	@Test
	public void testeInsercaoBuscaMontadora() {
		Montadora montadora = new Montadora();
		montadora.setCidade("São José dos Campos");
		montadora.setCnpj(34322565L);
		montadora.setEstado("SP");
		montadora.setNome("General Motors");
		montadoraRepo.save(montadora);

		Montadora montadoraB = montadoraRepo.findByCnpj(34322565L);
		assertTrue(montadoraB.getId() != null);
	}

	@Test
	public void testInsercaoBuscaVeiculo() {
		Montadora montadora = new Montadora();
		montadora.setCidade("São José dos Campos");
		montadora.setCnpj(34322565L);
		montadora.setEstado("SP");
		montadora.setNome("General Motors");
		montadoraRepo.save(montadora);

		Veiculo veiculo = new Veiculo();
		veiculo.setChassi(2345L);
		veiculo.setModelo("Onix");
		veiculo.setMontadora(montadora);
		veiculo.setValor(45000.99);
		veiculoRepo.save(veiculo);

		Veiculo veiculoB = veiculoRepo.findByChassi(2345L);
		assertTrue(veiculoB.getId() != null);
	}

	@Test
	public void testeDetranService() {
		try {
			detranService.cadastrarVeiculo1();
			detranService.imprimirVeiculo1();
			detranService.deletarVeiculo1();
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

}
