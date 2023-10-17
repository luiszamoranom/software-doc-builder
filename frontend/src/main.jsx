import React from 'react'
import ReactDOM from 'react-dom/client'
import { BrowserRouter as Router,useNavigate, Route, Routes } from 'react-router-dom';
import App from './App.jsx'
import './index.css'
import { AuthProvider } from './context/AuthContext.jsx'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <Router>
      <AuthProvider>
        <App />
      </AuthProvider>
    </Router>
  </React.StrictMode>,
)
