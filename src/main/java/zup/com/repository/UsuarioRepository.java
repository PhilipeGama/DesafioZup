package zup.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import zup.com.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
