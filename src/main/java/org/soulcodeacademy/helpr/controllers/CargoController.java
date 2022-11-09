package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.dto.CargoDTO;
import org.soulcodeacademy.helpr.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController // retornos de dados
public class CargoController {

    //GetMapping = leitura e mapeamento de dados
    // Endpoint é o endereço que será acessado no BackEnd
    @GetMapping("/oi")  // com base em locahost:0800/oi retornará a String
    public String dizOla(){
        return "Batata!";    //resposta da requisição
    }

    @GetMapping("/batata")
        public Integer valor(){
        return 1000;
    }

    @Autowired
    private CargoService cargoService;  //responsável, por ir no repositories pedir a lista de cargos

    @GetMapping("/cargos")
    public List<Cargo> listar(){     //necessário importar List, do Java Util
        //Requisição -> Controller -> Service -> Repository -> SELECT *FROM cargo;
        return this.cargoService.listar();
    }
    @GetMapping("/cargos/{idCargo}")   //idCargo em parametro, indica que o valor após a barra é dinâmico
    public Cargo getCargo(@PathVariable Integer idCargo){
        // PathVariable, extrai do endpoint o valor dinâmico...
        //  é utilizado quando o valor da variável é passada diretamente na URL
        return this.cargoService.getCargo(idCargo);
    }


    // Podemos usar o mesmo endpoint para verbos diferentes
    @PostMapping("/cargos") // REQUISIÇÃO TIPO POST para /cargos
    public Cargo salvar(@Valid @RequestBody CargoDTO cargo) {
        // @RequestBody - extrair o JSON do corpo e converte para Cargo (deserialização)
        Cargo salvo = this.cargoService.salvar(cargo);


        return salvo; // A resposta será o cargo inserido
    }

    // Mapeia requisições do verbo PUT
    @PutMapping("/cargos/{idCargo}") // /cargos/5
    public Cargo atualizar(@PathVariable Integer idCargo, @Valid @RequestBody CargoDTO cargo) {
        Cargo atualizado = this.cargoService.atualizar(idCargo, cargo);
        return atualizado; // Resposta para o cliente (cargo atualizado)
    }

    @DeleteMapping("/cargos/{idCargo}")
    public void deletar (@PathVariable Integer idCargo){
    this.cargoService.deletar(idCargo);
    }
}
