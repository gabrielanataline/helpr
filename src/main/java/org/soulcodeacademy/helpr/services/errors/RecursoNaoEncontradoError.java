package org.soulcodeacademy.helpr.services.errors;

//Essa classe representa o erro de regra de negócio,
// para quando não encontrarmos cargos, clientes,
// funcionários  e chamados no banco

public class RecursoNaoEncontradoError extends RuntimeException {
    public RecursoNaoEncontradoError(String message){
        super(message); //Passamos a mensagem para a Runtime
    }
}
