// ==========================================================
// CLASSE ALUNOBOLSISTA
// PARTE 03 - HERANÇA E POLIMORFISMO
// ==========================================================

// extends significa que AlunoBolsista HERDA de Aluno.
//
// Portanto:
//
// Aluno
//   |
//   +---- AlunoBolsista
//
// O AlunoBolsista possui todos os atributos e métodos
// públicos/protegidos de Aluno e ainda possui seu próprio
// atributo tipoBolsa.

public class AlunoBolsista extends Aluno
{
    // Atributo exclusivo do aluno bolsista.
    private String tipoBolsa;
    
    // ------------------------------------------------------
    // CONSTRUTOR
    // ------------------------------------------------------
    
    public AlunoBolsista(int codigo, String nome,
                         String dataNascimento,
                         String email, String senha,
                         String tipoBolsa)
    {
        // super chama o construtor da classe PAI: Aluno.
        //
        // Isso é HERANÇA.
        
        super(codigo, nome, dataNascimento, email, senha);
        
        this.tipoBolsa = tipoBolsa;
    }
    
    // ------------------------------------------------------
    // GETTER
    // ------------------------------------------------------
    
    public String getTipoBolsa()
    {
        return tipoBolsa;
    }
    
    // ------------------------------------------------------
    // SETTER
    // ------------------------------------------------------
    
    public void setTipoBolsa(String tipoBolsa)
    {
        this.tipoBolsa = tipoBolsa;
    }
    
    // ======================================================
    // POLIMORFISMO
    // ======================================================
    
    // Estamos SOBRESCREVENDO o método exibeDados()
    // que já existe na classe Aluno.
    //
    // @Override indica que estamos sobrescrevendo
    // um método da classe pai.
    
    @Override
    public void exibeDados()
    {
        // Primeiro chamamos o método da classe Aluno.
        super.exibeDados();
        
        // Depois acrescentamos uma informação específica
        // do aluno bolsista.
        
        System.out.println("Tipo de bolsa: " + tipoBolsa);
    }
}
