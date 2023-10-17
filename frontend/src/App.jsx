import React, { useState,useEffect} from 'react';
import { BrowserRouter as Router,useNavigate, Route, Routes } from 'react-router-dom';
import { AuthProvider, useAuth } from './context/AuthContext';
import './App.css'
import Layout from './components/Layout';
import Login from './components/Login';
import EstudianteDashboard from './components/EstudianteDashboard';
import ProfesorDashboard from './components/ProfesorDashboard'
import AdministradorDashboard from './components/AdministradorDashboard'
import PrivateRoute from './routes/PrivateRoute';

function App() {
  const {authUser,updateAuth} = useAuth()

  //console.log("app auth:",authUser)
  return (
      <Routes>
        <Route path='/' element={<Layout />}>
          <Route path='/login' element={<Login />} /> {/* Define la ruta para "/login" aquí */}
          <Route element={<PrivateRoute />}>
             <Route path='/estudiante' element = {<EstudianteDashboard />} /> 
          </Route>
          <Route element={<PrivateRoute />}>
            <Route path='/profesor' element = {<ProfesorDashboard />} /> 
          </Route>
          <Route element={<PrivateRoute />}>
            <Route path='/administrador' element = {<AdministradorDashboard />} /> 
          </Route>
        </Route>
      </Routes>
  )
}

export default App
