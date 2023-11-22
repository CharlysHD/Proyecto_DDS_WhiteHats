import {Button, Card, CardGroup}  from "react-bootstrap";

const HomeProductos = () => {

return (
  <div className="d-flex justify-content-center align-items-center " style={{ height: "100vh" }}>
    <CardGroup className="mb-5" style={{ borderRadius: "15px",margin: "auto", }}>
      <Card className="mx-2 border-0">
        <Card.Img 
        variant="top"
          src="src/assets/images/card1.jpg"
          style={{width:"450px", height:"450px", objectFit: "cover",borderRadius: "15px"}} />
        <Card.Body>
          <Card.Title>Pizza Calabresa</Card.Title>
          <Card.Text>
            Salsa de tomate, mozzarella y salami suave
          </Card.Text>
        </Card.Body>
        <Card.Footer className="d-flex justify-content-between">
          <small className="text-muted">$3000</small>
          <div>
          <Button type="submit" style={{justifyContent:"right"}}>Comprar</Button>
          </div>
          
        </Card.Footer>
      </Card>

      <Card className="mx-2 border-0">
        <Card.Img variant="top" 
        src="src/assets/images/card2.jpg" 
        style={{width:"450px", height:"450px", objectFit: "cover",borderRadius: "15px"}}/>
        <Card.Body>
          <Card.Title>Pizza Original</Card.Title>
          <Card.Text>
            Salsa de tomate, pimiento y rucula
          </Card.Text>
        </Card.Body>
        <Card.Footer className="d-flex justify-content-between">
          <small className="text-muted">$3000</small>
          <div>
          <Button type="submit" style={{justifyContent:"right"}}>Comprar</Button>
          </div>
        </Card.Footer>
      </Card>

      <Card className="mx-2 border-0">
        <Card.Img variant="top" 
        src="src/assets/images/card3.jpg" 
        style={{width:"450px", height:"450px", objectFit: "cover",borderRadius: "15px"}}/>
        <Card.Body>
          <Card.Title>Pizza Pollo</Card.Title>
          <Card.Text>
            Salsa de tomate, mozzarella, pollo y salsa bbq
          </Card.Text>
        </Card.Body>
        <Card.Footer className="d-flex justify-content-between">
          <small className="text-muted">$3500</small>
          <div >
          <Button type="submit">Comprar</Button>
          </div>
        </Card.Footer>
      </Card>
    </CardGroup>
    </div>
  )
}

  export default HomeProductos
