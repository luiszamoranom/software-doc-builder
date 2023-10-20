import React, { useState,useEffect} from 'react';
import { BrowserRouter as Router,useNavigate,Navigate, Route, Routes } from 'react-router-dom';
import { AuthProvider, useAuth } from './context/AuthContext';
import './App.css'
import './Sidebar.css'
import Layout from './components/Layout';
import Login from './components/Login';
import EstudianteDashboard from './components/EstudianteDashboard';
import ProfesorDashboard from './components/ProfesorDashboard'
import AdministradorDashboard from './components/AdministradorDashboard'
import PrivateRoute from './routes/PrivateRoute';

// ADMINISTRADOR
import BienvenidaDashboard from './components/BienvenidaDashboard';
import Universidades from './components/administrador/Universidades';
import Usuarios from './components/administrador/Usuarios';
import Modulos from './components/administrador/Modulos';
import AgregarUniversidad from './components/administrador/AgregarUniversidad';

function App() {
  const {authUser,updateAuth} = useAuth()

  //console.log("app auth:",authUser)
  return (
      <Routes>
        <Route path='/' element={<Layout />}>
          <Route path='/login' element={<Login />} /> {/* Define la ruta para "/login" aquí */}

          {/* HACER INTERMEDIARIO PARA DISTINTOS ROLES PARA UNA MISMA PERSONA */}

          <Route element={<PrivateRoute />}>
             <Route path='/estudiante' element = {<EstudianteDashboard />} /> 
          </Route>
          <Route element={<PrivateRoute />}>
            <Route path='/profesor' element = {<ProfesorDashboard />} /> 
          </Route>
          <Route element={<PrivateRoute />}>
            <Route path='/administrador' element = {<AdministradorDashboard />}>
              
              <Route index element={<Navigate to="bienvenida" />} />
              <Route path='bienvenida' element= {<BienvenidaDashboard />}/>
              {/* universidades */}
              <Route path='universidades' element= {<Universidades />} />
              <Route path='universidades/agregar' element={<AgregarUniversidad />} />

              <Route path='modulos' element= {<Modulos />}/>
              <Route path='usuarios' element= {<Usuarios />}/>
            </Route>
          </Route>
        </Route>
      </Routes>
  )
}

export default App
