package co.mz.ibi.challenge.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.mz.ibi.challenge.model.Pais;
import org.springframework.data.domain.Sort;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{
	
	@Query("SELECT p FROM Pais p")
	public List<Pais> findAll();
	
	@Query("SELECT p FROM Pais p")
	public List<Pais> findAllSortBy(Sort sort);
	
	@Query("SELECT p From Pais p WHERE p.identificador = :identificador")
	public Pais findByIdentificador(@Param("identificador") Long identificador);
	
	
	@Modifying
	@Transactional
	@Query("DELETE from Pais p WHERE p.identificador =:identificador")
	public void deletePais(@Param("identificador") Long identificador);
	
	
	@Modifying
	@Transactional
	@Query("UPDATE Pais p set p.nome = :nome, p.capital = :capital, p.regiao = :regiao, "
			+ "p.subRegiao = :subRegiao, p.area = :area WHERE p.identificador = :identificador")
	public void updatePais(@Param("nome") String nome, @Param("capital") String capital, @Param("regiao") String regiao,
			@Param("subRegiao") String subRegiao, @Param("area") BigDecimal area, @Param("identificador") Long identificador);
	
	

}
