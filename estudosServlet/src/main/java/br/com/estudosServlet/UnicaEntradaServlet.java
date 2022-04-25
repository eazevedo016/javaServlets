package br.com.estudosServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudosServlet.acao.Acao;
import br.com.estudosServlet.acao.AlteraEmpresas;
import br.com.estudosServlet.acao.ListaEmpresas;
import br.com.estudosServlet.acao.MostraEmpresas;
import br.com.estudosServlet.acao.NovaEmpresaForm;
import br.com.estudosServlet.acao.NovaEmpresas;
import br.com.estudosServlet.acao.RemoveEmpresas;



@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		String paramAcao = request.getParameter("acao");
		
		String nomeDaClasse = "br.com.estudosServlet.acao." + paramAcao;
		
		
		
		//dividirá a string nos dois tipos de redirecionamentos possíveis: forward:endereco | redirect:endereco
		
		
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		
		String[] tipoRedirecionamento = nome.split(":");
		if(tipoRedirecionamento[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoRedirecionamento[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoRedirecionamento[1]);
		}
		
		
		
//		if(paramAcao.equals("ListaEmpresas")) {    
//
//		    ListaEmpresas acao = new ListaEmpresas();
//		    nome = acao.executa(request, response);
//		    
//
//		} else if(paramAcao.equals("RemoveEmpresas")) {
//	
//		    RemoveEmpresas acao = new RemoveEmpresas();
//		    nome = acao.executa(request, response);
//
//		} else if(paramAcao.equals("MostraEmpresas")) {
//
//		    MostraEmpresas acao = new MostraEmpresas();
//		    nome = acao.executa(request, response);
//		    
//		} else if(paramAcao.equals("AlteraEmpresas")) {
//
//			AlteraEmpresas acao = new AlteraEmpresas();
//			nome = acao.executa(request, response);
//		} else if(paramAcao.equals("NovaEmpresas")) {
//
//			NovaEmpresas acao = new NovaEmpresas();
//			nome = acao.executa(request, response);
//		} else if(paramAcao.equals("NovaEmpresaForm")) {
//
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request, response);
//		}
		
		
		
		
	}
}
