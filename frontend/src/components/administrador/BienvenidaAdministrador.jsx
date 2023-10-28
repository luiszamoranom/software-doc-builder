import React from 'react'
import { useAuth } from '../../context/AuthContext';

const BienvenidaAdministrador = () => {
    const {showSidebar,setShowSidebar, authUser} = useAuth()
  return (
    <div>
        
            <div className='justify-content-center text-center mb-5 mt-3 bg-white p-1'>
              <h1>Te damos la bienvenida {authUser.nombres}</h1>
            </div>

            <div className='container border-1 text-center bg-white mb-5 mt-5 p-1'>
              <div className='mb-3 bg-body-secondary pb-2 pt-2'>
                <h3>Acceso rapido</h3>
              </div>
              <div className='pb-5 pt-5 bg-body-secondary d-flex justify-content-around'>
                <h5>Acceso rapido 1</h5><h5>Acceso rapido 2</h5><h5>Acceso rapido 3</h5>
              </div>
            </div>

            <div className='container border-1 text-center bg-white mb-5 mt-5 p-1'>
              <div className='mb-3 bg-body-secondary'>
                <h3>Resumen</h3>
              </div>
              <div className='pb-4 pt-4 bg-body-secondary d-flex justify-content-around'>
                <h2>AQUI VAN GRAFICOS</h2>
                <i className="bi bi-bar-chart-fill bi-md"></i>
              </div>
            </div>
            
    </div>
  )
}

export default BienvenidaAdministrador
