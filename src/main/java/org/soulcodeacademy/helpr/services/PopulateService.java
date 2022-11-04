package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Objetivo dela, inserir dados no banco!

@Service // Indica que a classa é um servicço, e indica para o Spring que está classe será gerenciada por ele.
public class PopulateService {

    @Autowired // irá injetar o objeto direto na classe// vai no container, pega a instancia do cargoRepository
    private CargoRepository cargoRepository;

    public void populate(){   // necessário criar um construtor
        Cargo c1 = new Cargo(null, "Diretor", "Gerencia a empresa", 30000.0);
        Cargo c2 = new Cargo(null, "Gerente", "Gerencia o setor", 18000.0);
        Cargo c3 = new Cargo(null, "Técnico", "Resolve os chamados", 12000.0);

        // VAMOS SALVAR AS ENTIDADES = persistir as entidades!
        this.cargoRepository.save(c1); // INSERT INTO
        this.cargoRepository.save(c2);
        this.cargoRepository.save(c3);
    }
}

// o obj dessa classe é inserir no banco, dados fictícios (de teste)
// IOC = Inversion of Control = Inversão de Controle = É ele quem manda nas instâncias.
// Container => é o local onde o Spring guarda os objetos anotados
// Injeção de dependências = quando o spring injeta os objetos da classe






