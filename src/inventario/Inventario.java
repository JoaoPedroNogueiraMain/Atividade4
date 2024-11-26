/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inventario;

import inventario.model.Item;
import inventario.model.Mercado;

/**
 *
 * @author Pichau
 */
public class Inventario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                //mercado
        Mercado melhorpreco = new Mercado("Melhor Preço");
        
        //itens
        Item achocolatado = new Item(01,"Achocolatado",7.60,25);
        melhorpreco.adicionarItem(achocolatado);
        melhorpreco.leitura();
        
        
    }
    
}
