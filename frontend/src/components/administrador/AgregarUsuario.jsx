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
    const [universidades, setUniversidades] = useState([]);
    

    useEffect(() => {
        const fetchUniversidades = async () => {
        try {
            const response = await axios.get("http://localhost:8080/universidad/filtro/habilitadas");
            setUniversidades(response.data.universidades);
        } catch (error) {
            console.error("Hubo un problema al obtener las universidades: ", error);
        }
        };
        fetchUniversidades();
    }, []);

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
                            <Form.Label>RUT</Form.Label>
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
                            <Form.Control type="password" placeholder="Ingrese contraseña"  onChange={(e) => setPasswordUsuario(e.target.value)}/>
                            {/* <Form.Text className="text-muted">
                                Ingrese abreviación
                            </Form.Text> */}
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="">
                            <Form.Label>Rol</Form.Label>
                            <Form.Select aria-label="Default select example" onChange={ (e) => setRolUsuario(e.target.value) } value={rolUsuario}>
                                <option>Elegir rol</option>
                                <option key={"1"} value="1">Estudiante</option>
                                <option key={"2"} value="2">Profesor</option>
                                <option key={"3"} value="3">Administrador</option>
                            </Form.Select>
                        </Form.Group>
                        
                        <Form.Group className="mb-3" controlId="">
                            <Form.Label>Universidad asociada</Form.Label>
                            <Form.Select aria-label="Default select example" onChange={(e) => setUniversidadId(e.target.value)}>
                            <option>Seleccionar universidad</option>
                            {universidades.map((universidad) => (
                                <option key={universidad.abreviacion} value={universidad.abreviacion}>
                                {universidad.nombre}
                                </option>
                            ))}
                            </Form.Select>
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
