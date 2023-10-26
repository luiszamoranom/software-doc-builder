import React,{useState,useEffect} from 'react'
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import InputGroup from 'react-bootstrap/InputGroup';
import axios from 'axios';

const AgregarUsuario = () => {
    const [rutUsuario, setRutUsuario] = useState();
    const [nombresUsuario,setNombresUsuario] = useState();
    const [apellidosUsuario, setApellidosUsuario] = useState();
    const [passwordUsuario, setPasswordUsuario] = useState();
    const [emailUsuario,setEmailUsuario] = useState();
    const [rolUsuario, setRolUsuario] = useState();
    const [universidadId, setUniversidadId] = useState();


    const handleSubmit = async (e) => {
        e.preventDefault()
        //Agregar universidad a la base de datos.
        try{
            const response = await axios.post('http://localhost:8080/guardar_con_rol_en_universidad', {
                rutUsuario,
                nombresUsuario,
                apellidosUsuario,
                passwordUsuario,
                emailUsuario,
                rolUsuario,
                universidadId

            });
            console.log(response.data)
            // console.log(nombreUniversidad)
            // console.log(abreviacion) 
        }
        catch(error){
            console.log(error)
        }
    }

    return (
    <div>
        <div>
            <h1 className='text-center'>Agregar Usuario</h1>
        </div>
        <div className='w-100 d-flex justify-content-center '>
            <div className='w-100' style={{maxWidth:"600px"}}>
                <div className='p-4'>
                    <Form onSubmit={handleSubmit}>
                        <Form.Group className="mb-3" controlId="">
                            <Form.Label>Nombre</Form.Label>
                            <Form.Control type="text" placeholder="Ingrese rut" onChange={(e) => setRutUsuario(e.target.value)}/>
                            {/* <Form.Text className="text-muted">
                                Ingrese nombre universidad
                            </Form.Text> */}
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="">
                            <Form.Label>Nombre</Form.Label>
                            <Form.Control type="text" placeholder="Ingrese nombres" onChange={(e) => setNombresUsuario(e.target.value)}/>
                            {/* <Form.Text className="text-muted">
                                Ingrese nombre universidad
                            </Form.Text> */}
                        </Form.Group>
                        
                        <Form.Group className="mb-3" controlId="">
                            <Form.Label>Apellidos</Form.Label>
                            <Form.Control type="text" placeholder="Ingrese apellidos"  onChange={(e) => setApellidosUsuario(e.target.value)}/>
                            {/* <Form.Text className="text-muted">
                                Ingrese abreviación
                            </Form.Text> */}
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="">
                            <Form.Label>Correo</Form.Label>
                            <Form.Control type="text" placeholder="Ingrese correo"  onChange={(e) => setEmailUsuario(e.target.value)}/>
                            {/* <Form.Text className="text-muted">
                                Ingrese abreviación
                            </Form.Text> */}
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="">
                            <Form.Label>Contraseña</Form.Label>
                            <Form.Control type="text" placeholder="Ingrese contraseña"  onChange={(e) => setPasswordUsuario(e.target.value)}/>
                            {/* <Form.Text className="text-muted">
                                Ingrese abreviación
                            </Form.Text> */}
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="">
                            <Form.Label>Rol</Form.Label>
                            <Form.Select aria-label="Default select example">
                                <option>Elegir rol</option>
                                <option value="1">Estudiante</option>
                                <option value="2">Profesor</option>
                                <option value="3">Administrador</option>
                            </Form.Select>
                        </Form.Group>
                        
                        <Form.Group className="mb-3" controlId="">
                            <Form.Label>Universidad asociada</Form.Label>
                            <Form.Control type="number" placeholder="Ingrese id universidad"  onChange={(e) => setUniversidadId(e.target.value)}/>
                            {/* <Form.Text className="text-muted">
                                Ingrese abreviación
                            </Form.Text> */}
                        </Form.Group>

                        <Button variant="primary" type="submit">
                            Agregar
                        </Button>
                    </Form>
                </div>
            </div>
        </div>
        
        
    </div>
    
  )
}

export default AgregarUsuario
