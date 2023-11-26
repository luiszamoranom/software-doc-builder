import React,{useState,useEffect} from 'react'
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import InputGroup from 'react-bootstrap/InputGroup';
import axios from 'axios';
import { useLocation, useNavigate } from 'react-router-dom';
import VentanaModal from '../general/VentanaModal';

const EditarUsuario = () => {
    const [nombresUsuario,setNombresUsuario] = useState("");
    const [apellidosUsuario, setApellidosUsuario] = useState("");
    const [passwordUsuario, setPasswordUsuario] = useState("");
    const [emailUsuario,setEmailUsuario] = useState("");
    const location = useLocation();
    const rut = location.state.rut;
    
    useEffect(() => {
        setNombresUsuario(location.state.nombres);
        setApellidosUsuario(location.state.apellidos);
        setEmailUsuario(location.state.correo);
        
    }, [location]);

    const [showModal, setShowModal] = useState(false);
    const [tituloModal, setTituloModal] = useState("");
    const [cuerpoModal, setCuerpoModal] = useState("");
    const handleClose = () => {
        setShowModal(false)
    };
    const mostrarModal = () => {
        setShowModal(true)
    };

    const handleSubmit = async (e) => {
        e.preventDefault()
        
        
        try{
            const response = await axios.patch('http://localhost:8080/usuario', {
                rut,
                nombres: nombresUsuario,
                apellidos: apellidosUsuario,
                contrasena: passwordUsuario,
                email: emailUsuario,

            });
            setTituloModal('<span class="bi bi-check-circle text-success mx-2"></span>Éxito');
            setCuerpoModal(response.data.mensaje); 
            mostrarModal();
            console.log(response.data)


        }
        catch(error){
            setTituloModal('<span className="bi bi-exclamation-triangle text-danger mx-2"></span>Error');
            setCuerpoModal('Ocurrió un error al editar el usuario'); 
            mostrarModal();
            console.log(error)
        }
    }

    const navigate = useNavigate();
    const volver = () => {
        navigate( '/administrador/usuarios');
    }
    return (
    <div>
        <div>
            <h1 className='text-center'>Editar Usuario</h1>
        </div>
        <button className='btn btn-primary' onClick={volver}>Volver atrás</button>
        <div className='w-100 d-flex justify-content-center '>
            <div className='w-100' style={{maxWidth:"600px"}}>
                <div className='p-4'>
                    <Form onSubmit={handleSubmit}>
                        <Form.Group className="mb-3" controlId="">
                            <Form.Label>RUT</Form.Label>
                            <Form.Control type="text" aria-label="Disabled input example" readOnly value={rut} onChange={(e) => setRut(e.target.value)} required/>
                            {/* <Form.Text className="text-muted">
                                Ingrese nombre universidad
                            </Form.Text> */}
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="">
                            <Form.Label>Nombre</Form.Label>
                            <Form.Control type="text" placeholder="Ingrese nombres" value={nombresUsuario} onChange={(e) => setNombresUsuario(e.target.value)} required/>
                            {/* <Form.Text className="text-muted">
                                Ingrese nombre universidad
                            </Form.Text> */}
                        </Form.Group>
                        
                        <Form.Group className="mb-3" controlId="">
                            <Form.Label>Apellidos</Form.Label>
                            <Form.Control type="text" placeholder="Ingrese apellidos" value={apellidosUsuario} onChange={(e) => setApellidosUsuario(e.target.value)} required/>
                            {/* <Form.Text className="text-muted">
                                Ingrese abreviación
                            </Form.Text> */}
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="">
                            <Form.Label>Correo</Form.Label>
                            <Form.Control type="text" placeholder="Ingrese correo" value={emailUsuario} onChange={(e) => setEmailUsuario(e.target.value)} required/>
                            {/* <Form.Text className="text-muted">
                                Ingrese abreviación
                            </Form.Text> */}
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="">
                            <Form.Label>Contraseña</Form.Label>
                            <Form.Control type="password" placeholder="Ingrese contraseña" value={passwordUsuario} onChange={(e) => setPasswordUsuario(e.target.value)} required/>
                            {/* <Form.Text className="text-muted">
                                Ingrese abreviación
                            </Form.Text> */}
                        </Form.Group>

                        <Button variant="primary" type="submit">
                            Guardar cambios
                        </Button>
                    </Form>
                </div>
            </div>
        </div>
        {showModal && <VentanaModal titulo={tituloModal} cuerpo={cuerpoModal} showModal={showModal} handleClose={handleClose} />}
        
    </div>
    
  )
}

export default EditarUsuario
