package br.com.vhaporfiro.repository;

import br.com.vhaporfiro.entities.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByCpf (String cpf);

    boolean existsByCpf(String cpf);

}
