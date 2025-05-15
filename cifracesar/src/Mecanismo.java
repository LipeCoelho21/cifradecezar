import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Mecanismo {

    public void executarCripto(String arquivoTexto, String arquivoCripto) {
        ArrayList<Character> bufferPrimario = new ArrayList<>();
        BufferedReader leitor = null;

        try {
            // Leitura do arquivo de entrada
            leitor = new BufferedReader(new FileReader(arquivoTexto));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                for (char c : linha.toCharArray()) {
                    bufferPrimario.add(c);
                }
                bufferPrimario.add('\n');
            }
            leitor.close();

            // Entrada da chave
            System.out.print("Digite a chave da Cifra de César: ");
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            int chave = Integer.parseInt(teclado.readLine());

            // Criptografia
            StringBuilder texto = new StringBuilder();
            for (Character c : bufferPrimario) {
                texto.append(c);
            }

            CifraCesar cifra = new CifraCesar(chave);
            String textoCriptografado = cifra.criptografar(texto.toString());

            // Escrita no arquivo de saída
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoCripto));
            escritor.write(textoCriptografado);
            escritor.close();

            System.out.println("Criptografia concluída!");

        } catch (IOException e) {
            System.out.println("Erro ao criptografar: " + e.getMessage());
        }
    }

    public void executarDecripto(String entradaCripto, String saidaDecripto) {
        ArrayList<Character> bufferPrimario = new ArrayList<>();
        BufferedReader leitor = null;

        try {
            // Leitura do arquivo criptografado
            leitor = new BufferedReader(new FileReader(entradaCripto));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                for (char c : linha.toCharArray()) {
                    bufferPrimario.add(c);
                }
                bufferPrimario.add('\n');
            }
            leitor.close();

            // Entrada da chave
            System.out.print("Digite a mesma chave usada: ");
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            int chave = Integer.parseInt(teclado.readLine());

            // Descriptografia
            StringBuilder texto = new StringBuilder();
            for (Character c : bufferPrimario) {
                texto.append(c);
            }

            CifraCesar cifra = new CifraCesar(chave);
            String textoDescriptografado = cifra.descriptografar(texto.toString());

            // Escrita no arquivo de saída
            BufferedWriter escritor = new BufferedWriter(new FileWriter(saidaDecripto));
            escritor.write(textoDescriptografado);
            escritor.close();

            System.out.println("Descriptografia concluída!");

        } catch (IOException e) {
            System.out.println("Erro ao descriptografar: " + e.getMessage());
        }
    }
}
