/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcoes;

import View.TelaRegistroProdutos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caio
 */
public class Escrita {

    String nome;
    String ano;
    String modelo;
    String marca;
    int valor;
    String estado;
    String placa;
    String cor;
    String potencia;
    String portas;
    String combustivel;
    String km;
//
    public Escrita(String nome, String ano, String modelo, String marca, int valor, String estado, String placa, String cor, String potencia, String portas, String combustivel,String km) {
        this.nome = nome;
        this.ano = ano;
        this.modelo = modelo;
        this.marca = marca;
        this.valor = valor;
        this.estado = estado;
        this.placa = placa;
        this.cor = cor;
        this.potencia = potencia;
        this.portas = portas;
        this.combustivel = combustivel;
         this.km = km;
    }

  
    public Escrita() {

    }

    public void escreve_no_arquivo() throws IOException {

        File arquivo = new File("\\Hermes\\Produtos" + "/" + marca + " " + modelo + ".txt");
        if (!arquivo.exists()) {

        }
        try {

            arquivo.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(TelaRegistroProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }

        FileWriter fw = new FileWriter(arquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(nome + ";" + valor + ";" + ano + ";" + estado + ";" + cor + ";" + placa+ ";" + potencia + ";" + portas+ ";" +combustivel+";"+km);
        bw.newLine();
        bw.close();
        fw.close();
        
        arquivo = new File("\\Hermes\\Produtos" + "/" + nome + ".txt");
        if (!arquivo.exists()) {

        }
        try {

            arquivo.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(TelaRegistroProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }

        fw = new FileWriter(arquivo, true);
        bw = new BufferedWriter(fw);

          bw.write((marca+" "+modelo) + ";" + valor + ";" + ano + ";" + estado + ";" + cor + ";" + placa+ ";" + potencia + ";" + portas+ ";" +combustivel+ ";"+km);
        bw.newLine();
        bw.close();
        fw.close();
    }

    public boolean escreve_no_arquivo_Usuarios(String nome, String cnpj, String tel, String end, String senha, String cep, String email, String responsavel, String web, boolean test) throws IOException {
        File arquivo = new File("\\Hermes\\Usuarios" + "/" + nome + ".txt");
        if (test) {
            if (arquivo.exists()) {
                return false;
            }
        } else {
            Writer out = new FileWriter(arquivo);
            out.write("");
            out.flush();
            out.close();
        }
        try {

            arquivo.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(TelaRegistroProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        FileWriter fw = new FileWriter(arquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(senha);
        bw.newLine();
        bw.write(cnpj);
        bw.newLine();
        bw.write(tel);
        bw.newLine();
        bw.write(end);
        bw.newLine();
        bw.write(responsavel);
        bw.newLine();
        bw.write(cep);
        bw.newLine();
        bw.write(email);
        bw.newLine();
        bw.write(web);
        bw.newLine();
        bw.close();
        fw.close();
        return true;

    }

 
}
