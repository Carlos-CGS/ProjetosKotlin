//trecho de código Kotlin que cria uma exceção personalizada e a utiliza na classe main
  
//Criação de classe para personalizar um exceção
class IllegalVoterException(message: String) : Throwable(message)
    
//(@Throws...) - Informa a nivel de documentação que a classe votar apresenta uma exceção    
@Throws (IllegalVoterException::class)

//A exceção refere-se a pessoa que seja menor de 16 anos, e não poder votar.
fun votar(nome: String, idade: Int){
	if (idade < 16){
        throw IllegalVoterException("$nome não pode voltar.")
	}
		println("O voto de $nome foi realizado com sucesso!")
	}

fun main(){
    var quantidadeVotos = 0;
    //Utilização do try/catch para calcular a quantidade de votos válidos
    quantidadeVotos += try {votar("Carlos", 33); 1;} catch(e:IllegalVoterException){0}
    quantidadeVotos += try {votar("Jose", 14); 1;} catch(e:IllegalVoterException){0}
    quantidadeVotos += try {votar("Pedro", 23); 1;} catch(e:IllegalVoterException){0}
    println(quantidadeVotos)
    
}
