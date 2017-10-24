/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorapoo;

/**
 *
 * @author s_n_a
 */
public class Operacao {
    /*
    operacao:
    1=soma
    2=subtracao
    3=multiplicacao
    4=divisao
    */
    private double valor;
    private int oper;
    
    public double soma(double a, double b){
        return a+b;
    }
    
    public double subtracao(double a, double b){
        return a-b;
    }
    
    public double divisao(double a, double b){
        return a/b;
    }
    
    public double multiplicacao(double a, double b){
        return a*b;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getOper() {
        return oper;
    }

    public void setOper(int oper) {
        this.oper = oper;
    }
    
    
}
