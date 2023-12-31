import { Container } from "react-bootstrap";
import { Footer } from "./components/Footer/Footer";
import { Header } from "./components/Header/Header";
import { AppRoutes } from "./routes/AppRoutes";
import { BrowserRouter as Router } from "react-router-dom"
import { Suspense } from "react";
import { Loader } from "./components/Loader/Loader";
import 'react-toastify/dist/ReactToastify.css'
import { ToastContainer } from "react-toastify";
// import Form from "./pages/Form";


export function App() {

  return (
    <>
      <ToastContainer/>
      <Router>
        <Header /> {/* Este escalamiento es para evitar que se renderice nuevamente al cambiar de pages */}
          <Container style={{minHeight: '100vh', minWidth: '100%', padding: '0'}}>
          <Suspense fallback={<Loader/>}><AppRoutes/></Suspense>
          </Container>
        <Footer/>
      </Router>
    </>
  )
}