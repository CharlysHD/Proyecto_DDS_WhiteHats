import { Spinner } from "react-bootstrap";


export const Loader = () => {
    return (
        <Spinner animation="grow" role="status" variant="primary" style={{display: "flex", position: "absolute", left: "50%", top: "50%"}}>
          <span className="visually-hidden">Loading...</span>
        </Spinner>
    );
}