// ==========================================================
// SISTEMA ESCOLA EAD
//
// CLASSE PRINCIPAL DO PROJETO
//
// Aqui juntamos as 5 partes do trabalho.
// ==========================================================

import java.util.Scanner;

public class SistemaEscolaEAD
{
    // Scanner para ler dados do teclado.
    private Scanner entrada;
    
    // Lista principal de alunos.
    private ListaDeAlunos listaAlunos;
    
    // ======================================================
    // ARRAY BIDIMENSIONAL
    // ======================================================
    //
    // O professor exige o uso de array bidimensional.
    //
    // Vamos usar uma matriz de cursos.
    //
    // 2 linhas x 3 colunas.
    //
    // Exemplo:
    //
    // matrizCursos[0][0]
    // matrizCursos[0][1]
    // matrizCursos[0][2]
    //
    // matrizCursos[1][0]
    // matrizCursos[1][1]
    // matrizCursos[1][2]
    
    private Curso[][] matrizCursos;
    
    // ------------------------------------------------------
    // CONSTRUTOR
    // ------------------------------------------------------
    
    public SistemaEscolaEAD()
    {
        entrada = new Scanner(System.in);
        
        // Lista para até 20 alunos.
        listaAlunos = new ListaDeAlunos(20);
        
        // Matriz de cursos.
        matrizCursos = new Curso[2][3];
        
        // Cadastra alguns dados iniciais.
        cadastrarCursos();
        cadastrarAlunosIniciais();
    }
    
    // ======================================================
    // PARTE 02
    // CADASTRAR CURSOS
    // ======================================================
    
    private void cadastrarCursos()
    {
        // Criamos alguns cursos para demonstrar
        // o funcionamento do array bidimensional.
        
        matrizCursos[0][0] =
            new Curso(1, "Java Basico", 40);
        
        matrizCursos[0][1] =
            new Curso(2, "Banco de Dados", 30);
        
        matrizCursos[0][2] =
            new Curso(3, "HTML e CSS", 25);
        
        matrizCursos[1][0] =
            new Curso(4, "Java Orientado a Objetos", 50);
        
        matrizCursos[1][1] =
            new Curso(5, "Programacao Web", 40);
        
        matrizCursos[1][2] =
            new Curso(6, "Logica de Programacao", 35);
    }
    
    // ======================================================
    // CADASTRAR ALUNOS INICIAIS
    // ======================================================
    
    private void cadastrarAlunosIniciais()
    {
        Aluno aluno1 = new Aluno(
            1,
            "Carlos",
            "10/05/2000",
            "carlos@email.com",
            "1234"
        );
        
        AlunoBolsista aluno2 = new AlunoBolsista(
            2,
            "Ana",
            "20/08/2001",
            "ana@email.com",
            "5678",
            "50%"
        );
        
        // --------------------------------------------------
        // POLIMORFISMO
        // --------------------------------------------------
        //
        // O método adicionarAluno recebe um objeto Aluno.
        //
        // AlunoBolsista É UM Aluno.
        //
        // Portanto podemos passar aluno2.
        
        listaAlunos.adicionarAluno(aluno1);
        listaAlunos.adicionarAluno(aluno2);
        
        // --------------------------------------------------
        // Adicionando algumas notas para demonstração.
        // --------------------------------------------------
        
        aluno1.lancarNotas(0, 8.0);
        aluno1.lancarNotas(1, 7.0);
        aluno1.lancarNotas(2, 9.0);
        
        aluno2.lancarNotas(0, 10.0);
        aluno2.lancarNotas(1, 9.0);
        aluno2.lancarNotas(2, 8.0);
        
        // --------------------------------------------------
        // Adicionando mensalidades.
        // --------------------------------------------------
        
        double[] valores1 = {200.0, 200.0, 200.0};
        double[] valores2 = {100.0, 100.0, 100.0};
        
        aluno1.adicionarMensalidades(valores1);
        aluno2.adicionarMensalidades(valores2);
    }
    
    // ======================================================
    // MENU PRINCIPAL
    // ======================================================
    
    public void iniciar()
    {
        int opcao;
        
        // DO-WHILE
        // O menu continua aparecendo até escolher 5.
        
        do
        {
            System.out.println();
            System.out.println("================================");
            System.out.println("       ESCOLA EAD");
            System.out.println("================================");
            System.out.println("1 - Visualizar Lista de Alunos");
            System.out.println("2 - Adicionar Aluno");
            System.out.println("3 - Visualizar Cursos");
            System.out.println("4 - Verificar Notas do Aluno");
            System.out.println("5 - Verificar Financeiro do Aluno");
            System.out.println("6 - Sair");
            System.out.println("================================");
            System.out.print("Digite uma opcao: ");
            
            opcao = entrada.nextInt();
            
            // SWITCH
            switch (opcao)
            {
                case 1:
                    listaAlunos.exibirLista();
                    break;
                
                case 2:
                    adicionarAluno();
                    break;
                
                case 3:
                    exibirCursos();
                    break;
                
                case 4:
                    verificarNotas();
                    break;
                
                case 5:
                    verificarFinanceiro();
                    break;
                
                case 6:
                    System.out.println("Sistema encerrado.");
                    break;
                
                default:
                    System.out.println("Opcao invalida.");
            }
            
        }
        while (opcao != 6);
    }
    
    // ======================================================
    // PARTE 03
    // ADICIONAR ALUNO PELO MENU
    // ======================================================
    
    private void adicionarAluno()
    {
        System.out.println();
        System.out.println("===== NOVO ALUNO =====");
        
        System.out.print("Codigo: ");
        int codigo = entrada.nextInt();
        
        entrada.nextLine();
        
        System.out.print("Nome: ");
        String nome = entrada.nextLine();
        
        System.out.print("Data de nascimento: ");
        String data = entrada.nextLine();
        
        System.out.print("Email: ");
        String email = entrada.nextLine();
        
        System.out.print("Senha: ");
        String senha = entrada.nextLine();
        
        System.out.print("O aluno possui bolsa? (S/N): ");
        String resposta = entrada.nextLine();
        
        // --------------------------------------------------
        // IF
        // --------------------------------------------------
        
        if (resposta.equalsIgnoreCase("S"))
        {
            System.out.print("Tipo de bolsa: ");
            String bolsa = entrada.nextLine();
            
            // Criamos um ALUNOBOLSISTA.
            AlunoBolsista aluno =
                new AlunoBolsista(
                    codigo,
                    nome,
                    data,
                    email,
                    senha,
                    bolsa
                );
            
            listaAlunos.adicionarAluno(aluno);
        }
        else
        {
            // Criamos um ALUNO normal.
            Aluno aluno =
                new Aluno(
                    codigo,
                    nome,
                    data,
                    email,
                    senha
                );
            
            listaAlunos.adicionarAluno(aluno);
        }
    }
    
    // ======================================================
    // PARTE 02
    // EXIBIR CURSOS
    // ======================================================
    
    private void exibirCursos()
    {
        System.out.println();
        System.out.println("===== CURSOS =====");
        
        // --------------------------------------------------
        // DOIS FOR
        //
        // Como nossa estrutura é bidimensional,
        // precisamos de dois índices.
        // --------------------------------------------------
        
        for (int linha = 0; linha < matrizCursos.length; linha++)
        {
            for (int coluna = 0;
                 coluna < matrizCursos[linha].length;
                 coluna++)
            {
                if (matrizCursos[linha][coluna] != null)
                {
                    matrizCursos[linha][coluna].exibeDados();
                    System.out.println("------------------");
                }
            }
        }
    }
    
    // ======================================================
    // PARTE 04
    // VERIFICAR NOTAS
    // ======================================================
    
    private void verificarNotas()
    {
        System.out.println();
        System.out.print("Digite o codigo do aluno: ");
        
        int codigo = entrada.nextInt();
        
        // Busca o aluno pelo código.
        Aluno aluno = listaAlunos.buscarAluno(codigo);
        
        // --------------------------------------------------
        // VALIDAÇÃO
        // --------------------------------------------------
        
        if (aluno != null)
        {
            aluno.exibirNotas();
        }
        else
        {
            System.out.println("Aluno nao encontrado.");
        }
    }
    
    // ======================================================
    // PARTE 05
    // VERIFICAR FINANCEIRO
    // ======================================================
    
    private void verificarFinanceiro()
    {
        System.out.println();
        System.out.print("Digite o codigo do aluno: ");
        
        int codigo = entrada.nextInt();
        
        Aluno aluno = listaAlunos.buscarAluno(codigo);
        
        // Verifica se o aluno existe.
        if (aluno != null)
        {
            // Mostra as mensalidades.
            aluno.exibirMensalidades();
            
            System.out.println();
            System.out.print(
                "Digite o numero da parcela para pagar "
                + "(0 para cancelar): "
            );
            
            int parcela = entrada.nextInt();
            
            if (parcela != 0)
            {
                // O usuário digita 1 para parcela 1.
                // O array começa no índice 0.
                //
                // Por isso fazemos parcela - 1.
                
                aluno.pagarMensalidade(parcela - 1);
                
                // Mostra novamente para confirmar.
                aluno.exibirMensalidades();
            }
        }
        else
        {
            System.out.println("Aluno nao encontrado.");
        }
    }
}
