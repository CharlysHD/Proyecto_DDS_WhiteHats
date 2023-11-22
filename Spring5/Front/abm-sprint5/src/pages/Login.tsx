import { Button, Form, Nav } from "react-bootstrap";
import * as React from 'react';
import { useNavigate } from "react-router-dom";
import { useFormik } from 'formik';
import * as Yup from 'yup';
import { AuthService } from '../services/AuthService';
import { LoginRequest } from '../types/LoginRequest';
import { RegisterRequest } from '../types/RegisterRequest';

const Login: React.FC = () => {
    const navigate = useNavigate();

    // Estado para manejar la visibilidad de los formularios
    const [showLoginForm, setShowLoginForm] = React.useState(false);
    const [showRegisterForm, setShowRegisterForm] = React.useState(false);

    // Formik para el formulario de inicio de sesión
    const loginFormik = useFormik({
        initialValues: {
            username: '',
            password: '',
        },
        validationSchema: Yup.object({
            username: Yup.string().required('Este campo es obligatorio'),
            password: Yup.string().required('Este campo es obligatorio'),
        }),
        onSubmit: async (values) => {
            try {
                const token = await AuthService.login(values as LoginRequest);
                console.log('Inicio de sesión exitoso. Token:', token);
                window.localStorage.setItem('isLoggedIn', 'true');
                navigate('/');
            } catch (error) {
                console.error('Error al iniciar sesión:', error);
                // Maneja el error según tus necesidades
            }
        },
    });

    // Formik para el formulario de registro
    const registerFormik = useFormik({
        initialValues: {
            username: '',
            password: '',
            firstname: '',
            lastname: '',
            country: '',
        },
        validationSchema: Yup.object({
            username: Yup.string().required('Este campo es obligatorio'),
            password: Yup.string().required('Este campo es obligatorio'),
            firstname: Yup.string().required('Este campo es obligatorio'),
            lastname: Yup.string().required('Este campo es obligatorio'),
            country: Yup.string().required('Este campo es obligatorio'),
        }),
        onSubmit: async (values) => {
            try {
                const token = await AuthService.register(values as RegisterRequest);
                console.log('Registro exitoso. Token:', token);
                window.localStorage.setItem('isLoggedIn', 'true');
                navigate('/');
            } catch (error) {
                console.error('Error al registrar:', error);
                // Maneja el error según tus necesidades
            }
        },
    });

    // Funciones para manejar la visibilidad de los formularios
    const handleShowLoginForm = () => {
        setShowLoginForm(true);
        setShowRegisterForm(false);
    };

    const handleShowRegisterForm = () => {
        setShowRegisterForm(true);
        setShowLoginForm(false);
    };

    // Render
    return (
        <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', height: '100vh', width: '100vw' }}>
            <Nav variant="tabs">
                <Nav.Item>
                    <Nav.Link onClick={(e) => { e.preventDefault(); handleShowLoginForm(); }}>Iniciar sesión</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link onClick={(e) => { e.preventDefault(); handleShowRegisterForm(); }}>Registrarse</Nav.Link>
                </Nav.Item>
            </Nav>

            {showLoginForm && (
                <Form onSubmit={loginFormik.handleSubmit}>
                    <Form.Group controlId="formUsername">
                        <Form.Label>Nombre de usuario</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Ingresa tu usuario"
                            name="username"
                            onChange={loginFormik.handleChange}
                            onBlur={loginFormik.handleBlur}
                            value={loginFormik.values.username}
                        />
                    </Form.Group>

                    <Form.Group controlId="formPassword">
                        <Form.Label>Contraseña</Form.Label>
                        <Form.Control
                            type="password"
                            placeholder="Ingresa tu contraseña"
                            name="password"
                            onChange={loginFormik.handleChange}
                            onBlur={loginFormik.handleBlur}
                            value={loginFormik.values.password}
                        />
                    </Form.Group>

                    <Button variant="primary" type="submit" disabled={loginFormik.isSubmitting}>
                        Iniciar sesión
                    </Button>
                </Form>
            )}

            {showRegisterForm && (
                <Form onSubmit={registerFormik.handleSubmit}>
                    <Form.Group controlId="formUsernameRegister">
                        <Form.Label>Nombre de usuario</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Ingresa tu nombre de usuario"
                            name="username"
                            onChange={registerFormik.handleChange}
                            onBlur={registerFormik.handleBlur}
                            value={registerFormik.values.username}
                        />
                    </Form.Group>

                    <Form.Group controlId="formPasswordRegister">
                        <Form.Label>Contraseña</Form.Label>
                        <Form.Control
                            type="password"
                            placeholder="Ingresa tu contraseña"
                            name="password"
                            onChange={registerFormik.handleChange}
                            onBlur={registerFormik.handleBlur}
                            value={registerFormik.values.password}
                        />
                    </Form.Group>

                    <Form.Group controlId="formFirstName">
                        <Form.Label>Nombre</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Ingresa tu nombre"
                            name="firstname"
                            onChange={registerFormik.handleChange}
                            onBlur={registerFormik.handleBlur}
                            value={registerFormik.values.firstname}
                        />
                    </Form.Group>

                    <Form.Group controlId="formLastName">
                        <Form.Label>Apellido</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Ingresa tu apellido"
                            name="lastname"
                            onChange={registerFormik.handleChange}
                            onBlur={registerFormik.handleBlur}
                            value={registerFormik.values.lastname}
                        />
                    </Form.Group>

                    <Form.Group controlId="formCountry">
                        <Form.Label>País</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Ingresa tu país"
                            name="country"
                            onChange={registerFormik.handleChange}
                            onBlur={registerFormik.handleBlur}
                            value={registerFormik.values.country}
                        />
                    </Form.Group>

                    <Button variant="primary" type="submit" disabled={registerFormik.isSubmitting}>
                        Registrarse
                    </Button>
                </Form>
            )}
        </div>
    );
};

export default Login;
