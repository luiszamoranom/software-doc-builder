import React,{useEffect, useState} from 'react'
import Offcanvas from 'react-bootstrap/Offcanvas';
import { useAuth } from '../../context/AuthContext';
import { Route, Link, Outlet,useLocation} from 'react-router-dom';

const JefeCarreraDashboard = () => {
  const {showSidebar,setShowSidebar} = useAuth()
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
    <div className=''>
      <div>
        <Offcanvas show={showSidebar} onHide={handleClose}>
          <Offcanvas.Header closeButton>
            <Offcanvas.Title>Menú de Jefe de Carrera</Offcanvas.Title>
          </Offcanvas.Header>
          <Offcanvas.Body>
          <div className='text-black'>
                <div className='border-2 rounded-2 mb-2 div-link'>
                  <h5><Link className='pt-2 pb-2 ps-4 text-decoration-none text-black w-100 d-flex' to="/director/modulos">Módulos</Link></h5>
                </div>
                <div className='border-2 rounded-2 mb-2 div-link'>
                  <h5><Link className='pt-2 pb-2 ps-4 text-decoration-none text-black w-100 d-flex' to="/director/instancias">Instancia de módulos</Link></h5>
                </div>
                <div className='border-2 rounded-2 mb-2 div-link'>
                  <h5><Link className='pt-2 pb-2 ps-4 text-decoration-none text-black w-100 d-flex' to="/director/usuarios">Usuarios</Link></h5>
                </div>
                <div className='border-2 rounded-2 mb-2 div-link'>
                  <h5><Link className='pt-2 pb-2 ps-4 text-decoration-none text-black w-100 d-flex' to="/director/estadisticas">Estadisticas</Link></h5>
                </div>
                <div className='border-2 rounded-2 mb-2 div-link'>
                  <h5><Link className='pt-2 pb-2 ps-4 text-decoration-none text-black w-100 d-flex' to="/director/perfil">Perfil</Link></h5>
                </div>
              </div>
          </Offcanvas.Body>
        </Offcanvas>
      </div>
      <div className='content'>
          <div className='container  mt-5 pt-1 pb-1'>
            <Outlet />
          </div>
        </div>
    </div>
  )
}

export default JefeCarreraDashboard
