package trabalhopaa;

public class TrabalhoPAA {

    public static void main(String[] args) {
        //Arranjos de entrada x e y
        int x[] = {1,2,3};
        int y[] = {1,2,3};
        
        System.out.println("Subsequencia comum mais longa: ");
        Lcs_Length(x, y);        
    }
    
    public static void Lcs_Length(int x[], int y[]){
        //Tamanho dos arranjos
        int m = x.length;
        int n = y.length;
        
        //Matrizes b e c
        TabelaRelacional [][]c = new TabelaRelacional[m][n];
        TabelaRelacional [][]b = new TabelaRelacional[m][n];
        
        int i, j;
        
        //instancia os objetos na matriz
        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                c[i][j] = new TabelaRelacional();
                b[i][j] = new TabelaRelacional();
            }
        }
        
        //cria o caminho para encontrar a subsequencia
        for(i=1; i<m; i++){
            c[i][0].setValor(0);
        }
        for(j=1; j<n; j++){
            c[0][j].setValor(0);
        }
        for(i=1; i<m; i++){
            for(j=0; j<n; j++){
                if(x[i] == y[j]){
                    c[i][j].setValor((c[i-1][j-1].getValor()+1));
                    b[i][j].setPosicao(Posicao.DIAGONAL);
                }else if(c[i-1][j].getValor() >= c[i-1][j].getValor()){
                    c[i][j].setValor(c[i-1][j].getValor());
                    b[i][j].setPosicao(Posicao.CIMA);
                }else{
                    c[i][j].setValor(c[i][j-1].getValor());
                    b[i][j].setPosicao(Posicao.ESQUERDA);
                }
            }
        }
        
        //Printa atravez do caminho criado a subsequencia
        Print_Lcs(b, x, m-1, n-1);        

        return;
    }
    
    
    public static void Print_Lcs(TabelaRelacional b[][], int x[], int i, int j){
        //Caso base
        if((i==0) || (j==0)) return;
        
        if(b[i][j].getPosicao() == Posicao.DIAGONAL){
            Print_Lcs(b, x, i-1, j-1);
            System.out.println(x[i]); //Não sei se está correto o print
        }
        else if(b[i][j].getPosicao() == Posicao.CIMA){
            Print_Lcs(b, x, i-1, j);
        }
        else{
            Print_Lcs(b, x, i, j-1);
        }
    }
    
}
