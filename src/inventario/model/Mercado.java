/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author Pichau
 */
public class Mercado {
    public int codigo;
    public String nome;
    public ArrayList<Item> itens;
    
    public Mercado(String nome){
    this.itens = new ArrayList<>();
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the itens
     */
    public ArrayList<Item> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }
    public void adicionarItem (Item item){
        try{
        itens.add(item);
        OutputStream os = new FileOutputStream("produtos.txt",true);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        
        String linha = "Nome:" +item.getNome()+ "Preço:"+ item.getPreco()+ "Estoque:"+ item.getEstoque()+ "Código:"+ item.getCodigo();
        bw.write(linha);
        bw.newLine();
        
        bw.close();
        osw.close();
        os.close();
        
        System.out.println("O item "+ item.getNome()+" foi adcionado com sucesso.");
        }catch(Exception e){
        System.out.println("Deu algum erro no adicionarItem");
        }
    }
    public void removerItem (int codigo){
        itens.remove(codigo);
        System.out.println(itens.get(codigo).getNome()+ " foi removido com sucesso");
    }
    public ArrayList<Item> leitura(){
        try{
            InputStream is = new FileInputStream("produtos.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            String linha = br.readLine();
            ArrayList<String> linhas = new ArrayList<>();
            
            while(linha != null){
            System.out.println(linha);
            linha = br.readLine();
            }
            
            System.out.println("Arquivo lido com sucesso");
            
            ArrayList<Item> itens = new ArrayList<>();
            Item item;
            String[] elementos = new String[4];
            
            for(int i=0; i<linhas.size(); i ++){
                elementos = linhas.get(i).split("(?<=\\w):");
                int codigo = Integer.parseInt(elementos[3]);
                int estoque = Integer.parseInt(elementos[2]);
                int preco = Integer.parseInt(elementos[1]);
                item = new Item(codigo, elementos[0],preco, estoque);
                itens.add(item);
        }
            System.out.println("Linhas convertidas com objetos com sucesso");
            return itens;
            
        }catch(Exception e){
        System.out.println("Ocorreu um erro ao ler o arquivo.");
        return null;
        }
    }
}
