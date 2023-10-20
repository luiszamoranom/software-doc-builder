import React, { useState,useEffect } from 'react'
import { Link, useNavigate, useLocation } from 'react-router-dom';
import Table from 'react-bootstrap/Table';
import axios from 'axios';

const Usuarios = () => {

  const [usuarios,setUsuarios] = useState([])
  
  const getUsuarios = async () => {
    const response = await axios.get('http://localhost:8080/usuario/filtro/todos');
    setUsuarios(response.data.usuarios); // Actualiza el estado con los datos obtenidos
  }

  useEffect(() => {
    getUsuarios()
  }, []);

  const navigate = useNavigate()

  const irAgregarUsuario = () =>{
    // navigate('/administrador/universidades/agregar',{ state: { nombre, apellido } }) //este es un ejemplo si es que se quiere pasar parametros
    navigate('/administrador/usuarios/agregar')
  }

  //<input type='checkbox' checked={universidad.estado} /> 

  return (
    <div>
      <div className='pt-2 pb-5'>
        <h1 className='text-center'>Gestion de Usuarios</h1>
      </div>
      <div>
        <div>
          <div className='bg-white w-100 justify-content-end d-flex p-3'>
            <button className='btn btn-primary border-0 rounded-2 p-1 d-flex text-white' onClick={irAgregarUsuario}>
              <div className='p-1'>
                <i className="bi bi-plus-circle"></i>
              </div>
              <div className='p-1'>
                Agregar usuario
              </div>
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
                {usuarios.map( (universidad,index) =>(
                  <tr key={index} className='m-1 mt-2 align-align-items-center'>
                    <td>{usuarios.rut}</td>
                    <td>{usuarios.nombres} {usuarios.apellidos}</td>
                    <td>{usuarios.universidad}</td>
                    <td><button className='btn btn-primary'><i className="bi bi-pencil-square"></i></button> <button className='btn btn-danger'><i className="bi bi-trash"></i></button> </td>
                  </tr>
                ) )}
              </tbody>
            </Table>
        </div>
      </div>
      
    </div>
    
  )
}

export default Usuarios
