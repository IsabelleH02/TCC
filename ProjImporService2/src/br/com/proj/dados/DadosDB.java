package br.com.proj.dados;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.proj.model.Dados;
import br.com.proj.util.ConnectionFactory;

public class DadosDB {

	Connection conn;
	Statement ps;

	public DadosDB() {
		conn = ConnectionFactory.getConnection();
	}

	public boolean insert(Dados d) {
		try {
			ps = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append(" INSERT INTO TB_DADOS( ");
			sql.append("id,");
			sql.append("name,");
			sql.append("description,");
			sql.append("latitude,");
			sql.append("longitude,");
			sql.append("field1,");
			sql.append("field2,");
			sql.append("created_at,");
			sql.append("updated_at,");
			sql.append("last_entry_id");
			sql.append(") ");
			sql.append(" VALUES( ");
			sql.append("'" + d.getId() + "',");
			sql.append("'" + d.getName() + "',");
			sql.append("'" + d.getDescription() + "',");
			sql.append("'" + d.getLatitude() + "',");
			sql.append("'" + d.getLongitude() + "',");
			sql.append("'" + d.getField1() + "',");
			sql.append("'" + d.getField2() + "',");
			sql.append("'" + d.getCreated_at() + "',");
			sql.append("'" + d.getUpdated_at() + "',");
			sql.append("'" + d.getLast_entry_id() + "' ");
			sql.append(");");

			System.out.println(sql.toString());
			ps.execute(sql.toString());
			ps.close();
			conn.close();
			return true;
		} catch (SQLException ex) {
			System.err.println("Erro: " + ex.getMessage());
			ex.printStackTrace();
			return false;
		}
	}
}
