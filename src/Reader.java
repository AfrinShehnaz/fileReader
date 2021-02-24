import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
//import java.util.Map;
import java.util.Objects;


public class Reader {

	public static void main(String[] args) throws IOException {
		String name;
		BufferedReader reader=new  BufferedReader(new InputStreamReader(System.in));
		// TODO Auto-generated method stub
		final List<String> bankAccount= Files.readAllLines(Paths.get("C:\\Filereader\\bankaccount.txt"));
        final List<String> bankTransaction= Files.readAllLines(Paths.get("C:\\Filereader\\banktransactions.txt"));
        final List<String> finalResult=new LinkedList();
        finalResult.add("Name, Age, Gender, Bank, CardNumber, TransactionDate, Amount");
        bankAccount.remove(0);
        bankTransaction.remove(0);
        for(String str1:bankAccount) { 
            String[] s1=str1.split(",");
            for(String str2:bankTransaction) {
                String[] s2=str2.split(",");
                if(Objects.equals(s1[4],s2[0])) 
                    finalResult.add(s1[0]+" , "+s1[1]+" , "+s1[2]+" , "+s1[3]+" , "+s1[4]+" , "+s2[1]+" , "+s2[2]);
                }
            }
        Files.write(Paths.get("C:\\Filereader\\info.txt"),finalResult);
        System.out.println("Enter the Account holder name:");
        name=reader.readLine();
        Files.lines(Paths.get("C:\\Filereader\\info.txt")).filter(str1->str1.contains(name)).forEach(System.out::println);

    }
	}


