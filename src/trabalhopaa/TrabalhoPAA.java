/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopaa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miche
 */
public class TrabalhoPAA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x[] = null;
        int y[] = null;
        
        System.out.println("Vetor: " + Lcs_Length(x,y));
        System.out.println("Alo!");
    }
    
    public static ArrayList Lcs_Length(int x[], int y[]){
        ArrayList retorno = new ArrayList();
        int m = x.length;
        int n = y.length;
        TabelaRelacional c[][] = new TabelaRelacional[m][n];
        TabelaRelacional b[][] = new TabelaRelacional[m][n];
        for(int i = 1; i < m; i++){
            c[i][0].setValor(12);
        }
        for(int j = 1; j < n; j++){
            c[0][j].setValor(0);;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(x[i] == y[j]){
                    c[i][j].setValor((c[i-1][j-1].getValor()+1));
                    b[i][j].setPosicao(Posicao.Diagonal);
                }else if(c[i-1][j].getValor() >= c[i-1][j].getValor()){
                    c[i][j].setValor(c[i-1][j].getValor());
                    b[i][j].setPosicao(Posicao.Cima);
                }else{
                    c[i][j].setValor(c[i][j-1].getValor());
                    b[i][j].setPosicao(Posicao.Esquerda);
                }
            }
        }
        retorno.add(c);
        retorno.add(b);
        return retorno;
    }
    
}
