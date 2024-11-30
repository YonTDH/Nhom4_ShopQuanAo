package iuh.se.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import iuh.se.entities.QuanAo;
@Repository
public interface QuanAoRepository extends JpaRepository<QuanAo, String> {
	@Query("SELECT q FROM QuanAo q WHERE q.tenQuanAo LIKE %:key%")
	List<QuanAo> searchQuanAo(@Param("key") String key);
	
	@Query("UPDATE QuanAo q SET q.soLuong = q.soLuong - 1 WHERE q.maQuanAo = :maQuanAo")
	void updateSoLuong(@Param("maQuanAo") String maQuanAo);

}
 