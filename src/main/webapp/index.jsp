<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Libros</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-4">
		<div class="row">
			<div class="col">
				<h1>Evaluación Continua 2</h1>
				<button type="button" class="btn btn-secondary mt-4 mb-4"
					id="btnConsultar">Listar libros</button>
				<button type="button" class="btn btn-secondary mt-4 mb-4"
					id="btnNuevo" data-bs-toggle="modal" data-bs-target="#exampleModal">Nuevo
					libro</button>
				<h3>Lista de Libros</h3>
			</div>
		</div>

		<div class="row">
			<div class="col">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Nombre Libro</th>
								<th scope="col">Autor</th>
								<th scope="col">Año publicación</th>
								<th scope="col">Fecha</th>
								<th scope="col">Acciones</th>
							</tr>
						</thead>
						<tbody id="tbody"></tbody>
					</table>
				</div>
			</div>
		</div>

		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Nuevo Libro</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form id="formLibros">
							<div class="row">
								<div class="col">
									<input type="hidden" id="accionForm" name="accionForm" value="" />
									<div class="mb-2">
										<label for="txtId" class="form-label">Id.:</label> <input
											name="txtId" type="number" class="form-control" id="txtId"
											value="0" readonly="true" />
									</div>
									<div class="mb-2">
										<label for="txtNombreLibro" class="form-label">Nombre
											del libro:</label> <input name="txtNombreLibro" type="text"
											class="form-control" id="txtNombreLibro">
									</div>
									<div class="mb-2">
										<label for="txtAutorLibro" class="form-label">Autor
											del libro:</label> <input name="txtAutorLibro" type="text"
											class="form-control" id="txtAutorLibro">
									</div>
									<div class="mb-2">
										<label for="txtAnioPublicacion" class="form-label">Año
											de publicación:</label> <input name="txtAnioPublicacion"
											type="number" class="form-control" id="txtAnioPublicacion">
									</div>
									<div class="mb-2">
										<label for="txtFecha" class="form-label">Fecha de
											publicación:</label> <input name="txtFecha" type="date"
											class="form-control" id="txtFecha">
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Cancelar</button>
						<button type="button" class="btn btn-primary" id="btnRegistrar">Registrar</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="assets/js/main.js"></script>
</body>
</html>