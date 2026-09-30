// ==========================================================
// CLASSE LISTADEALUNOS
// PARTE 03
//
// O professor exigiu obrigatoriamente:
//
// private Aluno[] alunos;
//
// Portanto NÃO vamos usar ArrayList como estrutura principal.
// ==========================================================

public class ListaDeAlunos
{
    // ------------------------------------------------------
    // ARRAY UNIDIMENSIONAL
    // ------------------------------------------------------
    
    private Aluno[] alunos;
    
    // Quantidade de alunos atualmente cadastrados.
    private int totalAlunos;
    
    // ------------------------------------------------------
    // CONSTRUTOR
    // ------------------------------------------------------
    
    public ListaDeAlunos(int capacidade)
    {
        alunos = new Aluno[capacidade];
        totalAlunos = 0;
    }
    
    // ======================================================
    // ADICIONAR ALUNO
    // ======================================================
    
    public boolean adicionarAluno(Aluno a)
    {
        // Primeiro verifica se já existe um aluno
        // com o mesmo código.
        
        for (int i = 0; i < totalAlunos; i++)
        {
            if (alunos[i].getCodigo() == a.getCodigo())
            {
                System.out.println("Ja existe aluno com esse codigo.");
                return false;
            }
        }
        
        // Verifica se ainda existe espaço no array.
        if (totalAlunos < alunos.length)
        {
            alunos[totalAlunos] = a;
            totalAlunos++;
            
            System.out.println("Aluno adicionado com sucesso.");
            
            return true;
        }
        else
        {
            System.out.println("A lista de alunos esta cheia.");
            return false;
        }
    }
    
    // ======================================================
    // EXIBIR LISTA
    // ======================================================
    
    public void exibirLista()
    {
        if (totalAlunos == 0)
        {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        
        System.out.println();
        System.out.println("===== LISTA DE ALUNOS =====");
        
        // Percorre o array.
        for (int i = 0; i < totalAlunos; i++)
        {
            System.out.println();
            
            // ------------------------------------------------
            // POLIMORFISMO
            // ------------------------------------------------
            //
            // O array é Aluno[].
            //
            // Porém podemos armazenar dentro dele:
            //
            // Aluno
            // AlunoBolsista
            //
            // Quando chamamos exibeDados(), Java verifica
            // qual objeto realmente está armazenado.
            //
            // Se for AlunoBolsista, executará o método
            // sobrescrito de AlunoBolsista.
            
            alunos[i].exibeDados();
            
            System.out.println("-------------------------");
        }
    }
    
    // ======================================================
    // BUSCAR ALUNO PELO CÓDIGO
    // ======================================================
    
    public Aluno buscarAluno(int codigo)
    {
        for (int i = 0; i < totalAlunos; i++)
        {
            if (alunos[i].getCodigo() == codigo)
            {
                return alunos[i];
            }
        }
        
        return null;
    }
    
    // ------------------------------------------------------
    // GETTER DO ARRAY
    // ------------------------------------------------------
    
    public Aluno[] getAlunos()
    {
        return alunos;
    }
    
    // ------------------------------------------------------
    // GETTER DA QUANTIDADE
    // ------------------------------------------------------
    
    public int getTotalAlunos()
    {
        return totalAlunos;
    }
}
