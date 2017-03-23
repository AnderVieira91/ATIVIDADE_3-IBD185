package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {
	
	public Veiculo findByChassi(long chassi);

}
