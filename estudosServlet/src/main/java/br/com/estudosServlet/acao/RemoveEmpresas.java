package br.com.estudosServlet.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudosServlet.modelo.Banco;

public class RemoveEmpresas {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("removendo empresa");

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		banco.removeEmpresa(id);
		
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}

}
