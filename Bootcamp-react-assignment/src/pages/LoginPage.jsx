import React from 'react'
import { Navigate, useNavigate } from 'react-router-dom'

const LoginPage = () => {
    const navigate = useNavigate();
    
    const isLoggedIn = localStorage.getItem("loggedIn")==="true";
    if (isLoggedIn) {
        return <Navigate to="/dashboard" replace />;
    }

    const handleLogin = () =>{
        localStorage.setItem("loggedIn","true");
        navigate("/dashboard");
    }

  return (
    <div>
        <h1>Login page</h1>
        <button onClick={handleLogin}>Login</button>
    </div>
  )
}

export default LoginPage