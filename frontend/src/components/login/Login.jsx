import React,{useState,useEffect} from 'react'
import { useAuth } from '../../context/AuthContext';
import { useNavigate} from 'react-router-dom';


const Login = ({authUser}) => {
    const {updateAuth} = useAuth();

    const [rutUsuario,setRutUsuario] = useState('');
    const [contrasenaUsuario,setContrasenaUsuario] = useState('');
    const [mensaje, setMensaje] = useState('');

    const from = location.state?.from?.pathname || "/";

    useEffect(() =>{
        //console.log("de login:",authUser)
    },[])
    
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault()

        try{
            // const response = await axios.post('http://localhost:8080/usuario/login', {
            //     rutUsuario,
            //     contrasenaUsuario,
            // });
            // console.log(response.data.exito)
            // // Verifica si la respuesta es exito
            // if (response.data.exito) {
            //     const respuesta = response.data.usuario
                
                const datos = {
                    rut:'20185866-6',
                    nombres:'Bastian',
                    apellidos:'Nuñez',
                    email:'bastian@estudiante.cl',
                    contrasena: "bastian123",
                    estado: true,
                    roles:['Administrador'], //aqui colocar el rol que desea
                    // roles:['Administrador','Profesor'],
                };

                setRutUsuario('')
                setContrasenaUsuario('')

                if (datos.roles.length>1){
                    //console.log("Login auth: ",datos)
                    navigate("/filtrador",{state:{datos},replace:true})
                }
                else{
                    datos.roles=datos.roles[0]
                    localStorage.setItem("auth", JSON.stringify(datos));
                    localStorage.setItem("logged", true);
                    updateAuth(datos);
                    if (datos.roles == 'Estudiante'){
                        navigate("/estudiante",{replace:true})
                    }
                    else if (datos.roles == 'Profesor'){
                        navigate("/profesor",{replace:true})
                    }
                    else if (datos.roles == 'Jefe de Carrera'){
                        navigate("/administrador",{replace:true})
                    }
                    else if (datos.roles == 'Administrador'){
                        navigate("/administrador",{replace:true})
                    }
                }

                //NO DESCOMENTAR LO DE ABAJO YA QUE AUN NO ESTAN IMPLEMENTADOS LOS ROLES
                //CUANDO SE DESCOMENTE HAY QUE CAMBIAR EL NOMBRE DE LA VARIABLE DE "ROLES"

                //  if (respuesta.usuarioUniversidadRoles.length>1){
                //      navigate("/filtrador",{state:respuesta,replace:true})
                //  }
                //  else{
                        // respuesta.roles=respuesta.roles[0]
                        // localStorage.setItem("auth", JSON.stringify(respuesta));
                        // localStorage.setItem("logged", true);
                        // updateAuth(respuesta);
                //      if (respuesta.roles == 'Estudiante'){
                //          navigate("/estudiante",{replace:true})
                //      }
                //      else if (respuesta.roles == 'Profesor'){
                //          navigate("/profesor",{replace:true})
                //      }
                //      else if (respuesta.roles == 'Jefe de Carrera'){
                //          navigate("/administrador",{replace:true})
                //      }
                //      else if (respuesta.roles == 'Administrador'){
                //          navigate("/administrador",{replace:true})
                //      }
                //  }
                

            // }
            // else{
            //     setMensaje('Credenciales incorrectas');
            // }
        }
        catch(error){
            setMensaje('Error al iniciar sesión.');
            console.error('Error al iniciar sesión:', error);
        }
    }


    return (
        <>
            <div className='d-flex vh-100 vw-100 fondo'>
                <div className='vw-100 container-login justify-content-center align-items-center p-2'>
                    <div className='wrapper p-3 row'>
                        <div className='row ms-5 me-5'>
                            <div>
                                <h2>Iniciar Sesion</h2>
                            </div>
                            <div>
                                <form className='form-login' onSubmit={handleSubmit}>
                                    <div className='input-group'>
                                        <label className='label-login form-label'>Rut:</label>
                                        <input className="form-control w-100" type="text" value={rutUsuario} onChange={ (e) => setRutUsuario(e.target.value)} required />
                                    </div>
                                    <div className='input-group'>
                                        <label className='label-login form-label'>Contraseña:</label>
                                        <input className="form-control w-100" type="password" value={contrasenaUsuario} onChange={ (e) => setContrasenaUsuario(e.target.value)} required  />
                                    </div>
                                    <button type="submit" className="btn btn-primary">Entrar</button>
                                </form>
                            </div>
                            {mensaje == 'Credenciales incorrectas' ? <div className='ps-2 pe-2'> <div className='pe-2 ps-2 bg-danger text-white'> <p>{mensaje}</p> </div> </div> :<></>}
                        </div>
                    </div>
                </div>
            </div>
        </>

    );
}

export default Login
