import { Route, Routes } from "react-router-dom";
import * as React from 'react';

const Administración = React.lazy(() => import('../pages/Administración'));
const Componentes = React.lazy(() => import('../pages/Componentes'));
const Cliente = React.lazy(() => import('../pages/Cliente'));
const Domicilio = React.lazy(() => import('../pages/Domicilio'));
const ArticuloInsumo = React.lazy(() => import('../pages/ArticuloInsumo'));
const Empleados = React.lazy(() => import('../pages/Empleados'));
const HomePage = React.lazy(() => import('../pages/HomePage'));
const Pedidos = React.lazy(() => import('../pages/Pedidos'));
const Login = React.lazy(() => import('../pages/Login'));
const PrivateRoute = React.lazy(() => import('./PrivateRoute'));


const AppRoutes: React.FC = () => (
    <Routes>
        <Route element ={<HomePage/>} path="/" />
        <Route element={<Componentes/>} path="/componentes" />
        <Route element={<PrivateRoute element={<Administración/>} />} path="/administración"/>
        <Route element={<PrivateRoute element={<Empleados/>} />} path="/empleados"/>
        <Route element={<PrivateRoute element={<Domicilio/>} />} path="/domicilio"/>
        <Route element={<PrivateRoute element={<ArticuloInsumo/>} />} path="/articuloinsumo"/>
        <Route element={<PrivateRoute element={<Pedidos/>} />} path="/pedidos"/>
        <Route element={<PrivateRoute element={<Cliente/>} />} path="/cliente"/>
        <Route element={<Login/>} path="/login" />
    </Routes>
);

export default AppRoutes