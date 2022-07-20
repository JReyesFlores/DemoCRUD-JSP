package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.LibroEntity;
import model.LibroLogic;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ServletsLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FORMATO_FECHA = "yyyy-MM-dd";

	public ServletsLibros() {
		super();
	}

	public static Date ConvertToDate(Object fecha) {
		if (fecha == null)
			return null;

		String valorFecha = fecha.toString();
		Date date = null;
		try {
			date = new SimpleDateFormat(FORMATO_FECHA).parse(valorFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Creamos la instancia a nuestra clase donde se implementan las funciones
		LibroLogic libros = new LibroLogic();

		// capturamos los valores que se obtienen desde el cliente
		String accion = request.getParameter("accion") != null ? request.getParameter("accion") : "";
		int id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
		String nombreLibro = request.getParameter("nombreLibro") != null ? request.getParameter("nombreLibro") : "";
		String autorLibro = request.getParameter("autorLibro") != null ? request.getParameter("autorLibro") : "";
		int anioPublicacion = request.getParameter("anioPub") != null
				? Integer.parseInt(request.getParameter("anioPub"))
				: 0;
		Date fecha = ConvertToDate(request.getParameter("fecha"));

		// Asignamos el formato de fecha que respondera el servlet
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		switch (accion) {
		case "R1":// read
			response.setContentType("application/json;charset=UTF-8");
			gson.toJson(libros.GetList(), response.getWriter());
			break;
		case "R2":// read
			response.setContentType("application/json;charset=UTF-8");
			gson.toJson(libros.GetLibroById(id), response.getWriter());
			break;

		case "C": // create
			new Gson().toJson(libros.RegisterLibro(new LibroEntity(0, nombreLibro, autorLibro, anioPublicacion, fecha)),
					response.getWriter());

			break;

		case "U": // update
			new Gson().toJson(libros.UpdateLibro(new LibroEntity(id, nombreLibro, autorLibro, anioPublicacion, fecha)),
					response.getWriter());
			break;

		case "D": // delete
			new Gson().toJson(libros.DeleteLibro(id), response.getWriter());
			break;

		default:
			break;
		}
	}
}
