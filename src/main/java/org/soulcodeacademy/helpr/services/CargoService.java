package org.soulcodeacademy.helpr.services;
import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    // Listar todos
    public List<Cargo> listar() {
        // Retorna os dados da tabela em forma de lista
        // SELECT * FROM cargo;
        return this.cargoRepository.findAll();
    }

    // Listar um pelo ID
    public Cargo getCargo(Integer idCargo) {
        // SELECT * FROM cargo WHERE idCargo = ?
        // Optional = Pode haver cargo ou não
        Optional<Cargo> cargo = this.cargoRepository.findById(idCargo);

        if(cargo.isEmpty()) { // Não encontrou o cargo?
            // Não encontrou o cargo com id solicitado
            throw new RuntimeException("O cargo não foi encontrado!"); // Causa um erro com a mensagem
        } else {
            return cargo.get(); // Extrair o cargo de dentro do optional
        }
    }

    // Salvar
    public Cargo salvar (Cargo novoCargo){
        novoCargo.setIdCargo(null);   // verificar que o campo está nullo, (limpar o campo ID) para não substituir
        Cargo cargoSalvo = this.cargoRepository.save(novoCargo);
        return cargoSalvo;
    }

    // Atualizar
    //para atualizar precisa do id do cargo e dos dados atualizados
    public Cargo atualizar(Integer idCargo, Cargo novoCargo){
        //verificar se o cargo existe mesmo.....
        Cargo cargoAtual  = this.getCargo(idCargo);

        cargoAtual.setNome(novoCargo.getNome());              //setAtualizar(getEssesDados)
        cargoAtual.setDescricao(novoCargo.getDescricao());
        cargoAtual.setSalario(novoCargo.getSalario());

        Cargo atualizado = this.cargoRepository.save(cargoAtual);
        return atualizado;

    }

    // Deletar
    public void deletar (Integer idCargo){
        Cargo cargo = this.getCargo((idCargo));       //verificar se o cargo realmente existe
        this.cargoRepository.delete(cargo);
    }
}