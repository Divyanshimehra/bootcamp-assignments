import { BrowserRouter, Route, Routes, Navigate } from 'react-router-dom'
import './App.css'
import LoginPage from './pages/LoginPage'
import Dashboard from './layout/Dashboard'
import CounterPage from './pages/CounterPage'
import DigitalWatch from './pages/DigitalWatch'
import ProtectedRoute from './components/ProtectedRoute'
import NotFoundPage from './pages/NotFoundPage'
import Home from './pages/Home'


function App() {

  return (
      <BrowserRouter>
      <Routes>
        {/* public route */}
        <Route path = "/" element={<Home />} />
        <Route path = "/login" element={<LoginPage />} />

        {/* Protected route */}
        <Route element={<ProtectedRoute />}>
        <Route path="/dashboard" element={<Dashboard />}>
          <Route path="counter" element={<CounterPage />} />
          <Route path="watch" element={<DigitalWatch />} />
        </Route>
        </Route>
        
        {/* 404 Error */}
        <Route path="*" element={<NotFoundPage />} />
      </Routes>
      
      </BrowserRouter>
    
  )
}

export default App
