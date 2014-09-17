package controllerMVC;

import decorator.*;
import composite.*;

import java.io.IOException;
import java.sql.SQLException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.SearchController;

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
        
        /*
        if(operazione.equals("addItineraryStay")) {
        	StayTemplate st = searchController.searchStay();
        	session.setAttribute("elencoTappe", elenco);
        	forward(request, response, "/searchStayTemplate.jsp");
        }
        */
        
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
        
        //Mostra itinerari dell'utente
        if(operazione.equals("elencoItinerari")) {
        	System.out.println("utente: " + proxy.getUser().getUsername());
        	SearchController.searchMyItinerary(proxy.getUser());
        	session.setAttribute("proxy", proxy);
        	forward(request, response, "/viewElencoItinerari.jsp");
        }
        
        
        

	}//Fine processRequest
}//Fine Controller
