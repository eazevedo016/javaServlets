package br.com.estudosServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudosServlet.acao.AlteraEmpresas;
import br.com.estudosServlet.acao.ListaEmpresas;
import br.com.estudosServlet.acao.MostraEmpresas;
import br.com.estudosServlet.acao.NovaEmpresas;
import br.com.estudosServlet.acao.RemoveEmpresas;



@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		String paramAcao = request.getParameter("acao");
		
		if(paramAcao.equals("ListaEmpresas")) {    

		    ListaEmpresas acao = new ListaEmpresas();
		    acao.executa(request, response);

		} else if(paramAcao.equals("RemoveEmpresas")) {
	
		    RemoveEmpresas acao = new RemoveEmpresas();
		    acao.executa(request, response);

		} else if(paramAcao.equals("MostraEmpresas")) {

		    MostraEmpresas acao = new MostraEmpresas();
		    acao.executa(request, response);
		    
		} else if(paramAcao.equals("AlteraEmpresas")) {

			AlteraEmpresas acao = new AlteraEmpresas();
		    acao.executa(request, response);
		}
		
		else if(paramAcao.equals("NovaEmpresas")) {

			NovaEmpresas acao = new NovaEmpresas();
		    acao.executa(request, response);
		}
		
	}

}
