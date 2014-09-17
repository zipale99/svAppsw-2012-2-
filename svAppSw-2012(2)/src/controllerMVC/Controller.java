package controllerMVC;

import decorator.*;
import composite.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import resources.Activity;
import resources.Option;
import resources.OptionValue;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
		} catch (SQLException e) { e.printStackTrace(); }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String page) 
			throws ServletException, IOException {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(page);
			rd.forward(request,response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalArgumentException, SQLException {
        
		//recupero l'operazione scelta dall'utente e l'oggetto in sessione utente
		String operazione = (String)request.getParameter("operazione");
		HttpSession session = request.getSession();
		  
        ProxyUser proxy = null;
        DecoratorUser utenteDecorato = null;
              
        if(operazione == null) {
        	System.out.println("Operazione uguale uguale a null");
            if(session.isNew()) {
                System.out.println("creoProxy: "+ operazione);
                proxy = new ProxyUser();
                session.setAttribute("proxy", proxy);
                utenteDecorato = null;
                session.setAttribute("userDec", utenteDecorato);
            }
            else{
                proxy = (ProxyUser)session.getAttribute("proxy");
            }
            forward(request, response,"/login.jsp");
        }
        else { //Se l'operazione è diversa da null recupero dalla sessione utente gli oggetti proxy e decoratorUser
        	System.out.println("Operazione diversa da null");
        	proxy = (ProxyUser)session.getAttribute("proxy");
            utenteDecorato = (DecoratorUser)session.getAttribute("utenteDecorato");
        }   
            
        /*
         * Recupero i parametri username e password dalla richiesta effettuata dall'utente
         * Li passo al metodo login di proxyUser, se ritorna true, allora assegno il getUser()
         * del proxy a session, altrimenti invalido la sessione.
         */
        if(operazione.equals("login")){
        	proxy = new ProxyUser();
        	if(proxy.login(request.getParameter("user"), request.getParameter("password"))) {
        		session.setAttribute("proxy", proxy);
                forward(request, response, "/Index.jsp");
        	}
            else {
               	request.getSession().invalidate();
    			forward(request, response,"/Index.jsp");
            }
        }
        
		if(operazione.equals("logout")){
			request.getSession().invalidate();
			utenteDecorato.invalida();
			forward(request, response, "/Index.jsp");
		}
        
        
        if(operazione.equals("manageItinerary")) {
        	if (utenteDecorato == null)
                utenteDecorato = DecoratorUser.decora(proxy.getUser());
        	session.setAttribute("utenteDecorato", utenteDecorato);
        	forward(request, response, "/manageItinerary.jsp");
        }
        
        if(operazione.equals("confermaBasicInfo")) {
        	String nome = request.getParameter("nome");
        	String descrizione = request.getParameter("descrizione");
        	String categoria = request.getParameter("categoria");
        	Itinerary itinerario = new Itinerary(utenteDecorato.getUsername(), nome, descrizione, categoria);
        	session.setAttribute("itinerario", itinerario);
        	forward(request, response, "/creaItinerario.jsp");
        }
        
        
        if(operazione.equals("creaItinerario")) {
        	forward(request, response, "/basicInfo.jsp");
        }
        
        if(operazione.equals("addItineraryStay")) {
        	//StayTemplate st = searchController.searchStay();
        	
        	//Creo delle Attività
    		Activity attivita1 = new Activity(1, "Culturale", "Roma", "Visita Colosseo", 2, 20, 1, true);
    		Activity attivita2 = new Activity(2, "Culturale", "Roma", "Fori romani", 8, 0, 1, false);
    		Activity attivita3 = new Activity(3, "Culturale", "Roma", "Pantheon", 1, 10, 1, false);
    		Activity attivita4 = new Activity(4, "Culturale", "Torino", "Visita a superga", 3, 15, 1, false);
    		Activity attivita5 = new Activity(5, "Culturale", "Torino", "Salita Mole Antoneliana", 1, 10, 1, false);
    		Activity attivita6 = new Activity(6, "Culturale", "Torino", "visita alla Cappella della sacra sindone", 1, 10, 1, false);
    		Activity attivita7 = new Activity(7, "Culturale", "Milano", "Duomo", 2, 20, 1, false);
    		Activity attivita8 = new Activity(8, "Culturale", "Milano", "Navigli", 2, 20, 1, false);
    		
    		//Compongo dei pacchetti di attività da aggiungere alle tappe che saranno proposte agli utenti
    		List<Activity> listaAtt1 = new ArrayList<Activity>();
    		List<Activity> listaAtt2 = new ArrayList<Activity>();
    		List<Activity> listaAtt3 = new ArrayList<Activity>();
    		listaAtt1.add(attivita1);
    		listaAtt1.add(attivita2);
    		listaAtt1.add(attivita3);
    		listaAtt2.add(attivita4);
    		listaAtt2.add(attivita5);
    		listaAtt2.add(attivita6);
    		listaAtt3.add(attivita7);
    		listaAtt3.add(attivita8);
    		
    		//Creo delle opzioni
    		Option opt1 = new Option(1, "Servizio in Camera", "Permette di specificare se si vuole il servizio in camera", "NO");
    		Option opt2 = new Option(2, "Frigo-bar", "Permette di specificare si vuole il frigo bar", "NO");
    		Option opt3 = new Option(3, "Trasporto", "Permette di specificare la tipologia di trasporto", "AUTO");
    		Option opt4 = new Option(4, "Pernottamento", "Permette di scegliere una soluzione per il pernottamento", "HOTEL");
    		
    		//Recupero(creo) una serie di valori per le opzioni appena create
    		opt1.add(new OptionValue("SI", 50));
    		opt1.add(new OptionValue("NO", 0));
    		opt2.add(new OptionValue("SI", 20));
    		opt2.add(new OptionValue("NO", 0));
    		opt3.add(new OptionValue("AUTO", 200));
    		opt3.add(new OptionValue("TRENO", 350));
    		opt3.add(new OptionValue("PULMANN", 100));
    		opt4.add(new OptionValue("ALBERGO", 200));
    		opt4.add(new OptionValue("PENSIONE-COMPLETA", 400));
    		opt4.add(new OptionValue("MEZZA-PENSIONE", 250));
    		opt4.add(new OptionValue("HOTEL", 300));
    		opt4.add(new OptionValue("BED & BREAKFAST", 170));
    		
    		
    		//Creo liste di opzioni da poter aggiungere ai Leaf
    		List<Option> listaOpt1 = new ArrayList<Option>();
    		List<Option> listaOpt2 = new ArrayList<Option>();
    		listaOpt1.add(opt1);
    		listaOpt1.add(opt2);
    		listaOpt1.add(opt4);
    		listaOpt2.add(opt3);
    		
    		//Creo una serie di leaf con le opzioni associate
    		StayTemplateLeaf leaf1 = new Transport("pulmann", "torino", "roma", 6, "to-ro", 100, -1, listaOpt2);
    		StayTemplate leaf2 = new Transport("pulmann", "roma", "milano", 6, "to-mi", 200, -1, listaOpt2);
    		StayTemplate leaf3 = new Transport("pulmann", "roma", "torino", 2, "to-ud", 300, -1, listaOpt2);
    		StayTemplate leaf4 = new Accomodation("Hotel","Bello","5 stelle", "torino", "torino", 2, "to-Acc", 500, -1, listaOpt1);
    		
    		//creo tappe composite
    		StayTemplate tappaComposita1 = new StayTemplateComposite("torino", "milano", 12, "to-mi", 500, listaAtt1);
    		StayTemplate tappaComposita2 = new StayTemplateComposite("roma", "torino", 12, "ro-to", 700, listaAtt2);
    				
    	
    		//Compongo le tappe composite
    		tappaComposita1.add(leaf1);
    		tappaComposita1.add(leaf2);
    		
    		tappaComposita2.add(leaf1);
    		tappaComposita2.add(leaf3);
    		tappaComposita2.add(leaf4);
    		
    		StayTemplate elenco = new StayTemplateComposite();
    		elenco.add(tappaComposita1);
    		elenco.add(tappaComposita2);
        	
        	session.setAttribute("elencoTappe", elenco);
        	forward(request, response, "/searchStayTemplate.jsp");
        }
        
        if(operazione.equals("addStayTemplate")) {
        	/*
        	 * TO-DO: recuperare le tappe composite presente in elencoTappe, controllare se eventualmente 
        	 * c'è ne solo una. Recupera quella con id uguale a idTappa. Passare il composite a 
        	 * coonfigureStayParameter ed effettuare il recupero dei leaf dalla jsp.
        	 */
        	int idStay = Integer.parseInt(request.getParameter("idTappa"));
        	StayTemplateComposite st = (StayTemplateComposite)session.getAttribute("elencoTappe");
        	session.setAttribute("tappa", st.getStayTemplate(idStay));
        	forward(request, response, "/configureStayParameter.jsp");
        }
        

	}//Fine processRequest
}//Fine Controller
