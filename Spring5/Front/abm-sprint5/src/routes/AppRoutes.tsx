import { Route, Routes } from "react-router-dom"
import * as React from 'react'

const Administración = React.lazy(() => import('../pages/Administración'));
const ArticuloInsumo = React.lazy(() => import('../pages/ArticuloInsumo'));
const Cliente = React.lazy(() => import('../pages/Cliente'));
const Componentes = React.lazy(() => import('../pages/Componentes'));
const Domicilio = React.lazy(() => import('../pages/Domicilio'));
const Empleados = React.lazy(() => import('../pages/Empleados'));
const HomePage = React.lazy(() => import('../pages/HomePage'));
const Login = React.lazy(() => import('../pages/Login'));
const Pedido = React.lazy(() => import('../pages/Pedido'));
const PrivateRoute = React.lazy(() => import('./PrivateRoute'));
const Rubro = React.lazy(() => import('../pages/Rubro'));

//const HomePage = React.lazy(() => import('../pages/HomePage'));


const AppRoutes: React.FC = () => (
    <Routes>
        <Route element ={<HomePage/>} path="/" />
        <Route element={<Componentes/>} path="/componentes" />
        <Route element={<PrivateRoute element={<Administración/>} />} path="/administración"/>
        <Route element={<PrivateRoute element={<Empleados/>} />} path="/empleados"/>
        <Route element={<ArticuloInsumo/>} path="/articuloinsumo" />
        <Route element={<Rubro/>} path="/rubro" />
        <Route element={<Cliente/>} path="/cliente" />
        <Route element={<Pedido/>} path="/pedido" />
        <Route element={<Domicilio/>} path="/domicilio" />

        <Route element={<Componentes/>} path="/componentes" />
        
        <Route element={<Login/>} path="/login" />
    </Routes>
);

export default AppRoutes