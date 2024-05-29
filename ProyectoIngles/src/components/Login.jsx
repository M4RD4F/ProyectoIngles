import React, { useState } from 'react';
import './Login.css';
import base from '../assets/baseCredenciales.png';
import logo from '../assets/logoIngles.png';
import fondo from '../assets/fondoLibertad.jpg';

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = () => {
    // Aquí puedes agregar la lógica de validación
    if (username === 'usuario' && password === 'contraseña') {
      alert('Acceso concedido');
    } else {
      alert('Acceso denegado');
    }
  };

  return (
    <div className="login-container" style={{ backgroundImage: `url(${fondo})` }}>
      <div className="base-container">
        <img src={logo} alt="Logo" className="logo" />
        <div className="text-container">
          <h1 className="main-text">Bienvenido</h1>
          <h2 className="sub-text">Por favor, inicie sesión</h2>
        </div>
        <div className="input-group">
          <i className="icon-user" />
          <label htmlFor="username">Ingrese usuario:</label>
          <input
            type="text"
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
        </div>
        <div className="input-group">
          <i className="icon-password" />
          <label htmlFor="password">Ingrese contraseña:</label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>
        <button onClick={handleLogin} className="login-button">Ingresar</button>
        <p className="help-text">¿Perdiste tu contraseña? o Ayuda!</p>
      </div>
    </div>
  );
}

export default Login;
