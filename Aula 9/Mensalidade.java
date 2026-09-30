// ==========================================================
// CLASSE MENSALIDADE
// PARTE 05 - CONTROLE FINANCEIRO
// ==========================================================

public class Mensalidade
{
    private double valor;
    private boolean pago;
    
    // ------------------------------------------------------
    // CONSTRUTOR
    // ------------------------------------------------------
    
    public Mensalidade(double valor)
    {
        this.valor = valor;
        
        // Quando a mensalidade é criada,
        // ela começa como não paga.
        this.pago = false;
    }
    
    // ------------------------------------------------------
    // GETTER DO VALOR
    // ------------------------------------------------------
    
    public double getValor()
    {
        return valor;
    }
    
    // ------------------------------------------------------
    // SETTER DO VALOR
    // ------------------------------------------------------
    
    public void setValor(double valor)
    {
        this.valor = valor;
    }
    
    // ------------------------------------------------------
    // GETTER DO PAGAMENTO
    // ------------------------------------------------------
    
    public boolean isPago()
    {
        return pago;
    }
    
    // ------------------------------------------------------
    // SETTER DO PAGAMENTO
    // ------------------------------------------------------
    
    public void setPago(boolean pago)
    {
        this.pago = pago;
    }
    
    // ------------------------------------------------------
    // DAR BAIXA
    // ------------------------------------------------------
    
    public void darBaixa()
    {
        pago = true;
    }
}
