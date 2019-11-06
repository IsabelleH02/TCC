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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Dados d = new Dados();
		d.setId(request.getParameter("id"));
		d.setName(request.getParameter("name"));
		d.setDescription(request.getParameter("description"));
		d.setLatitude(request.getParameter("latitude"));
		d.setLongitude(request.getParameter("longitude"));
		d.setField1(request.getParameter("field1"));
		d.setField2(request.getParameter("field2"));
		d.setCreated_at(request.getParameter("created_at"));
		d.setUpdated_at(request.getParameter("updated_at"));
		d.setLast_entry_id(request.getParameter("last_entry_id"));

		// Inerir no bando de dados
		new DadosDB().insert(d);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.err.println("PASSSSSAAAAAA");
		
		String acao = req.getParameter("acao");
		
		System.out.println("Entrei aqui: "+ acao);
		if (acao.equals("desligar")){
			ManipulaService.shut_server();
		}
	}
}
