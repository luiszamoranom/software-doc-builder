import React, { useState,useEffect } from 'react'
import Table from 'react-bootstrap/Table';
import axios from 'axios';

const Universidades = () => {

  const [exito,setExito] = useState()
  const [mensaje,setMensaje] = useState()
  const [universidades,setUniversidades] = useState({"universidades":[{"algo":"algo"}]})


  useEffect(() => {
    async function fetchData() {
      try {
        const response = await axios.get('http://localhost:8080/universidad/filtro/todas', {
          exito,
          mensaje,
          universidades,
        });
        setUniversidades(response.data.Universidades); // Actualiza el estado con los datos obtenidos
        console.log(universidades)
      } catch (error) {
        console.error(error);
      }
    }
    fetchData();
  }, []); // Este efecto se ejecuta solo una vez al cargar el componente


  return ( 
    <div>
      <Table responsive>
          <thead>
            <tr>
              <th>#</th>
              <th>Nombre</th>
              <th>Abreviación</th>
              <th>Habilitado</th>
            </tr>
          </thead>
          <tbody>
            {/* {universidades.universidades.map( (universidad,index) =>{
              <tr key={index}>
                <td>{index+1}</td>
                <td>{universidad.nombre}</td>
                <td>{universidad.abreviacion}</td>
                <td>{universidad.habilitada ? "Si" : "No"}</td>
              </tr>
            } )} */}
            
          </tbody>
        </Table>
      
      <h1>UN EJEMPLO QUE AQUI SE DEBEN MOSTRAR LAS UNIVERSIDADES Y TODO LO Q SE DESEE</h1>
    </div>
  )
}

export default Universidades
