package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Montadora;
import br.gov.sp.fatec.model.Veiculo;
import br.gov.sp.fatec.repository.MontadoraRepository;
import br.gov.sp.fatec.repository.VeiculoRepository;

@Service("detranService")
public class DetranImp implements DetranService {

	@Autowired
	private MontadoraRepository montadoraRepo;

	@Autowired
	private VeiculoRepository veiculoRepo;

	@Autowired
	@Qualifier("montadora1")
	private Montadora montadora1;

	@Autowired
	@Qualifier("montadora2")
	private Montadora montadora2;

	@Autowired
	@Qualifier("veiculo1")
	private Veiculo veiculo1;

	@Autowired
	@Qualifier("veiculo2")
	private Veiculo veiculo2;

	@Transactional
	public void cadastrarVeiculo1() {
		montadoraRepo.save(montadora1);
		veiculoRepo.save(veiculo1);
	}

	@Transactional
	public void cadastrarVeiculo2() {
		montadoraRepo.save(montadora2);
		veiculoRepo.save(veiculo2);
	}

	public void  imprimirVeiculo1() {
		System.out.println("\n" + montadoraRepo.findByCnpj(1234334).getNome() + "\n");
		System.out.println("\n" + veiculoRepo.findByChassi(4353453).getModelo() + "\n");
	}

	public void imprimirVeiculo2() {
		System.out.println(montadoraRepo.findByCnpj(32737483).getNome() + "\n");
		System.out.println(veiculoRepo.findByChassi(78573658).getModelo() + "\n");
	}
	
	@Transactional
	public void deletarVeiculo1() {
		veiculoRepo.delete(veiculo1);
		montadoraRepo.delete(montadora1);
	}


	@Transactional
	public void deletarVeiculo2() {
		veiculoRepo.delete(veiculo2);
		montadoraRepo.delete(montadora2);
	}

	@Transactional
	public void registroDeVeiculos() {

		Montadora montadora = new Montadora();
		montadora.setCidade("Caxias");
		montadora.setCnpj((long) 1265345);
		montadora.setEstado("RS");
		montadora.setNome("GM");

		Montadora montadora2 = new Montadora();
		montadora2.setCidade("Taubaté");
		montadora2.setEstado("SP");
		montadora2.setNome("Ford");

		montadoraRepo.save(montadora);
		montadoraRepo.save(montadora2);

		Veiculo veiculo = new Veiculo();
		veiculo.setChassi(2354326);
		veiculo.setModelo("Onix");
		veiculo.setValor(35000);
		veiculo.setMontadora(montadora);

		Veiculo veiculo2 = new Veiculo();
		veiculo2.setChassi(34532167);
		veiculo2.setModelo("Fiesta");
		veiculo2.setValor(34000);
		veiculo2.setMontadora(montadora2);

		veiculoRepo.save(veiculo);
		veiculoRepo.save(veiculo2);
	}

	public void setMontadoraRepo(MontadoraRepository montadoraRepo) {
		this.montadoraRepo = montadoraRepo;
	}

	public void setVeiculoRepo(VeiculoRepository veiculoRepo) {
		this.veiculoRepo = veiculoRepo;
	}

}
