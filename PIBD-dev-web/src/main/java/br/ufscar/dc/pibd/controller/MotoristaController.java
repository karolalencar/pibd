package br.ufscar.dc.pibd.controller;

import br.ufscar.dc.pibd.dao.MotoristaDAO;
import br.ufscar.dc.pibd.dao.CorridaDAO;
import br.ufscar.dc.pibd.domain.Motorista;
import br.ufscar.dc.pibd.domain.User;
import br.ufscar.dc.pibd.domain.Corrida;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

@WebServlet(urlPatterns = "/motoristas/*")
public class MotoristaController  extends HttpServlet{
        private static final long serialVersionUID = 1L;
	
	private MotoristaDAO dao;

    private CorridaDAO daoCorrida;
	
	@Override
        public void init() {
                dao = new MotoristaDAO();
        }
	
	@Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                doGet(request, response);
        }
	
	@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String action = request.getPathInfo();
                if (action == null) {
                action = "";
        }
        
        try {
            switch (action) {
                case "/corridas":
                    apresentaCorridasFeitas(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }

    }

    private void apresentaCorridasFeitas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User userLogged = (User) request.getSession().getAttribute("usuarioLogado");
        Motorista motoristaFisica = dao.getFisicaFromMotById(userLogged.getId()); // Recupera a pessoa fisica de motorista
        Integer year = (Integer) request.getAttribute("year");
        Integer month = (Integer) request.getAttribute("mes");

        if(year == null){
            year = Calendar.getInstance().get(Calendar.YEAR);
        }
        if(month == null){
            month = Calendar.getInstance().get(Calendar.MONTH);
        }

        List<Corrida> corridas = daoCorrida.getAllCorridasByMotoristaMesEAno(motoristaFisica.getCpf(), year, month);
        Double totalRecebido = dao.totalValorMotoristaMesEAno(motoristaFisica.getCpf(), year, month);
        Integer corridasTotais = dao.totalCorridasMotoristaMesEAno(motoristaFisica.getCpf(), year, month);

        request.setAttribute("corridas", corridas);
        request.setAttribute("totalRecebido", totalRecebido);
        request.setAttribute("corridasTotais", corridasTotais);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/motorista/corridasFeitas.jsp");

        dispatcher.forward(request, response);
    }
}