package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.FuncionarioDTO;
import org.soulcodeacademy.helpr.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController  //esta classe é capaz de captar as requisições
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    //funcionarios (get)
    @GetMapping("/funcionarios")
    public List<Funcionario> listar(){
        return this.funcionarioService.listar();
    }

    @GetMapping("/funcionarios/{idFuncionario}")
    public Funcionario getFuncionario(@PathVariable Integer idFuncionario){
        return this.funcionarioService.getFuncionario(idFuncionario);
    }

    @PostMapping("/funcionario")   //método para receber o JSON
    public Funcionario salvar(@Valid @RequestBody FuncionarioDTO dto) {
    Funcionario funcionario = this.funcionarioService.salvar(dto);
    return funcionario;
    }

    //controle vai pegar as informações e validar, chamo o service que ja validou e salvo
    @PutMapping("/funcionario{idFuncionario}")
    public Funcionario atualizar(@PathVariable Integer idFuncionario,@Valid @RequestBody FuncionarioDTO dto) {
        //funcionario atualizado// coletando a id do endpoint (para verificar se func. existe) e o corpo da requisição
        Funcionario atualizado = this.funcionarioService.atualizar(idFuncionario, dto);
        return atualizado;
    }

    @DeleteMapping("/funcionarios/{idFuncionario}")
    public void deletar(@PathVariable Integer idFuncionario){
    this.funcionarioService.deletar(idFuncionario);
    }

}
