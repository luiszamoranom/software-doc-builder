import React from 'react'
import { Navigate, useLocation, Outlet } from 'react-router-dom';
import {useAuth} from '../context/AuthContext'

export const PrivateRoute = ({ rol }) => {
	const {authUser, updateAuth} = useAuth()
	return (authUser.rut? <Outlet/>: <Navigate to='/login' />);
};


export default PrivateRoute
