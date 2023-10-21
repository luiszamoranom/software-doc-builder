import React,{useState,useEffect,useNav} from 'react'
import { useAuth } from '../context/AuthContext';
import { Link, useNavigate, useLocation, Navigate } from 'react-router-dom';


const Login = ({authUser}) => {
    const {updateAuth} = useAuth();

    const [rutUsuario,setRutUsuario] = useState('');
    const [contrasenaUsuario,setContrasenaUsuario] = useState('');
    const [mensaje, setMensaje] = useState('');

    const from = location.state?.from?.pathname || "/";

    useEffect(() =>{
        console.log("de login:",authUser)
    },[])
    
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault()

        try{
            // const response = await axios.post('http://localhost:4000/login', {
            //     rutUsuario,
            //     contrasenaUsuario,
            // });

            // // Verifica si la respuesta contiene un mensaje
            // if (response.data && response.data.mensaje) {
            //     const respuesta = response.data.mensaje
            //     //setMensaje(response.data.mensaje);
            //     if (respuesta != 'Credenciales incorrectas' && respuesta != ''){
            //     const array = respuesta.split(',');

            //     const rut = array[0].split(': ')
            //     const nombres = array[1].split(': ')
            //     const apellidos = array[2].split(': ')
            //     const correo = array[3].split(': ')
            //     const roles = array[4].split(': ')

            //     const datos = {
            //         rut:rut[1],
            //         nombres:nombres[1],
            //         apellidos:apellidos[1],
            //         correo:correo[1],
            //         rol:roles[1],
            //     };

                const datos = {
                    rut:'20185866-6',
                    nombres:'Bastian',
                    apellidos:'Nuñez',
                    correo:'bastian@estudiante.cl',
                    rol:'Administrador',
                };

                localStorage.setItem("auth", JSON.stringify(datos));
                localStorage.setItem("logged", true);

                
                updateAuth(datos);

                setRutUsuario('')
                setContrasenaUsuario('')
                if (datos.rol == 'Estudiante'){
                    navigate("/estudiante",{replace:true})
                }
                else if (datos.rol == 'Profesor'){
                    navigate("/profesor",{replace:true})
                }
                else if (datos.rol == 'Administrador'){
                    navigate("/administrador",{replace:true})
                }
                //navigate(from, { replace: true });
                //window.location.reload();
                //}
                
            // }
            // else{
            //     setMensaje('Respuesta recibida, pero no contiene un mensaje.');
            // }
        }
        catch(error){
            setMensaje('Error al iniciar sesión.');
            console.error('Error al iniciar sesión:', error);
        }
    }


    return (
        <>
            {authUser?
                <> <Navigate to={"/administrador"} /> </> :<></>  
                }
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
                            {mensaje == 'Credenciales incorrectas' ? <div className='ps-2 pe-2'> <div className='pe-2 ps-2 bg-danger text-white'> <p>Credenciales incorrectas</p> </div> </div> :<></>}
                        </div>
                    </div>
                </div>
            </div>
        </>

    );
}

export default Login
