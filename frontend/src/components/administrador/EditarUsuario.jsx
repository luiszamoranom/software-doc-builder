import React,{useState,useEffect} from 'react'
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import InputGroup from 'react-bootstrap/InputGroup';
import axios from 'axios';

const EditarUsuario = () => {
    const [rut, setRut] = useState("");
    const [nombresUsuario,setNombresUsuario] = useState("");
    const [apellidosUsuario, setApellidosUsuario] = useState("");
    const [passwordUsuario, setPasswordUsuario] = useState("");
    const [emailUsuario,setEmailUsuario] = useState("");
    const [rolId, setRolId] = useState();

    const handleSubmit = async (e) => {
        e.preventDefault()
        
        //Agregar universidad a la base de datos.
        try{
            const response = await axios.patch('http://localhost:8080/usuario', {
                rut,
                nombres: nombresUsuario,
                apellidos: apellidosUsuario,
                contrasena: passwordUsuario,
                email: emailUsuario,

            });
            alert("Se agregó el usuario");
            setRut("");
            console.log(response.data)


        }
        catch(error){
            console.log(error)
        }
    }

    return (
    <div>
        <div>
            <h1 className='text-center'>Editar Usuario</h1>
        </div>
        <div className='w-100 d-flex justify-content-center '>
            <div className='w-100' style={{maxWidth:"600px"}}>
                <div className='p-4'>
                    <Form onSubmit={handleSubmit}>
                        <Form.Group className="mb-3" controlId="">
                            <Form.Label>RUT</Form.Label>
                            <Form.Control type="text" aria-label="Disabled input example" readOnly value={rut} onChange={(e) => setRut(e.target.value)}/>
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
                            <Form.Control type="password" placeholder="Ingrese contraseña"  onChange={(e) => setPasswordUsuario(e.target.value)}/>
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
        
        
    </div>
    
  )
}

export default EditarUsuario
