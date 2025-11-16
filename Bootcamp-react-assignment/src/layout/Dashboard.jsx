import "./dashboard.css"
import React from 'react'
import { Link, Outlet } from 'react-router-dom'
const Dashboard = () => {
  return (
    <div>
        <nav className="navBar">
            <Link to="/dashboard/counter">Counter</Link>
            <Link to="/dashboard/watch">Digital Watch</Link>
        </nav>
        <div className='content'>
            <Outlet/>
        </div>
    </div>
  )
}

export default Dashboard