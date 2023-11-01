import React,{useEffect, useState} from 'react'
import { useLocation, useNavigate} from 'react-router-dom';
import Card from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Row from 'react-bootstrap/Row';
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

    const [showRoles,setShowRoles] = useState(false)
    const [rolPorUniversidad,setRolPorUniversidad] = useState([])
    const navigate = useNavigate();
  
    // Acceder a la variable datos aquí

    function handleRol(item){

        localStorage.setItem("auth", JSON.stringify(item));
        localStorage.setItem("logged", true);
        updateAuth(item);
        console.log("nombre rol:",item.rol.nombre)
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
        //console.log("roles:",location.state.datos)
        //setDatosUsuarioRol(location.state.datos.usuarioUniversidadRoles.usuario);

        //aqui tengo los roles que tiene un usuario en cada institucion
        setRolPorUniversidad(location.state.datos.usuarioUniversidadRoles)
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
