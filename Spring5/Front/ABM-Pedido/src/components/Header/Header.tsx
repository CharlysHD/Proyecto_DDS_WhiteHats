import { Button, Container, Form, Nav, Navbar } from "react-bootstrap"
import { useNavigate } from 'react-router-dom';


// Utilizamos el "navigate" para así navegar por toda la page sin tener que refrescar a cada ratos, es decir navegar renderizadamente
export const Header = () => {
    const navigate = useNavigate();
    return (
        <>
            <Navbar expand="lg" className="bg-body-tertiary">
                <Container fluid>
                    <Navbar.Brand onClick={() => navigate ('/')}>TP Vite + TS + B5</Navbar.Brand>
                    <Navbar.Toggle aria-controls="navbarScroll" />
                    <Navbar.Collapse id="navbarScroll">
                        <Nav className="me-auto my-2 my-lg-0" style={{ maxHeight: '100px' }} navbarScroll>
                            <Nav.Link onClick={() => navigate ('/')}>Home</Nav.Link>
                            <Nav.Link onClick={() => navigate ('/componentes')}>Componentes</Nav.Link>
                            <Nav.Link onClick={()=> navigate('/administracion')}>Administracion</Nav.Link>
                            
                        </Nav>
                        <Form className="d-flex">
                            <Form.Control type="search" placeholder="Search" className="me-2" aria-label="Search"/>
                            <Button variant="outline-success">Search</Button>
                        </Form>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </>
    )
}