import { useEffect, useState } from "react";
import { PedidoService } from "../../services/PedidoService";
import { Pedido } from "../../types/Pedido";
import { Button, Table } from "react-bootstrap";
import { ModalType } from "../../types/ModalType";
import Loader from "../Loader/Loader";
import { EditButton } from "../EditButton/EditButton";
import { DeleteButton } from "../DeleteButton/DeleteButton";
// import { Table } from "react-bootstrap-icons";
import PedidoModal from "../PedidoModal/PedidoModal";

const PedidoTable = () => {

    //Variable que va a contener los datos recibidos por la API
    const [pedidos, setPedidos] = useState<Pedido[]>([]);

    //Variable que muestra el componente Loader hasta que se reciban los datos de la API
    const [isLoading, setIsLoading] = useState(true);

    const [refreshData, setRefreshData] = useState(false);

    //Este hook se va a ejecutar cada vez que se renderize el componente
    useEffect(() => {

    //Llamamos a la funcion para obtener todos los productos declarado en el service
        const fetchPedidos = async () => {
            const pedidos = await PedidoService.getPedidos();
            setPedidos(pedidos);
            setIsLoading(false);
        };

        fetchPedidos();

    }, [refreshData]);

    //Test, este log esta modificado para que muestre los datos de una manera mas legible
    console.log(JSON.stringify(pedidos, null, 2));
    
    const initializableNewPedido = (): Pedido =>{
        return{
          id: 0,
          total: 0,
          totalCosto: 0,
          estado: "",
          tipoEnvio: "",
          formaPago: "",
          horaEstimadaFinalizacion: "",
          fechaAlta: "",
          fechaModificacion: "",
          fechaBaja: "",
          fechaPedido: "",
        };
    };

    const [pedido, setPedido] = useState<Pedido>(initializableNewPedido);

    const[showModal, setShowModal]= useState(false);
    const[modalType, setModalType]= useState<ModalType>(ModalType.NONE);
    const[title, setTitle]= useState("");

    const handleClick= (newTitle: string, ped: Pedido, modal:ModalType)=> {
        setTitle(newTitle);
        setModalType(modal);
        setPedido(ped);
        setShowModal(true);
      };

      return (
        <>
        <Button onClick={()=> handleClick("Nuevo pedido", initializableNewPedido(),
        ModalType.CREATE)}> Nuevo Pedido </Button>
          {isLoading ? <Loader/>: (
            <Table hover>
              <thead>
                <tr>
                  <th>Total</th>
                  <th>Total Costo</th>
                  <th>Estado</th>
                  <th>Tipo de envío</th>
                  <th>Forma de pago</th>
                  <th>Hora Finalizacion</th>
                  <th>Fecha Alta</th>
                  <th>Fecha Modificacion</th>
                  <th>Fecha Baja</th>
                  <th>Fecha Pedido</th>
                  <th>Editar</th>
                  <th>Borrar</th>
                </tr>
              </thead>
              <tbody>
                {pedidos.map(pedido =>(
                  <tr key={pedido.id}>
                    <td>{pedido.total}</td>
                    <td>{pedido.totalCosto}</td>
                    <td>{pedido.estado}</td>
                    <td>{pedido.tipoEnvio}</td>
                    <td>{pedido.formaPago}</td>
                    <td>{pedido.horaEstimadaFinalizacion}</td>
                    <td>{pedido.fechaAlta}</td>
                    <td>{pedido.fechaModificacion}</td>
                    <td>{pedido.fechaBaja}</td>
                    <td>{pedido.fechaPedido}</td>
                    <td><EditButton onClick={() => handleClick("Editar Pedido", pedido, ModalType.UPDATE)}/></td>
                    <td><DeleteButton onClick={() => handleClick("Borrar Pedido", pedido, ModalType.DELETE)}/></td>
                  </tr>
                ))}
              </tbody>
            </Table>
          )}
    
          {showModal && (
            <PedidoModal
            show={showModal} 
            onHide={()=> setShowModal(false)}
            title={title}
            modalType={modalType}
            ped={pedido}
            refreshData={setRefreshData}
            />
          )}
    
        </>
      )
}

export default PedidoTable;
