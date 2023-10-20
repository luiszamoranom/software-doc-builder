import React,{useEffect, useState} from 'react'
import Button from 'react-bootstrap/Button';
import Offcanvas from 'react-bootstrap/Offcanvas';
import { useAuth } from '../context/AuthContext';
import BienvenidaDashboard from './BienvenidaDashboard';

import { Route, Link, Outlet } from 'react-router-dom';


const AdministradorDashboard = () => {

  const {showSidebar,setShowSidebar, authUser} = useAuth()
  //const [show, setShow] = useState(false);
  const [localShowSidebar, setLocalShowSidebar] = useState(showSidebar);

  const handleClose = () => setShowSidebar(false);
  //const handleClose = () => setShowSidebar(false);
  const handleShow = () => setShowSidebar(true);

  
  useEffect(() => {
    // Actualizar el estado local cuando showSidebar cambie
    setShowSidebar(showSidebar);
  }, [showSidebar]);

  return (
    <div>
        <div className=''>
          <Offcanvas show={showSidebar} onHide={handleClose} className="bg-offcanvas">
            <Offcanvas.Header closeButton>
              <Offcanvas.Title>Menú del Administrador</Offcanvas.Title>
            </Offcanvas.Header>
            <Offcanvas.Body>
              <div className='text-black'>
                <div className='border-2 rounded-2  mt-2 mb-2 div-link'>
                  <h5><Link className='pt-2 pb-2 ps-4 text-decoration-none text-black w-100 d-flex' to="/administrador/bienvenida">Bienvenida</Link></h5>
                </div>
                <div className='border-2 rounded-2 mb-2 div-link'>
                  <h5><Link className='pt-2 pb-2 ps-4 text-decoration-none text-black w-100 d-flex' to="/administrador/universidades">Universidades</Link></h5>
                </div>
                <div className='border-2 rounded-2 mb-2 div-link'>
                  <h5><Link className='pt-2 pb-2 ps-4 text-decoration-none text-black w-100 d-flex' to="/administrador/modulos">Modulos</Link></h5>
                </div>
                <div className='border-2 rounded-2 mb-2 div-link'>
                  <h5><Link className='pt-2 pb-2 ps-4 text-decoration-none text-black w-100 d-flex' to="/administrador/usuarios">Usuarios</Link></h5>
                </div>
              </div>
            </Offcanvas.Body>
          </Offcanvas>
        </div>
        <div className='content'>
          <div className='container bg-body-secondary mt-5 pt-1 pb-1'>
            <Outlet />

          </div>
          {/* <BienvenidaDashboard /> */}
          {/* <div className='container bg-body-secondary mt-5 pt-1 pb-1'>
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
                <i class="bi bi-bar-chart-fill bi-md"></i>
              </div>
            </div>
            
          </div> */}
        </div>
    </div>
  )
}

export default AdministradorDashboard
