$(document).ready(function() {
	//alert('JQuery cargado!');
	let btnNuevo = $('#btnNuevo');
	let btnRegistrar = $('#btnRegistrar');
	let btnConsultar = $('#btnConsultar');
	let tbody = $('#tbody');

	const cargarDatosById = function(id) {
		$.ajax({
			url: 'ServletsLibros',
			type: 'GET',
			data: { accion: 'R2', id: id },
			success: function(response) {
				console.log(response);
				$('#exampleModalLabel').text('Editar Libro');
				$('#btnRegistrar').text('Actualizar');
				$('#txtId').val(response.Id);
				$('#txtNombreLibro').val(response.NombreLibro);
				$('#txtAutorLibro').val(response.Autor);
				$('#txtAnioPublicacion').val(response.AnioPublicacion);
				$('#txtFecha').val(response.Fecha);
				$('#exampleModal').modal('show');
			},
			error: function(jqXHR, status, error) {
				console.log(error);
			}
		});
	};

	const eliminarDatos = function(e, accion) {
		$.ajax({
			url: 'ServletsLibros',
			type: 'POST',
			data: { accion: accion, id: e.target.dataset.libroid },
			success: function(response) {
				if (response == '1') {
					alert(`Registro eliminado exitosamente.`);
					cargarDatos();
				}
			},
			error: function(jqXHR, status, error) {
				console.log(error);
			}
		});
	};

	const cargarDatos = function() {
		//console.log('cargando los datos..');
		tbody.html('');
		$.ajax({
			url: 'ServletsLibros',
			type: 'POST',
			data: { accion: 'R1' },
			success: function(response) {
				console.log(response);
				response.forEach((item) => {
					let trow = document.createElement('tr');
					let thId = document.createElement('th');
					thId.setAttribute('scope', 'row');
					thId.innerText = item.Id;

					let tdNombre = document.createElement('td');
					tdNombre.innerText = item.NombreLibro;

					let tdAutor = document.createElement('td');
					tdAutor.innerText = item.Autor;

					let tdAnioPub = document.createElement('td');
					tdAnioPub.innerText = item.AnioPublicacion;
					
					let tdFecha = document.createElement('td');
					tdFecha.innerText = item.Fecha;

					let tdOpc = document.createElement('td');
					let btnUpdate = document.createElement('button');
					btnUpdate.className = 'btn btn-primary';
					btnUpdate.innerText = 'Actualizar';
					btnUpdate.setAttribute('data-libroId', item.Id);
					btnUpdate.addEventListener('click', (e) => {
						$('#accionForm').val('U');
						cargarDatosById(e.target.dataset.libroid);
					});
					tdOpc.appendChild(btnUpdate);

					let btnDelete = document.createElement('button');
					btnDelete.className = 'btn btn-danger';
					btnDelete.innerText = 'Eliminar';
					btnDelete.setAttribute('data-libroId', item.Id);
					btnDelete.addEventListener('click', (e) => eliminarDatos(e, 'D'));
					tdOpc.appendChild(btnDelete);

					trow.appendChild(thId);
					trow.appendChild(tdNombre);
					trow.appendChild(tdAutor);
					trow.appendChild(tdAnioPub);
					trow.appendChild(tdFecha);
					trow.appendChild(tdOpc);

					tbody.append(trow);
				});
			},
			error: function(jqXHR, state, error) {
				console.log(error);
			}
		});
	};

	btnConsultar.on('click', function() {
		cargarDatos();
	});

	btnNuevo.on('click', function() {
		$('#exampleModalLabel').text('Nuevo Libro');
		$('#accionForm').val('C');
		$('#txtId').val('0');
		$('#txtNombreLibro').val('');
		$('#txtAutorLibro').val('');
		$('#txtAnioPublicacion').val('');
		$('#txtFecha').val('');
	})

	btnRegistrar.on('click', function() {
		console.log($('#txtFecha').val())
		$.ajax({
			url: 'ServletsLibros',
			type: 'POST',
			data: {
				accion: $('#accionForm').val(),
				id: $('#txtId').val(),
				nombreLibro: $('#txtNombreLibro').val(),
				autorLibro: $('#txtAutorLibro').val(),
				anioPub: $('#txtAnioPublicacion').val(),
				fecha: $('#txtFecha').val()
			},
			success: function(response) {
				if (response == '1') {
					let accion = $('#accionForm').val();
					alert(`Registro ${(accion == 'C' ? 'ingresado' : 'actualizado')} exitosamente.`);
					$('#exampleModal').modal('hide');
					cargarDatos();
				}
			},
			error: function(jqXHR, state, error) {
				console.log(error);
			}
		});
	});
});