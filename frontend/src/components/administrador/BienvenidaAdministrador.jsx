import React,{useState,useEffect} from 'react'
import { BarChart, Bar, XAxis, YAxis } from 'recharts';
import { useAuth } from '../../context/AuthContext';
import axios from "axios";

const BienvenidaAdministrador = () => {
  const {showSidebar,setShowSidebar, authUser} = useAuth()
  const [universidades, setUniversidades] = useState([]);
  let datosPreprocesados;

  const getUniversidades = async () => {
    const response = await axios.get(
      "http://localhost:8080/universidad/filtro/todas"
    );
    setUniversidades(response.data.universidades); // Actualiza el estado con los datos obtenidos
  };

  useEffect(() => {
    getUniversidades();
  }, []);
  useEffect(() => {
    datosPreprocesados = universidades.map((universidad) => ({
      ...universidad,
      cantidadModulos: universidad.modulos ? universidad.modulos.length : 0,
    }));
    setUniversidades(datosPreprocesados)
  },[universidades])

  return (
    <div>
      <div className='justify-content-center text-center mb-5 mt-3  p-1'>
        <h1>Te damos la bienvenida {authUser.nombres} {authUser.apellidos}</h1>
      </div>

      <div className='container bordeNegro text-center  mb-5 mt-5 p-1'>
        <div className='mb-4 pb-2 pt-2'>
          <h3>Acceso rapido</h3>
        </div>
        <div className='pb-5 pt-5 d-flex justify-content-around'>
          <h5>Acceso rapido 1</h5><h5>Acceso rapido 2</h5><h5>Acceso rapido 3</h5>
        </div>
      </div>

      <div className='bordeNegro'>
        <div className='container text-center mb-3 mt-3 p-1'>
          <div className='mb-4'>
            <h3>Resumen</h3>
          </div>
          <div className='pb-4 pt-4  d-flex justify-content-around'>
            <div>
              <div>
                <h2>Modulos por universidad</h2>
              </div>
              <div>
                <BarChart width={600} height={300} data={universidades}>
                  <XAxis dataKey="abreviacion" stroke="#8884d8" />
                  <YAxis />
                  <Bar dataKey="cantidadModulos" fill="#8884d8" barSize={30} />
                </BarChart>
              </div>
            </div>
            
            
          </div>
        </div>
      </div>
    </div>
  )
}

export default BienvenidaAdministrador
