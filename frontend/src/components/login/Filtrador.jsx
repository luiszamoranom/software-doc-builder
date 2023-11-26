import React,{useEffect, useState} from 'react'
import { useLocation, useNavigate} from 'react-router-dom';
import Card from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Row from 'react-bootstrap/Row';
import ListGroup from 'react-bootstrap/ListGroup';
import Col from 'react-bootstrap/Col';
import { useAuth } from '../../context/AuthContext';

function Filtrador() {
    const location = useLocation();
    const {updateAuth} = useAuth();
    // const respuesta = location.state.respuesta;
  
    // // Acceder a la variable respuesta aquí
    // console.log(respuesta);
    const [rolUniversidad,setRolUniversidad] = useState()
    const [datosRol,setDatosRol] = useState()

    const [rolPorUniversidad,setRolPorUniversidad] = useState([])
    const navigate = useNavigate();
  
    // Acceder a la variable datos aquí

    function handleRol(item){
        console.log(datosRol)
        const datos_usuario ={
            usuario: {
                rut:datosRol.rut,
                nombres:datosRol.nombres,
                apellidos:datosRol.apellidos,
                email:datosRol.email,
                rol_plataforma:datosRol.rol_plataforma
            },
            rol:{
                id:item.rol.id,
                nombre:item.rol.nombre,
                universidad:item.rol.usuarioUniversidadRoles
            },
            universidad:{
                abreviacion: item.universidad.abreviacion,
                nombre:item.universidad.nombre,
                estado:item.universidad.estado
            }
        }

        localStorage.setItem("auth", JSON.stringify(datos_usuario));
        console.log(datos_usuario)
        localStorage.setItem("logged", true);
        updateAuth(datos_usuario);
        //console.log("pasa aki primero")
        if (item.rol.nombre == 'Estudiante'){
            navigate("/estudiante",{replace:true})
        }
        else if (item.rol.nombre == 'Profesor'){
            navigate("/profesor",{replace:true})
        }
        else if (item.rol.nombre == 'Jefe de Carrera'){
            navigate("/director",{replace:true})
        }
        else if (item.rol.nombre == 'Administrador'){
            navigate("/administrador",{replace:true})
        }
    }

    useEffect( () => {
        //console.log("roles:",location.state.respuesta.usuarioUniversidadRoles)
        //setDatosUsuarioRol(location.state.datos.usuarioUniversidadRoles.usuario);

        //aqui tengo los roles que tiene un usuario en cada institucion
        setRolPorUniversidad(location.state.respuesta.usuarioUniversidadRoles)
        setDatosRol(location.state.respuesta)
    },[])
  
    return (
      <div>
        <div>
            <div className='pt-2 pb-5'>
                <h1 className='text-center'>¿Cómo desea iniciar sesión?</h1>
            </div>
        </div>
        <div>
            <Row xs={1} md={3} className="g-4 m-3 justify-content-center">
                {/* <ListGroup>
                    {rolPorUniversidad.map( (item) => (
                        <ListGroup.Item action variant="info" key={item.id}>
                            <button onClick={() => handleRol(item)}>
                                <div>
                                    <h2>{item.universidad.nombre}</h2>
                                    <h5>{item.rol.nombre}</h5>
                                </div>
                                
                            </button>
                        </ListGroup.Item>
                    )) }
                </ListGroup> */}
                {rolPorUniversidad.map( (item) => (
                    
                    <Card className='border-0' key={item.id}>
                        <button onClick={() => handleRol(item)}>
                            <div>
                                <h2>{item.universidad.nombre}</h2>
                                <h5>{item.rol.nombre}</h5>
                            </div>
                            
                        </button>
                    </Card>
                )) }
            </Row>            
        </div>
        
        
      </div>
    )
}

export default Filtrador
