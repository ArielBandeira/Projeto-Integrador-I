import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.MercadoriaDAO;
import dao.MercadoriaDAOImpl;
import model.Mercadoria;

public class Principal {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Escolha a opcao");
		System.out.println("1 - Criar entrada");
		System.out.println("2 - Atualizar entrada");
		System.out.println("3 - Procurar por nome");
		System.out.println("4 - Listar todos");
		System.out.println("5 - Vender");
		
		int o = s.nextInt();
		Mercadoria m = new Mercadoria();
		MercadoriaDAO mDao = new MercadoriaDAOImpl();
		List<Mercadoria> l = null;
		switch (o) {
		case 1:
			System.out.println();
			System.out.println();
			System.out.println("Insira o nome da agua");
			m.setNome(s.next());
			System.out.println("Insira a quantidade da agua");
			m.setQuantidade(s.nextInt());
			System.out.println("Insira a data de entrada da agua");
			m.setEntrada(s.next());
			System.out.println("Insira a data de saida da agua");
			m.setSaida(s.next());
			System.out.println("Insira o preco da agua");
			m.setPreco(s.nextFloat());
			mDao.create(m);
			break;
		case 2:
			System.out.println();
			System.out.println();
			System.out.println("Insira o nome a ser atualizado");
			m = mDao.findByName(s.next());
			System.out.println("Insira a quantidade da �gua");
			m.setQuantidade(s.nextInt());
			System.out.println("Insira a data de entrada da �gua");
			m.setEntrada(s.next());
			System.out.println("Insira a data de saida da �gua");
			m.setSaida(s.next());
			System.out.println("Insira o pre�o da �gua");
			m.setPreco(s.nextFloat());
			mDao.update(m);
			break;		
		case 3:
			System.out.println();
			System.out.println();
			System.out.println("Insira o nome a ser pesquisado");
			m = mDao.findByName(s.next());
			System.out.println("Objeto recuperado:");
			System.out.println("Nome: "+m.getNome()+" Quantidade: "+m.getQuantidade()+" Preco: "+m.getPreco());
		break;
		case 4:
			System.out.println();
			System.out.println();
			System.out.println("Lista de objetos");
			l = mDao.findAll();
			for (Mercadoria m1 : l) {
				System.out.println("Objeto recuperado:");
				System.out.println("Nome: "+m1.getNome()+" Quantidade: "+m1.getQuantidade()+" Preco: "+m1.getPreco());	
			}
		break;	
		case 5:
			System.out.println();
			System.out.println();
			System.out.println("Insira o nome da agua para venda");
			m = mDao.findByName(s.next());
			System.out.println("Quantas aguas?");
			int i = s.nextInt();
			m.setQuantidade(m.getQuantidade() - i);
			mDao.update(m);
			//rDao.create(new RegistroDeVenda(m.getNome(), i, "24/07/2019"));
			break;		
		}
		
	}

}
