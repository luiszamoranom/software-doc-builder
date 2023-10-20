import React,{useEffect, useState} from 'react'
import Button from 'react-bootstrap/Button';
import Offcanvas from 'react-bootstrap/Offcanvas';
import { useAuth } from '../context/AuthContext';


const EstudianteDashboard = () => {
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

      <Offcanvas show={showSidebar} onHide={handleClose}>
        <Offcanvas.Header closeButton>
          <Offcanvas.Title>Menú del Estudiante</Offcanvas.Title>
        </Offcanvas.Header>
        <Offcanvas.Body>
          <div className='bg-dark'>
            <div>
              <h5><a href="/">Modulos</a></h5>
            </div>
          </div>
        </Offcanvas.Body>
      </Offcanvas>
    </div>
  )
}

export default EstudianteDashboard
