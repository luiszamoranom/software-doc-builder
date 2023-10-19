import React, { useEffect, useState } from 'react';
import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import Button from 'react-bootstrap/Button';
import { Link, Outlet, useLocation, useNavigate} from 'react-router-dom';
import {useAuth} from '../context/AuthContext'



export const NavBarExport = () => {
	const {showSidebar,setShowSidebar,authUser, updateAuth} = useAuth()
	const [show, setShow] = useState(false);

	const handleClose = () => setShowSidebar(false);
	const handleShow = () => setShowSidebar(true);

	
	
	const navigate = useNavigate();

	var pathRol="/"
	const onLogout = () => {
		updateAuth('')
		localStorage.setItem("auth", null);
		localStorage.setItem("logged", false);
		navigate('/login', {
		});
	};
	
	if (authUser){
		pathRol="/"+authUser.rol.toLowerCase()
	}
	
	
	return (
		<>
			<header className='w-100'>
				<Navbar className="bg-body-secondary">
					<Container className='w-100' style={{maxWidth:"none"}}>
						{
							authUser ? 
							<Button variant="primary me-5" className="" onClick={handleShow}>
								<i className="bi bi-list" ></i>
								Menu
							</Button>
							:
							<></>
						}
						
						<Navbar.Brand href={pathRol}>LOGO</Navbar.Brand>
						<Navbar.Toggle></Navbar.Toggle>
						<Navbar.Collapse className="justify-content-end">
							<div>
								{authUser ? (
									<div className='user d-flex'>
										<div className='ms-3 me-3 align-items-center d-flex'>
											<Navbar.Text>
												<span className='username'>Usuario: {authUser.nombres}</span>
											</Navbar.Text>
										</div>
										<div className='ms-3 me-3'>
											<Button variant="outline-danger" onClick={onLogout}>Cerrar sesión</Button>{' '}
										</div>
									</div>
								) : (
									<></>
								)}
							</div>
						</Navbar.Collapse>
					</Container>
				</Navbar>
			</header>
		</>
	);
};