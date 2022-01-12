package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.*;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            Map<String, Integer> registros = new LinkedHashMap<>();

            String line = br.readLine();
            while (line != null) {

                String[] fields = line.split(",");
                String candidato = fields[0];
                Integer votos = Integer.parseInt(fields[1]);

                if(!registros.containsKey(candidato)){
                    registros.put(candidato,votos);
                }else{
                    int aux = registros.get(candidato) + votos;
                    registros.put(candidato,aux);
                }

                line = br.readLine();
            }

            for(String chave : registros.keySet()){
                System.out.println(chave + ": " + registros.get(chave));
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
