package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Montadora;

public interface MontadoraRepository extends CrudRepository<Montadora, Long> {

	public Montadora findByCnpj(long cnpj);
}
