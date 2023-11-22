import { Container, Nav, NavDropdown, Navbar } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import useIsLoggedIn from "../../hooks/useIsLoggedIn";

const Header = () => {
  //Utils
  const navigate = useNavigate();
  const isLoggedIn: boolean = useIsLoggedIn();

  //Handlers
  function onLogOut() {
    window.localStorage.removeItem('isLoggedIn');
    navigate('/');
  }

  //Render
  return (
    <><Navbar expand="lg" className="bg-body-tertiary">
      <Container>

        <Navbar.Brand onClick={() => navigate('/')}>EL Buen Sabor</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">

            <Nav.Link onClick={() => navigate('/')}>Home</Nav.Link>
            <Nav.Link onClick={() => navigate('/componentes')}>Componentes</Nav.Link>

            <NavDropdown title="Administracion" id="basic-nav-dropdown">

              <NavDropdown.Item href="#action/3.2" onClick={() => navigate('/empleados')}>Empleados</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="#action/3.3" onClick={() => navigate('/cliente')}>Cliente</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.4" onClick={() => navigate('/pedidos')}>Pedido</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.4" onClick={() => navigate('/domicilio')}>Domicilio</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.4" onClick={() => navigate('/factura')}>Factura</NavDropdown.Item>
            </NavDropdown>

            <NavDropdown title="Productos" id="basic-nav-dropdown">
              <NavDropdown.Item href="#action/3.1" onClick={() => navigate('/administración')}>Tipo de Productos</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.3" onClick={() => navigate('/articuloinsumo')}>Insumos</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="#action/3.3" onClick={() => navigate('/rubro')}>Rubros</NavDropdown.Item>
            </NavDropdown>

            {isLoggedIn && <Nav.Link onClick={onLogOut}>Log Out</Nav.Link>}

          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar></>
  )
}

export default Header;