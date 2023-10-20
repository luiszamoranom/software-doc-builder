import React,{useState,useEffect} from 'react'
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import InputGroup from 'react-bootstrap/InputGroup';
import axios from 'axios';

const AgregarUniversidad = () => {
    const [nombreUniversidad,setNombreUniversidad] = useState()
    const [abreviacion,setAbreviacion] = useState()

    const handleSubmit = async (e) => {
        e.preventDefault()
        //Agregar universidad a la base de datos.
        try{
            const response = await axios.post('http://localhost:8080/universidad', {
                nombreUniversidad,
                abreviacion
            });
            console.log(response.data)
            // console.log(nombreUniversidad)
            // console.log(abreviacion) 
        }
        catch(error){
            console.log(error)
        }
    }

    return (
    <div>
        <div>
            <h1 className='text-center'>Agregar Universidad</h1>
        </div>
        <div className='w-100 d-flex justify-content-center '>
            <div className='w-100' style={{maxWidth:"600px"}}>
                <div className='p-4'>
                    <Form onSubmit={handleSubmit}>
                        <Form.Group className="mb-3" controlId="">
                            <Form.Label>Nombre</Form.Label>
                            <Form.Control type="text" placeholder="Ingrese nombre universidad" onChange={(e) => setNombreUniversidad(e.target.value)}/>
                            {/* <Form.Text className="text-muted">
                                Ingrese nombre universidad
                            </Form.Text> */}
                        </Form.Group>
                        
                        <Form.Group className="mb-3" controlId="">
                            <Form.Label>Abreviación</Form.Label>
                            <Form.Control type="text" placeholder="Ingrese abreviación"  onChange={(e) => setAbreviacion(e.target.value)}/>
                            {/* <Form.Text className="text-muted">
                                Ingrese abreviación
                            </Form.Text> */}
                        </Form.Group>
                        
                        <Button variant="primary" type="submit">
                            Agregar
                        </Button>
                    </Form>
                </div>
            </div>
        </div>
        
        
    </div>
    
  )
}

export default AgregarUniversidad
