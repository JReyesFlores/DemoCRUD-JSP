package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LibroLogic {

	public List<LibroEntity> GetList() {
		Connection cn = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		ArrayList<LibroEntity> resultado = null;
		try {
			cn = ConnectionMySQL.open_connection();
			pr = cn.prepareStatement("select * from tabla_demo");
			rs = pr.executeQuery();
			resultado = new ArrayList<LibroEntity>();
			while (rs.next()) {
				resultado.add(
						new LibroEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
				if (pr != null)
					pr.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultado;
	}

	public LibroEntity GetLibroById(int id) {
		Connection cn = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		LibroEntity resultado = null;
		try {
			cn = ConnectionMySQL.open_connection();
			pr = cn.prepareStatement("select * from tabla_demo where id = ?");
			pr.setInt(1, id);
			rs = pr.executeQuery();
			while (rs.next()) {
				resultado = new LibroEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getDate(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
				if (pr != null)
					pr.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultado;
	}

	public int RegisterLibro(LibroEntity libro) {
		Connection cn = null;
		PreparedStatement pr = null;
		int resultado = -1;
		try {
			cn = ConnectionMySQL.open_connection();
			pr = cn.prepareStatement(
					"insert into tabla_demo(`NombreLibro`,`Autor`,`AnioPublicacion`,`Fecha`) values (?,?,?,?)");
			pr.setString(1, libro.getNombreLibro());
			pr.setString(2, libro.getAutor());
			pr.setInt(3, libro.getAnioPublicacion());
			pr.setDate(4, new java.sql.Date(libro.getFecha().getTime()));

			resultado = pr.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
				if (pr != null)
					pr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultado;
	}

	public int UpdateLibro(LibroEntity libro) {
		Connection cn = null;
		PreparedStatement pr = null;
		int resultado = -1;
		try {
			cn = ConnectionMySQL.open_connection();
			pr = cn.prepareStatement("update tabla_demo set NombreLibro=?, Autor=?, AnioPublicacion=?, Fecha=? where id=?");
			pr.setString(1, libro.getNombreLibro());
			pr.setString(2, libro.getAutor());
			pr.setInt(3, libro.getAnioPublicacion());
			pr.setDate(4, new java.sql.Date(libro.getFecha().getTime()));
			pr.setInt(5, libro.getId());

			resultado = pr.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
				if (pr != null)
					pr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultado;
	}

	public int DeleteLibro(int id) {
		Connection cn = null;
		PreparedStatement pr = null;
		int resultado = -1;
		try {
			cn = ConnectionMySQL.open_connection();
			pr = cn.prepareStatement("delete from tabla_demo where id = ?");
			pr.setInt(1, id);
			resultado = pr.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
				if (pr != null)
					pr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultado;
	}
}
