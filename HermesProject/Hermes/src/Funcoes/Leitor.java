package Funcoes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class Leitor {

    private String[] str;
    RandomAccessFile file;
    boolean func;

    public Leitor() {
        str = new String[4];
    }

    public DefaultTableModel read(String nome, int tipo) {
        try {
            file = new RandomAccessFile("\\Hermes\\Produtos" + "/" + nome + ".txt", "r");
            func = false;
            DefaultTableModel m = new DefaultTableModel() {
                @Override
                public Class getColumnClass(int column) {
                    switch (column) {
                        case 0:
                            return String.class;
                        case 1:
                            return Integer.class;
                        case 2:
                            return Integer.class;
                        case 3:
                            return String.class;
                        case 4:
                            return String.class;
                        case 6:
                            return String.class;
                        default:
                            return String.class;
                    }
                }
            };
            m.addColumn("Nome");
            m.addColumn("Preço");
            m.addColumn("Ano");
            m.addColumn("Estado");
            m.addColumn("Cor");
            m.addColumn("Placa");
              m.addColumn("Motor");
            m.addColumn("N° Portas");
              m.addColumn("Combustivel");
               m.addColumn("Km Rodados");
            while (str != null) {
                try {
                    str = file.readLine().split(";");
                    func = true;
                    switch (tipo) {
                        case 1:
                            if (str[3].equals("novo")) {
                                m.addRow(new Object[]{str[0], Integer.valueOf(str[1]), Integer.valueOf(str[2]), str[3], str[4], str[5],str[6],str[7],str[8],str[9]});
                            }
                            break;
                        case 2:
                            if (str[3].equals("novo") == false) {
                                m.addRow(new Object[]{str[0], Integer.valueOf(str[1]), Integer.valueOf(str[2]), str[3], str[4], str[5],str[6],str[7],str[8],str[9]});
                            }
                            break;
                        case 3:
                            m.addRow(new Object[]{str[0], Integer.valueOf(str[1]), Integer.valueOf(str[2]), str[3], str[4], str[5],str[6],str[7],str[8],str[9]});
                    }
                } catch (java.lang.NullPointerException e) {
                    if (func == true) {
                        return m;
                    } else {
                        return null;
                    }
                }

            }
            return m;
        } catch (IOException e) {
            return null;
        }
    }

    public boolean autentication(String usuario, String senha) throws IOException {

        try {
            file = new RandomAccessFile("\\Hermes\\Usuarios" + "/" + usuario + ".txt", "r");

        } catch (Exception ex) {
            return false;
        }

        String str = file.readLine();
        if (senha.equals(str)) {

            return true;
        }
        return false;
    }

    public String leitura_Usuario(String nome) throws FileNotFoundException, IOException {
        File arquivo = new File("\\Hermes\\Usuarios" + "/" + nome + ".txt");
        if (!arquivo.exists()) {

            return "";
        } else {
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = nome;
            while (br.ready()) {
//lê a proxima linha
                linha += "\n" + br.readLine();

//faz algo com a linha
            }
            br.close();
            fr.close();

            return linha;
        }
    }

    public void iniciaArquivos() {
        try {
            File diretorio = new File("C:\\Hermes");
            diretorio.mkdir();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio");
            System.out.println(ex);
        }
        try {
            File diretorio = new File("C:\\Hermes\\Usuarios");
            diretorio.mkdir();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio");
            System.out.println(ex);
        }
        try {
            File diretorio = new File("C:\\Hermes\\Produtos");
            diretorio.mkdir();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio");
            System.out.println(ex);
        }

    }
}
