enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    var inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
         inscritos.add(usuario)
    }
    
    fun listaInscritos(){
        for(user in inscritos){
            println(user.nome)
        }
    }
    
    fun conteudoEducacional(){
        for(cont in conteudos){
            println("${cont.nome} - ${cont.duracao}")
        }
    }
}

fun main() {
    val primeiroModulo = ConteudoEducacional("01 - Iniciando Kotlin", 60)
    val segundoModulo = ConteudoEducacional("02 - kotlin na Prática", 130)
    val terceiroModulo = ConteudoEducacional("03 - Desafio de Código e Projeto", 20)
    val moduloInicial = ConteudoEducacional("01 - Desenvolvendo o C# na Prática", 140)
    val moduloFinal = ConteudoEducacional("02 - Desafio Projeto C#", 30)
    
    val listConteudosKotlin = mutableListOf<ConteudoEducacional>()
    val listConteudosCSharp = mutableListOf<ConteudoEducacional>()
    
    listConteudosKotlin.add(primeiroModulo)
    listConteudosKotlin.add(segundoModulo)
    listConteudosKotlin.add(terceiroModulo)
    listConteudosCSharp.add(moduloInicial)
    listConteudosCSharp.add(moduloFinal)
    
    
    val formacaoKotlin = Formacao("Formação: Kotlin", listConteudosKotlin, Nivel.BASICO)
    val formacaoCSharp = Formacao("Formação: C#", listConteudosCSharp, Nivel.AVANCADO )
    
    //lista de alunos
    val carlos = Usuario("- Carlos Garcia", "carlos@gmail.com")
    val joao = Usuario("- João da Silva", "joao@gmail.com")
    val pedro = Usuario("- Pedro Souza", "pedro@gmail.com")
    val jose = Usuario("- José de Oliveira", "jose@gmail.com")
    
    //matriculando alunos
    formacaoKotlin.matricular(joao)
    formacaoKotlin.matricular(pedro)
    formacaoCSharp.matricular(carlos)
    formacaoCSharp.matricular(jose)
    
    println("Dados da formação Kotlin")
    println("${formacaoKotlin.nome} - Nível:${formacaoKotlin.nivel}")
    println("Conteudo Educacional")
    println(formacaoKotlin.conteudoEducacional())
    println("Lista de inscritos")
    println(formacaoKotlin.listaInscritos())
    println(" ")
    
    println(" #  ---  #  --- #  ---  # ")
    println(" ")
    println("Dados da formação C#")
    println("${formacaoCSharp.nome} - Nível:${formacaoCSharp.nivel}")
    println("Conteudo Educacional")
    println(formacaoCSharp.conteudoEducacional())
    println("Lista de inscritos")
    println(formacaoCSharp.listaInscritos())
}
