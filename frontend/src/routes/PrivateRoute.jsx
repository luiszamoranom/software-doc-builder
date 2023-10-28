import React from 'react'
import { Navigate, useLocation, Outlet,Route } from 'react-router-dom';
import {useAuth} from '../context/AuthContext'
import Layout from '../components/general/Layout';
import { NavBarExport } from '../components/general/Navbar';

export const PrivateRoute = () => {
	const {authUser, updateAuth} = useAuth()
	//console.log("Pasa por private")
	return (authUser.rut?
		<>
			<NavBarExport/>
			<Layout />
		</>
		:
		<Navigate to='/login' />);
};
export default PrivateRoute

export const Redirigir = () =>{
	const {authUser, updateAuth} = useAuth()
	const pathRol="/"+authUser.roles.toLowerCase()
	return(
		<Route to={pathRol} />
	)
}

export const ProtectRoles = ({roles}) => {
	const {authUser, updateAuth} = useAuth()
	const pathRol="/"+authUser.roles.toLowerCase()
	console.log("protect roles")
	return(
		authUser.roles == roles ?
			<Outlet/>:<Navigate to={pathRol} />
	)
}

