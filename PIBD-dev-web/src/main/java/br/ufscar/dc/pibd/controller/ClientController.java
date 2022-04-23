package br.ufscar.dc.pibd.controller;

import br.ufscar.dc.pibd.dao.ClientDAO;
import br.ufscar.dc.pibd.dao.CorridaDAO;
import br.ufscar.dc.pibd.dao.faturaDAO;
import br.ufscar.dc.pibd.domain.Client;
import br.ufscar.dc.pibd.domain.User;
import br.ufscar.dc.pibd.domain.Corrida;
import br.ufscar.dc.pibd.domain.Fatura;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/clients/*")
public class ClientController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ClientDAO dao;

    private CorridaDAO daoCorrida;

    private faturaDAO daoFatura;

    @Override
    public void init() {
        dao = new ClientDAO();
        daoFatura = new faturaDAO();
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
                case "/faturaMes":
                    apresentaFaturaMes(request, response);
                    break;
                case "/home":
                    apresentaHome(request, response);
                    break;
                case "/detalheCorrida":
                    apresentaDetalheCorrida(request, response);
                    break;

            }
        } catch (RuntimeException | IOException | ServletException e) {
            System.out.print("cheguei no exception");
            throw new ServletException(e);
        }

    }

    private void apresentaFaturaMes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User userLogged = (User) request.getSession().getAttribute("usuarioLogado");
        request.setAttribute("usuarioLogado", userLogged);

        String cnpj = dao.getCnpjById((int) (long) userLogged.getId());
        String mesStr = request.getParameter("mes");
        mesStr = "2020-" + mesStr + "-30";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date data_criacao = sdf.parse(mesStr);
            Fatura fatura = daoFatura.getFaturaByCnpjDataCriacao(cnpj, data_criacao.getTime());
            request.setAttribute("valor_total", daoFatura.getValorFaturaPorId(fatura.getId()));
            request.setAttribute("num_corridas", daoFatura.getNumCorridasFaturaPorId(fatura.getId()));
            request.setAttribute("fatura", fatura);
            request.setAttribute("corridas", daoFatura.getCorridasByFaturaId(fatura.getId()));

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/client/faturaMes.jsp");

        dispatcher.forward(request, response);
    }

    private void apresentaHome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User userLogged = (User) request.getSession().getAttribute("usuarioLogado");
        request.setAttribute("usuarioLogado", userLogged);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaDetalheCorrida(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer idCorrida = Integer.parseInt(request.getParameter("id"));
        Corrida corrida = daoCorrida.getCorridaById(idCorrida);
        request.setAttribute("corrida", corrida);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/client/detalheCorrida.jsp");
        dispatcher.forward(request, response);

    }
}
