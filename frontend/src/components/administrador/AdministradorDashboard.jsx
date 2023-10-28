import React,{useEffect, useState} from 'react'
import Button from 'react-bootstrap/Button';
import Offcanvas from 'react-bootstrap/Offcanvas';
import { useAuth } from '../../context/AuthContext';

import { Route, Link, Outlet,useLocation} from 'react-router-dom';


const AdministradorDashboard = () => {
  const {showSidebar,setShowSidebar, authUser,lastPath,setLastPath} = useAuth()
  const location = useLocation();
  const currentPathname = location.pathname;

  useEffect(() => {
      setLastPath(currentPathname)
  },[])
  
  const [localShowSidebar, setLocalShowSidebar] = useState(showSidebar);

  const handleClose = () => setShowSidebar(false);

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
        </div>
    </div>
  )
}

export default AdministradorDashboard
