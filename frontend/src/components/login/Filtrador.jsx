import React,{useEffect, useState} from 'react'
import { useLocation, useNavigate} from 'react-router-dom';
import Card from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import { useAuth } from '../../context/AuthContext';

function Filtrador() {
    const location = useLocation();
    const {updateAuth} = useAuth();
    // const respuesta = location.state.respuesta;
  
    // // Acceder a la variable respuesta aquí
    // console.log(respuesta);
    const [listaRoles,setListRoles] = useState([])
    const navigate = useNavigate();
  
    // Acceder a la variable datos aquí

    function handleRol(rol){
        const credencial = location.state.datos;
        credencial.roles=rol;

        localStorage.setItem("auth", JSON.stringify(credencial));
        localStorage.setItem("logged", true);
        updateAuth(credencial);

        if (rol == 'Estudiante'){
            navigate("/estudiante",{replace:true})
        }
        else if (rol == 'Profesor'){
            navigate("/profesor",{replace:true})
        }
        else if (rol == 'Jefe de Carrera'){
            navigate("/director",{replace:true})
        }
        else if (rol == 'Administrador'){
            navigate("/administrador",{replace:true})
        }
    }

    useEffect( () => {
        //console.log("roles:",location.state.datos)
        setListRoles(location.state.datos.roles);
    },[])
  
    return (
      <div>
        <div>
            <div className='pt-2 pb-5'>
                <h1 className='text-center'>Elije como quieres iniciar sesion</h1>
            </div>
        </div>
        <div>
            <CardGroup>
                {listaRoles.map( (rol,index) => (
                    <Card style={{margin:"2rem"}}>
                        <button onClick={() => handleRol(rol)}>
                            <h1 key={index}>{rol}</h1>
                        </button>
                    </Card>
                )) }
            </CardGroup>
        </div>
        
        
      </div>
    )
}

export default Filtrador
