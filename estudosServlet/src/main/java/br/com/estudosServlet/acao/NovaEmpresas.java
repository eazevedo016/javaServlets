package br.com.estudosServlet.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudosServlet.modelo.Banco;
import br.com.estudosServlet.modelo.Empresa;

public class NovaEmpresas {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		//lendo os parametros da request
		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
        Banco banco = new Banco();
        banco.adiciona(empresa);
        
        response.sendRedirect("entrada?acao=ListaEmpresas");
	}

}
