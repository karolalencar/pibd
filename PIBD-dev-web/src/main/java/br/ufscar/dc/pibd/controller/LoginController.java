package br.ufscar.dc.pibd.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.ufscar.dc.pibd.domain.User;
import br.ufscar.dc.pibd.dao.UserDAO;
import br.ufscar.dc.pibd.util.Error;

@WebServlet(name = "Login", urlPatterns = {"/login/*", "/logout.jsp"})
public class LoginController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Error erros = new Error();
        if (request.getParameter("clienteOK") != null && request.getParameter("clienteOK") != "cliente_login=&cliente_senha="){			
		    String login = request.getParameter("cliente_login");
			String password= request.getParameter("cliente_senha");
			
			if (login == null || login.isEmpty()) {
				erros.add("Login não informado!");
			}

			if (password == null || password.isEmpty()) {
				erros.add("Senha não informada!");
			}
			if (!erros.isExisteErros()) {
				UserDAO daoUser = new UserDAO();
				User user = daoUser.getUserbyLogin(login);
				if (user != null) {
                    if (daoUser.getPassed(user.getEmail(), user.getPassword())) {
                        request.getSession().setAttribute("clienteLogado", user);
                        
                        String URL = "/index.jsp";
                        RequestDispatcher rd = request.getRequestDispatcher(URL);
                        rd.forward(request, response);
                        return;
                    }else{
                        erros.add("Senha inválida!");
                    }	
				}
			}
		}
	
        request.getSession().invalidate();
		request.setAttribute("mensagens", erros);
		String URL = "/login.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(URL);
		rd.forward(request, response);
    }
}

	