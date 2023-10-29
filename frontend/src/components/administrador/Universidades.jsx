import React, { useState,useEffect } from 'react'
import { Link, useNavigate, useLocation } from 'react-router-dom';
import Table from 'react-bootstrap/Table';
import axios from 'axios';

const Universidades = () => {

  const [universidades,setUniversidades] = useState([])
  
  const getUniversidades = async () => {
    const response = await axios.get('http://localhost:8080/universidad/filtro/todas');
    setUniversidades(response.data.universidades); // Actualiza el estado con los datos obtenidos
  }

  useEffect(() => {
    getUniversidades()
  }, []);


  const deshabilitarUniversidad = async (abreviacion) => {
    //Agregar universidad a la base de datos.
    try{
        const response = await axios.patch(`http://localhost:8080/universidad/deshabilitar/${abreviacion}`);
        alert("Se ha deshabilitado correctamente la universidad");
        console.log(response.data);
        await getUniversidades();
    }
    catch(error){
        console.log(error)
    }
  }

  const habilitarUniversidad = async (abreviacion) => {
    //Agregar universidad a la base de datos.
    try{
        const response = await axios.patch(`http://localhost:8080/universidad/habilitar/${abreviacion}`);
        alert("Se ha habilitado correctamente la universidad");
        console.log(response.data);
        await getUniversidades();
    }
    catch(error){
        console.log(error)
    }
  }

  const navigate = useNavigate()

  const irAgregarUniversidad = () =>{
    // navigate('/administrador/universidades/agregar',{ state: { nombre, apellido } }) //este es un ejemplo si es que se quiere pasar parametros
    navigate('/administrador/universidades/agregar')
  }

  const irEditarUniversidad = (abreviacion) => {

    navigate('/administrador/universidades/editar', { state: { parametro: abreviacion } });

  }

  //<input type='checkbox' checked={universidad.estado} /> 

  return (
    <div>
      <div className='pt-2 pb-5'>
        <h1 className='text-center'>Gestion de Universidades</h1>
      </div>
      <div>
        <div>
          <div className='bg-white w-100 justify-content-end d-flex p-3'>
            <button className='btn btn-primary border-0 rounded-2 p-1 d-flex text-white' onClick={irAgregarUniversidad}>
              <div className='p-1'>
                <i className="bi bi-plus-circle"></i>
              </div>
              <div className='p-1'>
                Agregar universidad
              </div>
            </button>
          </div>
        </div>
        <div>
          <Table responsive>
              <thead>
                <tr>
                  <th>#</th>
                  <th>Nombre</th>
                  <th>Abreviación</th>
                  <th>Habilitado</th>
                  <th>Acciones</th>
                </tr>
              </thead>
              <tbody>
                {universidades.map( (universidad,index) =>(
                  <tr key={index} className='m-1 mt-2 align-align-items-center'>
                    <td>{index+1}</td>
                    <td>{universidad.nombre}</td>
                    <td>{universidad.abreviacion}</td>
                    <td>{universidad.estado ? "Si" : "No"}</td>
                    <td>
                      <button className='btn btn-primary' onClick={() => irEditarUniversidad(universidad.abreviacion)}><i className="bi bi-pencil-square"></i></button> 
                      {universidad.estado ? (
                        <button className='btn btn-danger' onClick={() => deshabilitarUniversidad(universidad.abreviacion)}><i className="bi bi-trash"></i></button>
                      ) : (
                        <button className='btn btn-success' onClick={() => habilitarUniversidad(universidad.abreviacion)}><i className='bi bi-check'></i></button>
                      )}
                    </td>
                  </tr>
                ) )}
              </tbody>
            </Table>
        </div>
      </div>
      
    </div>
    
  )
}

export default Universidades
