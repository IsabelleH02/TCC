package br.com.proj.servico;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.proj.dados.DadosDB;
import br.com.proj.model.Dados;
import br.com.proj.util.ManipulaService;

@WebServlet("/ServDados")
public class ServDados extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServDados() {
		super();
	}
//recuperar os dados pelo metodo post 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Dados d = new Dados();
		d.setId(request.getParameter("id"));
		d.setName(request.getParameter("name"));
		d.setField1(request.getParameter("field1"));
		d.setCreated_at(request.getParameter("created_at"));
		d.setUpdated_at(request.getParameter("updated_at"));

		// Inerir no bando de dados
		new DadosDB().insert(d);
	}
	//Desligar o serviço
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");		
		if (acao.equals("desligar")){
			ManipulaService.shut_server();
			System.out.println("Serviço Desligado!");
		}
	}
}
