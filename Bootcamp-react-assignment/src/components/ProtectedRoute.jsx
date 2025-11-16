import React from 'react'
import { Navigate, Outlet } from 'react-router-dom';

const ProtectedRoute = () => {
    const isLoggedIn = localStorage.getItem("loggedIn")==="true";
    if (!isLoggedIn){
        return <Navigate to = "/login" replace />;
    }

  return (
    <Outlet />
  )
}

export default ProtectedRoute