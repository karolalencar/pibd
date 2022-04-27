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
import java.util.ArrayList;

@WebServlet(urlPatterns = "/motoristas/*")
public class MotoristaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private MotoristaDAO dao;

    private CorridaDAO daoCorrida;

    @Override
    public void init() {
        dao = new MotoristaDAO();
        daoCorrida = new CorridaDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

    private void apresentaCorridasFeitas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User userLogged = (User) request.getSession().getAttribute("usuarioLogado");

        Motorista motoristaFisica = dao.getFisicaFromMotById(userLogged.getId()); // Recupera a pessoa fisica de motorista
        
        String mesAno = request.getParameter("monthYear");
        Integer year = null;
        Integer month = null;

        List<Corrida> corridas = new ArrayList<>();
        Double totalRecebido = 0.0;
        Integer corridasTotais = 0;


        if(mesAno!=null){
            String []yearMonth = mesAno.split("-");
            year = Integer.parseInt(yearMonth[0]);
            month = Integer.parseInt(yearMonth[1]);
        }


        if (year == null) {
            year = Calendar.getInstance().get(Calendar.YEAR);
        }

        if(month == null){
            month = Calendar.getInstance().get(Calendar.MONTH); 
            month = month + 1;  
        }

        corridas = daoCorrida.getAllCorridasByMotoristaMesEAno(motoristaFisica.getCpf(), year, month);
        totalRecebido = dao.totalValorMotoristaMesEAno(motoristaFisica.getCpf(), year, month);
        corridasTotais = dao.totalCorridasMotoristaMesEAno(motoristaFisica.getCpf(), year, month);

        request.setAttribute("corridas", corridas);
        request.setAttribute("totalRecebido", totalRecebido);
        request.setAttribute("corridasTotais", corridasTotais);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/motorista/corridasFeitas.jsp");

        dispatcher.forward(request, response);
    }
}