package br.com.estudosServlet.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudosServlet.modelo.Banco;
import br.com.estudosServlet.modelo.Empresa;

public class MostraEmpresas {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("mostrando empresa");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaEmpresaPelaId(id);
		
		request.setAttribute("empresa", empresa);
		RequestDispatcher rd = request.getRequestDispatcher("formAlteraEmpresa.jsp");
		rd.forward(request, response);
		
		
	}

}
