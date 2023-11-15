import { useEffect, useState } from "react"
import { Factura } from "../../types/Factura"
import { FacturaService } from "../../services/FacturaService";
import { Button, Table } from "react-bootstrap";
import Loader from "../Loader/Loader";
import { ModalType } from "../../types/ModalType";
import FacturaModal from "../FacturaModal/FacturaModal";
import EditButton from "../EditButton/EditButton";
import DeleteButton from "../DeleteButton/DeleteButton";





const FacturaTable = () => {
    
    const[facturas, setFacturas]= useState<Factura[]>([]);

    const[isLoading, setIsLoading]=useState(true);
    
    const[refreshData, setRefreshData]=useState(false);


    //este hook se va a ejecutar cada vez que se renderice el componente
    useEffect(()=> {
        const fetchFacturas= async () => {
            const facturas = await FacturaService.getFacturas();
            setFacturas(facturas);
            setIsLoading(false);
        };

        fetchFacturas();

    }, [refreshData]);

    //Test, este log esta modificado para que muestre los datos de una manera mas legible
    console.log(JSON.stringify(facturas, null, 2));
    //strigify es convertir un objeto javaScript en una cadena JSON
  
    //Const para inicializar un producto por defecto y evitar el "undefined"
    // vayamos a crear una factura nuevo
    const initializableNewFactura = (): Factura =>{
      return{
        id: 0,
        cantidad: 0,
        subtotal: 0,
        totalVenta: 0,
        mpPreferenceId: 0,
        mpPaymentType: 0,
        mpPaymentId: 0,
        mpMerchantOrderId: 0,
        formaPago: "",
        fechaFacturacion: "",
        fechaBaja: "",
        fechaModificacion: "",
        fechaAlta: "",
      };
    };

    //producto selecionado que se va a pasar como prop al Modal
    const  [factura, setFactura]= useState<Factura>(initializableNewFactura);

    //const para manejar el estado del modal
    const[showModal, setShowModal]= useState(false);
    const[modalType, setModalType]= useState<ModalType>(ModalType.NONE);
    const[title, setTitle]= useState("");

    //Logica del Modal
    const handleClick= (newTitle: string, fac: Factura, modal:ModalType)=> {
      setTitle(newTitle);
      setModalType(modal);
      setFactura(fac);
      setShowModal(true);
    };

  return (
    <>
    <Button onClick={()=> handleClick("Nueva Factura", initializableNewFactura(),
    ModalType.CREATE)}> Nueva Factura </Button>

      {isLoading ? <Loader/>: (
        <Table hover>
          <thead>
            <tr>
              <th>ID</th>
              <th>Cantidad</th>
              <th>Sub Total</th>
              <th>Forma de pago</th>
              <th>Fecha de Facturacion</th>
              <th>Total Venta</th>
            </tr>
          </thead>
          <tbody>
            {facturas.map(factura =>(
              <tr key={factura.id}>
                <td>{factura.cantidad}</td>
                <td>{factura.subtotal}</td>
                <td>{factura.totalVenta}</td>
                <td>{factura.formaPago}</td>
                <td>{factura.fechaFacturacion}</td>
                <td></td>
                <td><EditButton onClick={() => handleClick("Editar Factura", factura, ModalType.UPDATE)}/></td>
                <td><DeleteButton onClick={() => handleClick("Borrar Factura", factura, ModalType.DELETE)}/></td>
              </tr>
            ))}
          </tbody>
        </Table>
      )}

      {showModal && (
        <FacturaModal
        show={showModal} 
        onHide={()=> setShowModal(false)}
        title={title}
        modalType={modalType}
        fac={factura}
        refreshData={setRefreshData}
        />
      )}

    </>
  )
}

export default FacturaTable