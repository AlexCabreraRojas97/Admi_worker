<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
         <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <title>Hello, world!</title>
    </head>
    <body>
        <div class="row">
            <div class="card col-md-3">
                <div class="card-body">
                    <h5 class="card-title">Empleados</h5>
                    <h6 class="card-subtitle mb-2 text-muted">En este panel podras gestionar los datos de los usuarios empleados del sistema</h6>
                    <div>
                        <form action="Controlador?menu=Empleados" method="POST">
                            
                            <div class="form-group">
                                <label>Nombre</label>
                                 <input type="text" class="form-control" name="txtnombre" id="txtvalidacionNombre" value="${usuarioSeleccionado.getNombre()}" oninput="validarNombre()">
                            </div>
                            <div class="form-group">
                                <label>Apellido</label>
                                 <input type="text" class="form-control" name="txtapellido" id="txtvalidacionApellido" value="${usuarioSeleccionado.getApellido()}" oninput="validarApellido()">
                            </div>
                            <div class="form-group">
                                <label>Tipo de Documento</label>
                                <select name="txttipodocumento" id="txttipodocumento" value="${usuarioSeleccionado.getTipodocumento()}" onchange="validarDocumento()">
                                    <option value="0">Seleccione</option>
                                    <option value="1">DNI</option>
                                    <option value="2">N° PASAPORTE</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label>Documento</label>
                                <input type="text" class="form-control" name="txtdocumento" id="txtdocumento" value="${usuarioSeleccionado.getDocumento()}">
                                <small class="form-text text-muted">Ingrese el número de documento según el tipo seleccionado.</small>
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input type="text" class="form-control" name="txtcorreo" value="${usuarioSeleccionado.getCorreo()}">
                            </div>
                            <div class="form-group">
                                <label>N° Celular</label>
                                <input type="text" class="form-control" name="txtcelular" id="txtcelular" value="${usuarioSeleccionado.getCelular()}" oninput="validarCelular()">
                                <small class="form-text text-muted">Ingrese el número de celular sin espacios.</small>
                            </div>
                            <div class="form-group">
                                <label>Selecciona fecha y hora</label>
                                <input type="datetime-local" class="form-control" name="txtfecha" value="${usuarioSeleccionado.getFecha()}">
                            </div>
                            <div class="form-group">
                                <label>Tipo de acceso</label>
                                <select name="txttipousuario" id="txttipousuario" name="txttipousuario">
                                    <option value="1">Admin</option>
                                    <option value="2">User</option>
                                </select>
                            </div>
                            
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" class="form-control" name="txtpassword" id="txtpassword" value="${usuarioSeleccionado.getPassword()}" oninput="encriptarPassword()">
                            </div>
                            
                            <div>                           
                                <input type="submit" class="btn btn-primary" name="accion" value="Agregar" onclick="abrirNuevaPestana()">
                            
                                <input type="submit" class="btn btn-success" name="accion" value="Actualizar" >
                             </div>   
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-md-8">
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nombres</th>
                <th scope="col">Apellido</th>
                <th scope="col">T. Documento</th>
                <th scope="col">Documento</th>
                <th scope="col">Correo</th>
                <th scope="col">Fecha Creación</th>
                <th scope="col">Usuario Creación</th>
                <th scope="col">Contraseña</th>
                
                <th scope="col">Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="usuario" items="${a_user}">
                <tr>
                    <td>${usuario.getId()}</td>
                    <td>${usuario.getNombre()}</td>
                    <td>${usuario.getApellido()}</td>
                    <td>${usuario.getTipodocumento()}</td>
                    <td>${usuario.getDocumento()}</td>
                    <td>${usuario.getCorreo()}</td>
                    <td>${usuario.getFecha()}</td>
                    <td>${usuario.getTipousuario()}</td>
                   
                    <td>${usuario.getPassword()}</td>    
                    <td>
                        <a class="btn btn-warning" href="Controlador?menu=Empleados&accion=Cargar&ID=${usuario.getId()}">Editar</a>
                        <a class="btn btn-danger" href="Controlador?menu=Empleados&accion=Eliminar&ID=${usuario.getId()}">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
</div>


            <!-- Optional JavaScript -->
            <!-- jQuery first, then Popper.js, then Bootstrap JS -->
            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
            <script>
                function abrirNuevaPestana() {
                    // Cambia la URL a la que deseas redirigir
                    var nuevaURL = 'https://www.ejemplo.com';  // Reemplaza con tu URL deseada
                    window.open(nuevaURL, '_blank');
                }
            </script>
            <script>
                function validarNombre() {
                    var inputNombre = document.getElementById('txtvalidacionNombre');
                    inputNombre.value = inputNombre.value.replace(/[^a-zA-Z\s]/g, ''); // Elimina caracteres no permitidos
                    if (inputNombre.value.length > 12) {
                        inputNombre.value = inputNombre.value.substring(0, 12); // Limita la longitud a 12 caracteres
                    }
                }

                function validarApellido() {
                    var inputApellido = document.getElementById('txtvalidacionApellido');
                    inputApellido.value = inputApellido.value.replace(/[^a-zA-Z\s]/g, ''); // Elimina caracteres no permitidos
                    if (inputApellido.value.length > 12) {
                        inputApellido.value = inputApellido.value.substring(0, 12); // Limita la longitud a 12 caracteres
                    }
                }
            </script>
            <script>
        function validarDocumento() {
            var tipoDocumento = document.getElementById('txttipodocumento').value;
            var inputDocumento = document.getElementById('txtdocumento');

            // Limpiar el campo de documento
            inputDocumento.value = '';

            if (tipoDocumento === '1') { // DNI
                inputDocumento.maxLength = 8;
                inputDocumento.placeholder = 'Ingrese 8 números';
                inputDocumento.pattern = '[1-9][0-9]{7}'; // Asegura que no sea '00000000'
            } else if (tipoDocumento === '2') { // N° PASAPORTE
                inputDocumento.maxLength = 12;
                inputDocumento.placeholder = 'Ingrese 12 números y letras';
                inputDocumento.pattern = '[0-9a-zA-Z]{12}';
            }
        }
    </script>
            <script>
                function validarCelular() {
                    var inputCelular = document.getElementById('txtcelular');

                    inputCelular.value = inputCelular.value.replace(/\D/g, ''); // Elimina caracteres no numéricos

                    if (inputCelular.value.length > 9) {
                        inputCelular.value = inputCelular.value.substring(0, 9); // Limita la longitud a 9 caracteres
                    }

                    var primerDigito = inputCelular.value.charAt(0);
                    if (primerDigito !== '9') {
                        alert('Por favor, ingrese un número de celular válido comenzando con "9".');
                        inputCelular.value = ''; // Limpiar el campo si el primer dígito no es 9
                    }
                }
            </script>
            <script>
                function encriptarPassword() {
                    var inputPassword = document.getElementById('txtpassword');
                    var password = inputPassword.value;

                    // Encriptar la contraseña utilizando SHA-256
                    var hashedPassword = sha256(password);

                    // Asignar el valor encriptado al campo de contraseña
                    inputPassword.value = hashedPassword;
                }
            </script>
        </body>
</html>
