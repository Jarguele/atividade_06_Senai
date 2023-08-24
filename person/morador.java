package com.seuapp.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String apartamento;
    private String bloco;
    private String cpf;

    // Getters, setters e construtores
}
package com.seuapp.person;

        import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorRepository extends JpaRepository<Morador, Long> {

}
package com.seuapp.person;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class MoradorService {

    private final MoradorRepository moradorRepository;

    @Autowired
    public MoradorService(MoradorRepository moradorRepository) {
        this.moradorRepository = moradorRepository;
    }

    public List<Morador> listarMoradores() {
        return moradorRepository.findAll();
    }

    public Morador buscarMoradorPorId(Long id) {
        return moradorRepository.findById(id).orElse(null);
    }

    public Morador salvarMorador(Morador morador) {
        return moradorRepository.save(morador);
    }

    public void excluirMorador(Long id) {
        moradorRepository.deleteById(id);
    }
}
