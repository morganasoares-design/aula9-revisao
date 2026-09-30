// ==========================================================
// CLASSE ALUNO
// Parte 01 - Estrutura Básica
// Parte 04 - Notas
// Parte 05 - Mensalidades
// ==========================================================

public class Aluno
{
    // ------------------------------------------------------
    // ATRIBUTOS BÁSICOS
    // private = encapsulamento
    // ------------------------------------------------------
    
    private int codigo;
    private String nome;
    private String dataNascimento;
    private String email;
    private String senha;
    
    // ------------------------------------------------------
    // PARTE 04 - ATRIBUTOS DAS NOTAS
    // Array unidimensional obrigatório.
    // Teremos exatamente 3 notas.
    // ------------------------------------------------------
    
    private double[] notas = new double[3];
    
    // Indica se cada nota já foi lançada.
    private boolean[] lancada = new boolean[3];
    
    // ------------------------------------------------------
    // PARTE 05 - ATRIBUTOS FINANCEIROS
    // Array de objetos Mensalidade.
    // ------------------------------------------------------
    
    private Mensalidade[] mensalidades;
    private int numParcelas;
    
    // ------------------------------------------------------
    // CONSTRUTOR
    // Recebe os dados básicos do aluno.
    // ------------------------------------------------------
    
    public Aluno(int codigo, String nome, String dataNascimento,
                 String email, String senha)
    {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
    }
    
    // ======================================================
    // GETTERS E SETTERS
    // ======================================================
    
    public int getCodigo()
    {
        return codigo;
    }
    
    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public String getDataNascimento()
    {
        return dataNascimento;
    }
    
    public void setDataNascimento(String dataNascimento)
    {
        this.dataNascimento = dataNascimento;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getSenha()
    {
        return senha;
    }
    
    public void setSenha(String senha)
    {
        this.senha = senha;
    }
    
    // ======================================================
    // PARTE 01
    // Método para exibir os dados do aluno.
    // ======================================================
    
    public void exibeDados()
    {
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("Email: " + email);
    }
    
    // ======================================================
    // PARTE 04 - LANÇAMENTO DE NOTAS
    // ======================================================
    
    public void lancarNotas(int indice, double nota)
    {
        // Verifica se o indice está entre 0 e 2.
        if (indice >= 0 && indice < 3)
        {
            // Verifica se a nota está entre 0 e 10.
            if (nota >= 0 && nota <= 10)
            {
                notas[indice] = nota;
                lancada[indice] = true;
                
                System.out.println("Nota lançada com sucesso!");
            }
            else
            {
                System.out.println("A nota deve estar entre 0 e 10.");
            }
        }
        else
        {
            System.out.println("Indice de nota invalido.");
        }
    }
    
    // ======================================================
    // PARTE 04 - CALCULAR MÉDIA
    // ======================================================
    
    public double calcularMedia()
    {
        double soma = 0;
        
        // Soma as 3 notas.
        for (int i = 0; i < 3; i++)
        {
            soma = soma + notas[i];
        }
        
        return soma / 3;
    }
    
    // ======================================================
    // PARTE 04 - EXIBIR NOTAS
    // ======================================================
    
    public void exibirNotas()
    {
        System.out.println();
        System.out.println("Aluno: " + nome);
        System.out.println("-------------------------");
        
        for (int i = 0; i < 3; i++)
        {
            if (lancada[i])
            {
                System.out.println("Nota " + (i + 1) + ": " + notas[i]);
            }
            else
            {
                System.out.println("Nota " + (i + 1) + ": Não lançada");
            }
        }
        
        System.out.println("Media: " + calcularMedia());
    }
    
    // ======================================================
    // PARTE 05
    // ADICIONAR MENSALIDADES
    // ======================================================
    
    public void adicionarMensalidades(double[] valores)
    {
        // Cria o array com a quantidade recebida.
        mensalidades = new Mensalidade[valores.length];
        
        numParcelas = valores.length;
        
        // Cria cada objeto Mensalidade.
        for (int i = 0; i < valores.length; i++)
        {
            mensalidades[i] = new Mensalidade(valores[i]);
        }
    }
    
    // ======================================================
    // PARTE 05
    // EXIBIR MENSALIDADES
    // ======================================================
    
    public void exibirMensalidades()
    {
        System.out.println();
        System.out.println("Financeiro do aluno: " + nome);
        System.out.println("-------------------------");
        
        if (mensalidades == null)
        {
            System.out.println("Nenhuma mensalidade cadastrada.");
            return;
        }
        
        for (int i = 0; i < numParcelas; i++)
        {
            System.out.print("Parcela " + (i + 1));
            System.out.print(" - Valor: R$ " + mensalidades[i].getValor());
            
            if (mensalidades[i].isPago())
            {
                System.out.println(" - PAGO");
            }
            else
            {
                System.out.println(" - PENDENTE");
            }
        }
    }
    
    // ======================================================
    // PARTE 05
    // PAGAR UMA MENSALIDADE
    // ======================================================
    
    public void pagarMensalidade(int indice)
    {
        if (mensalidades == null)
        {
            System.out.println("Nenhuma mensalidade cadastrada.");
            return;
        }
        
        if (indice >= 0 && indice < numParcelas)
        {
            mensalidades[indice].darBaixa();
            System.out.println("Mensalidade paga com sucesso!");
        }
        else
        {
            System.out.println("Numero de parcela invalido.");
        }
    }
}
