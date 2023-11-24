import React, { useState,useEffect} from 'react';
import { BrowserRouter as Router,useNavigate,Navigate, Route, Routes, Outlet } from 'react-router-dom';
import { AuthProvider, useAuth } from './context/AuthContext';
import './App.css'
import './Sidebar.css'
import Layout from './components/Layout';
import Login from './components/Login';
import EstudianteDashboard from './components/EstudianteDashboard';
import ProfesorDashboard from './components/ProfesorDashboard'
import AdministradorDashboard from './components/AdministradorDashboard'
import PrivateRoute from './routes/PrivateRoute';
import { ProtectRoles } from './routes/PrivateRoute';

// ADMINISTRADOR
import BienvenidaDashboard from './components/BienvenidaDashboard';
import Universidades from './components/administrador/Universidades';
import Usuarios from './components/administrador/Usuarios';
import Modulos from './components/administrador/Modulos';
import AgregarUniversidad from './components/administrador/AgregarUniversidad';
import EditarUniversidad from './components/administrador/EditarUniversidad';
import AgregarUsuario from './components/administrador/AgregarUsuario';
import AgregarUsuarios from './components/administrador/AgregarUsuarios';
import EditarUsuario from './components/administrador/EditarUsuario';

function App() {
  const {authUser,updateAuth} = useAuth()

  console.log("app auth:",authUser)
  return (
      <Routes>
        <Route path='/login' element={<Login />} />
        <Route path='' element={<PrivateRoute />}>
          
          <Route element={<Layout/>}>

            <Route element={<ProtectRoles roles="Estudiante" />}>
              <Route path='/estudiante' element = {<EstudianteDashboard />} /> 
            </Route>

            <Route element={<ProtectRoles roles="Profezsor" />}>
              <Route path='/profesor' element = {<ProfesorDashboard />} /> 
            </Route>

            <Route path='/administrador' element={<ProtectRoles roles="Administrador" />}> 
              <Route path='/administrador' element = {<AdministradorDashboard />}>
                <Route index element={<Navigate to="bienvenida" />} />
                <Route path='bienvenida' element= {<BienvenidaDashboard />}/>
                
                <Route path='universidades' element= {<Universidades />} />
                <Route path='universidades/agregar' element={<AgregarUniversidad />} />
                <Route path='universidades/editar' element={<EditarUniversidad />} />

                <Route path='modulos' element= {<Modulos />}/>
                
                <Route path='usuarios' element= {<Usuarios />}/>
                <Route path='usuarios/agregar' element= {<AgregarUsuario />}/>
                <Route path='usuarios/agregarExcel' element={<AgregarUsuarios />} />
                <Route path='usuarios/editar' element= {<EditarUsuario />}/>


              </Route>
            </Route>

          </Route>
        </Route>
      </Routes>
  )
}

export default App

{/* <Route element={<PrivateRoute />}>
             <Route path='/estudiante' element = {<EstudianteDashboard />} /> 
          </Route>
          <Route element={<PrivateRoute />}>
            <Route path='/profesor' element = {<ProfesorDashboard />} /> 
          </Route>
          <Route element={<PrivateRoute />}>
            <Route path='/administrador' element = {<AdministradorDashboard />}>
              
              <Route index element={<Navigate to="bienvenida" />} />
              <Route path='bienvenida' element= {<BienvenidaDashboard />}/>
             
              <Route path='universidades' element= {<Universidades />} />
              <Route path='universidades/agregar' element={<AgregarUniversidad />} />

              <Route path='modulos' element= {<Modulos />}/>
              <Route path='usuarios' element= {<Usuarios />}/>
              <Route path='usuarios/agregar' element= {<AgregarUsuario />}/>

            </Route>
          </Route> */}
