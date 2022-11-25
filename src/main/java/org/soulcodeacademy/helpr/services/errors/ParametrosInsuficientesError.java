package org.soulcodeacademy.helpr.services.errors;

//Está classe de erro, representa quando uma operação está faltando dados. Ex: atualizar -> idFuncionario nulo
public class ParametrosInsuficientesError extends RuntimeException {
    public ParametrosInsuficientesError(String message){
        super(message);
    }
}
