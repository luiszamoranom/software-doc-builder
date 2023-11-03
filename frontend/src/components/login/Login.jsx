import React,{useState,useEffect} from 'react'
import { useAuth } from '../../context/AuthContext';
import { useNavigate} from 'react-router-dom';
import axios from 'axios';


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
            console.log(rutUsuario,contrasenaUsuario)
            const datos = {
                rut:rutUsuario,
                contrasena:contrasenaUsuario
            }
            const response = await axios.get('http://localhost:8080/usuario/login',{
                params: {
                    rutUsuario,
                    contrasenaUsuario
                }
            });
            console.log(response.data)
            // Verifica si la respuesta es exito
            if (response.data.exito == true) {
                const respuesta = response.data.usuario
                
                // const datos = {
                //     rut:'20185866-6',
                //     nombres:'Bastian',
                //     apellidos:'Nuñez',
                //     email:'bastian@estudiante.cl',
                //     contrasena: "bastian123",
                //     estado: true,
                //     rol_plataforma : "Usuario", // Administrador/Usuario
                //     usuarioUniversidadRoles:[
                //         //aqui tenemos los roles que puede tener en distintas universidades un usuario
                //         //en este caso tenemos que un estudiante pertenece a dos universidades
                //         {
                //             id:1,
                //             usuario: {
                //                 rut:'20185866-6',
                //                 nombres:'Bastian',
                //                 apellidos:'Nuñez',
                //                 email:'bastian@estudiante.cl',
                //                 contrasena: "bastian123",
                //                 estado: true,
                //                 rol_plataforma : "Usuario",
                //                 usuarioUniversidadRoles: [1]
                //             },
                //             universidad: {
                //                 abreviacion: 'UTALCA',
                //                 nombre: "Universidad de Talca",
                //                 estado: true,
                //                 usuarioUniversidadRoles: [1]
                //             },
                //             rol:{
                //                 id: 3,
                //                 nombre: 'Estudiante',
                //                 usuarioUniversidadRoles:[1]
                //             }
                //         },
                //         {
                //             id:2,
                //             usuario: {
                //                 rut:'20185866-6',
                //                 nombres:'Bastian',
                //                 apellidos:'Nuñez',
                //                 email:'bastian@estudiante.cl',
                //                 contrasena: "bastian123",
                //                 estado: true,
                //                 rol_plataforma : "Usuario",
                //                 usuarioUniversidadRoles: [2]
                //             },
                //             universidad: {
                //                 abreviacion: 'UCM',
                //                 nombre: "Universidad Católica del Maule",
                //                 estado: true,
                //                 usuarioUniversidadRoles: [2]
                //             },
                //             rol:{
                //                 id: 2,
                //                 nombre: 'Profesor',
                //                 usuarioUniversidadRoles:[2]
                //             }
                //         }
                //     ],
                // };

                setRutUsuario('')
                setContrasenaUsuario('')

                if (respuesta.rol_plataforma == 'Administrador'){
                    console.log("deberia entrar a administrador")
                    localStorage.setItem("auth", JSON.stringify(respuesta));
                    localStorage.setItem("logged", true);
                    updateAuth(respuesta);
                    navigate("/administrador",{replace:true})
                }
                else{
                    if (respuesta.usuarioUniversidadRoles.length==1){
                        //significa que el usuario solo tiene un rol en una unica institucion
                    }
                    else{
                        //significa que el usuario tiene mas roles en varias instituciones
                        navigate("/filtrador",{state:{respuesta},replace:true})
                    }
                }
            }
            else{
                setMensaje('Credenciales incorrectas');
            }
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
