package alunos;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 1 ;
		
		
		
		int operacao;
		String codigo,nome,idade,cpf,telefone,endereco;
		AlunosDAO aluno= new AlunosDAO();
		Scanner ler = new Scanner(System.in);
		System.out.println ("Digite a operação desejada: 1- Insert \n2-Update " +
                "\n3- Delete com código \n4-Delete com cpf \n5- Consulta");
		operacao = ler.nextInt();
		
		
		if (operacao==1){
			Scanner lerCodigo = new Scanner(System.in);  
			System.out.println("Digite o código do aluno(a): ");
			codigo = lerCodigo.nextLine();
			
			Scanner lerNome = new Scanner(System.in);  
			System.out.println("Digite o nome do aluno(a): ");
			nome = lerNome.nextLine();
			
			Scanner lerIdade = new Scanner(System.in);  
			System.out.println("Digite a idade do aluno(a): ");
			idade = lerIdade.nextLine();
			
			Scanner lerCpf = new Scanner(System.in);  
			System.out.println("Digite o cpf do aluno(a): ");
			cpf = lerCpf.nextLine();
			
			Scanner lerTelefone = new Scanner(System.in);  
			System.out.println("Digite o telefone do aluno(a): ");
			telefone = lerTelefone.nextLine();
			
			Scanner lerEndereco = new Scanner(System.in);  
			System.out.println("Digite o endereço do aluno: ");
			endereco = lerEndereco.nextLine();
			
			aluno.insert(codigo, nome, idade, cpf, telefone, endereco);
			lerCodigo.close();
			lerNome.close();
			lerIdade.close();
			lerCpf.close(); 
			lerTelefone.close();
			lerEndereco.close();
			
			
		}
		
		else if(operacao==2){
			Scanner lerCodigo = new Scanner(System.in);  
			System.out.println("Digite o código do aluno(a): ");
			codigo = lerCodigo.next();
			
			Scanner lerNome = new Scanner(System.in);  
			System.out.println("Digite o nome do aluno(a): ");
			nome = lerNome.next();
			
			Scanner lerIdade = new Scanner(System.in);  
			System.out.println("Digite a idade do aluno(a): ");
			idade = lerIdade.next();
			
			Scanner lerCpf = new Scanner(System.in);  
			System.out.println("Digite o cpf do aluno(a): ");
			cpf = lerCpf.next();
			
			Scanner lerTelefone = new Scanner(System.in);  
			System.out.println("Digite o telefone do aluno(a): ");
			telefone = lerTelefone.next();
			
			Scanner lerEndereco = new Scanner(System.in);  
			System.out.println("Digite o endereço do aluno: ");
			endereco = lerEndereco.next();
			
			aluno.update(codigo, nome, idade, cpf, telefone, endereco);
			lerCodigo.close();
			lerNome.close();
			lerIdade.close();
			lerCpf.close(); 
			lerTelefone.close();
			lerEndereco.close();
			
		}
		
		else if(operacao ==3){
			Scanner lerCodigo = new Scanner(System.in);       
            System.out.println ("Digite o codigo do aluno: ");
             codigo = lerCodigo.next();
            aluno.deleteCod(codigo);
            lerCodigo.close();
            
		}
		else if(operacao == 4){
			Scanner lerCpf = new Scanner(System.in);       
            System.out.println ("Digite o cpf do aluno: ");
             cpf = lerCpf.next();
            aluno.deleteCod(cpf);
            lerCpf.close();
          
		}
		else if(operacao == 5){
			Scanner codCpf = new Scanner(System.in);
			System.out.println("Digite o cpf do aluno:");
			cpf=codCpf.next();
			AlunosTO al = new AlunosTO();
			al.setCpf(cpf);
			
			al = (AlunosTO) aluno.consultaAlunos(cpf);
			System.out.println("Codigo: " + al.getCodigo()+ " Nome: " + al.getNome() + " Idade: "+
			al.getIdade()+  " CPF: " + al.getCpf()+" Telefone: " + al.getTelefone()+" Endereço: "+ al.getEndereco());
            codCpf.close();
			 
           
			
		}
		
	}

}
