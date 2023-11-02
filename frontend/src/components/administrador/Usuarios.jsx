import React, { useState, useEffect } from "react";
import { Link, useNavigate, useLocation } from "react-router-dom";
import Table from "react-bootstrap/Table";
import axios from "axios";
import Pagination from 'react-bootstrap/Pagination';

const Usuarios = () => {
  const [usuarios, setUsuarios] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const itemsPerPage = 10; // Cantidad de elementos por página

  const indexOfLastUser = currentPage * itemsPerPage;
  const indexOfFirstUser = indexOfLastUser - itemsPerPage;
  const currentUsers = usuarios.slice(indexOfFirstUser, indexOfLastUser);

  const handlePaginationClick = (page) => {
    setCurrentPage(page);
  };

  const getUsuarios = async () => {
    const response = await axios.get(
      "http://localhost:8080/usuario/filtro/todos"
    );
    setUsuarios(response.data.usuarios); // Actualiza el estado con los datos obtenidos
    console.log(response.data.usuarios);
    // console.log(response.data.usuarios[1].usuarioUniversidadRoles[0].universidad.nombre);
  };

  useEffect(() => {
    getUsuarios();
  }, []);

  const navigate = useNavigate();

  const irAgregarUsuario = () => {
    // navigate('/administrador/universidades/agregar',{ state: { nombre, apellido } }) //este es un ejemplo si es que se quiere pasar parametros
    navigate("/administrador/usuarios/agregar");
  };

  const irEditarUsuario = (rut, nombres, apellidos, correo, password) => {
    navigate("/administrador/usuarios/editar", {
      state: { rut, nombres, apellidos, correo, password },
    });
  };

  //<input type='checkbox' checked={universidad.estado} />

  return (
    <div>
      <div className="pt-2 pb-5">
        <h1 className="text-center">Gestion de Usuarios</h1>
      </div>
      <div>
        <div>
          <div className="bg-white w-100 justify-content-end d-flex p-3">
            <button
              className="btn btn-primary border-0 rounded-2 p-1 d-flex text-white"
              onClick={irAgregarUsuario}
            >
              <div className="p-1">
                <i className="bi bi-plus-circle"></i>
              </div>
              <div className="p-1">Agregar usuario</div>
            </button>
          </div>
        </div>
        <div>
          <Table responsive>
            <thead>
              <tr>
                <th>RUT</th>
                <th>Nombre Completo</th>
                <th>Universidad</th>
                <th>Acciones</th>
              </tr>
            </thead>
            <tbody>
              {currentUsers.map((usuario, index) => (
                <tr key={index} className="m-1 mt-2 align-align-items-center">
                  <td>{usuario.rut}</td>
                  <td>
                    {usuario.nombres} {usuario.apellidos}
                  </td>
                  <td>{usuario.universidad}</td>
                  <td>
                    <button
                      className="btn btn-primary"
                      onClick={() =>
                        irEditarUsuario(
                          usuario.rut,
                          usuario.nombres,
                          usuario.apellidos,
                          usuario.email,
                          usuario.contrasena
                        )
                      }
                    >
                      <i className="bi bi-pencil-square"></i>
                    </button>
                    <button className="btn btn-danger">
                      <i className="bi bi-trash"></i>
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
          <Pagination>
            {Array.from({
              length: Math.ceil(usuarios.length / itemsPerPage),
            }).map((_, index) => (
              <Pagination.Item
                key={index + 1}
                active={index + 1 === currentPage}
                onClick={() => handlePaginationClick(index + 1)}
              >
                {index + 1}
              </Pagination.Item>
            ))}
          </Pagination>
        </div>
      </div>
    </div>
  );
};

export default Usuarios;
