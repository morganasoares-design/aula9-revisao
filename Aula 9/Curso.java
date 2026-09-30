// ==========================================================
// CLASSE CURSO
// PARTE 02 - ESTRUTURAS DE REPETIÇÃO E SELEÇÃO
// ==========================================================

public class Curso
{
    // Atributos privados = encapsulamento.
    private int codigo;
    private String nome;
    private int duracao;
    
    // ------------------------------------------------------
    // CONSTRUTOR
    // ------------------------------------------------------
    
    public Curso(int codigo, String nome, int duracao)
    {
        this.codigo = codigo;
        this.nome = nome;
        this.duracao = duracao;
    }
    
    // ------------------------------------------------------
    // GETTERS
    // ------------------------------------------------------
    
    public int getCodigo()
    {
        return codigo;
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public int getDuracao()
    {
        return duracao;
    }
    
    // ------------------------------------------------------
    // SETTERS
    // ------------------------------------------------------
    
    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setDuracao(int duracao)
    {
        this.duracao = duracao;
    }
    
    // ------------------------------------------------------
    // EXIBIR DADOS
    // ------------------------------------------------------
    
    public void exibeDados()
    {
        System.out.println("Codigo: " + codigo);
        System.out.println("Curso: " + nome);
        System.out.println("Duracao: " + duracao + " horas");
    }
}
