/**
 * Semplice test per il package Decorator
 */
package testing;


import java.sql.SQLException;

import decorator.*;
/**
 * @author Alessandro
 *
 */
public class DecoratorTest {


	/**
	 * @param args
	 * @throws SQLException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws IllegalArgumentException, SQLException {
		
		/*
		 * La creazione dell'utente non passa più dal Decorator, ma avviene tramite il Proxy(vedi sotto)
		 * 
		 * AbstractUser utente = new User(); //Creato un utente
		 * System.out.println("Chi sei? \n");
		 * utente.getRuolo();
		 * 
		 * utente = new CreatorDecorator(utente);
		 * System.out.println("Chi sei adesso?");
		 * utente.getRuolo();
		 */
		
		String nome = "Alessandro";
		String pwd = "qwerty";
		String ruolo = "Customer";
		
		/*
		 * Utilizzo il proxy per creare un utente e svolgere alcune semplici operazioni su di lui:
		 * ne memorizzo il nome utente, la pwd, il ruolo e richiamo l'operazione di login.
		 */
		
		System.out.println("Creazione Proxy per un utente...");
		ProxyUser utenteProxy = new ProxyUser(); //Creato nuovo ProxyUtente
		
		utenteProxy.setUsername(nome);
		utenteProxy.setPwd(pwd);
		utenteProxy.setRuolo(ruolo);
		
		System.out.println("Restituisco le informazioni sull'utente... \n");
		
		String nomeUtente = utenteProxy.getUsername(); 
		String password = utenteProxy.getPwd(); 
		String role = utenteProxy.getRuolo(); 
		
		System.out.println("Ciao a tutti, sono l'utente: " + nomeUtente +"\nla mia password è: "+password+"\nil mio ruolo è "+role);
		
		System.out.println("Effettuo il login");
		
		utenteProxy.login("","");
		
		//System.out.println("Utilizzo il decorator per aggiungere la funzionalità di Creator ad Alessandro");
		
		
		
		/*
		 * Una volta effettuato il login utilizzo un oggetto di tipo User che rappresenta un utente generico 
		 * per salvare le inforazioni precedentemente archiviate nel Proxy
		 */
		
		//AbstractUserComponent utenteReale = new ProxyUser();
		//User utenteReale = new User();
		User utenteReale = utenteProxy.getUser();
		
		
		
		//Decidere se fondere l'interfaccia AbstractUser con AbstractUserComponent
		
		/*
		 * Creo un nuovo utente generico a partire dall'interfaccia AUC 
		 * AbstractUserComponent uR = new User("","","");
		 * 
		 * Creo un nuovo utente Customer a partire dall'interfaccia AUC
		 * AbstractUserComponent uR = new Customer("","","");
		 * 
		 * Creo un nuovo utente TA a partire dall'interfaccia AUC
		 * AbstractUserComponent uR = new TA("","","");
		 * 
		 * A partire da un utente Customer o un utente TA, decoro con la funzionalità di creator
		 * uR = new CreatorDecoratorCustomer(uR) 
		 * 
		 */
		
		
		System.out.println("Adesso sono un utente Reale!\n");
		System.out.println("Restituisco le informazioni sull'utente... \n");
		
		nomeUtente = utenteReale.getUsername(); 
		password = utenteReale.getPwd(); 
		role = utenteReale.getRuolo();
		
		System.out.println("il mio nome è: " + nomeUtente +"\nla mia password è: "+password+"\nil mio ruolo è "+role);
		
		System.out.println("\nDecoro l'utente Reale con la funzionalità di creator");
		
		DecoratorUser userDec = null;
		userDec = DecoratorUser.decora(utenteReale);
		System.out.println("\nDecoro nuovamente l'utente Reale con la funzionalità di creator");
		userDec = DecoratorUser.decora(utenteReale);
		userDec = DecoratorUser.decora(utenteReale);
		userDec = DecoratorUser.decora(utenteReale);
		userDec = DecoratorUser.decora(utenteReale);
		userDec = DecoratorUser.decora(utenteReale);
		
		//Recupero nuovamente il ruolo dell'utente
		role = userDec.getRuolo();
		System.out.println("\nQual'è il tuo ruolo adesso?");
		System.out.println("\nil mio ruolo è "+role);
		
		Object o;
		Object t = new Object();
		o = t;
		
		/*
		 * TO-DO_2: PATTERN GRASP CONTROLLER (managementController, searchController)
		 */
	}

}
