import{Container, Nav, Navbar} from "react-bootstrap";
import{useNavigate}from "react-router-dom";
import useIsLoggedIn from "../../hooks/useIsLoggedIn";

const Header = () =>{
  //Utils
  const navigate = useNavigate();
  const isLoggedIn:boolean = useIsLoggedIn();

  //Handlers
  function onLogOut(){
    window.localStorage.removeItem('isLoggedIn');
    navigate('/');
  }

  //Render
    return (
        <><Navbar expand="lg" className="bg-body-tertiary">
        <Container>

          <Navbar.Brand onClick={()=>navigate('/')}>React-Bootstrap</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              
              <Nav.Link onClick={()=>navigate('/')}>Home</Nav.Link>
              <Nav.Link onClick={()=>navigate('/componentes')}>Componentes</Nav.Link>
              <Nav.Link onClick={()=>navigate('/administración')}>Administración</Nav.Link>
              <Nav.Link onClick={()=>navigate('/empleados')}>Empleados</Nav.Link>
              
              <Nav.Link onClick={()=>navigate('/articuloinsumo')}>ArticuloInsumo</Nav.Link>
              <Nav.Link onClick={()=>navigate('/rubro')}>Rubro</Nav.Link>
              <Nav.Link onClick={()=>navigate('/cliente')}>Cliente</Nav.Link>
              <Nav.Link onClick={()=>navigate('/pedido')}>Pedido</Nav.Link>
              <Nav.Link onClick={()=>navigate('/domicilio')}>Domicilio</Nav.Link>
              
              <Nav.Link onClick={()=>navigate('/empleados')}>Empleados</Nav.Link>
              
              {isLoggedIn && <Nav.Link onClick={onLogOut}>Log Out</Nav.Link>}

            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar></>
    )
}

export default Header;
