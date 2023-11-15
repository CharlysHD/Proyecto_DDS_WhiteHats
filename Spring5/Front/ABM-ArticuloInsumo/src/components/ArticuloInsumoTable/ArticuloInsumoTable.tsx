import { useEffect, useState } from "react"
import { ArticuloInsumo } from "../../types/ArticuloInsumo"
import { ArticuloInsumoService } from "../../services/ArticuloInsumoService";
import { Button, Table } from "react-bootstrap";
import Loader from "../Loader/Loader";
import { ModalType } from '../../types/ModalTypes';
import ArticuloInsumoModal from "../ArticuloInsumoModal/ArticuloInsumoModal";
import EditButton from "../EditButton/EditButton";
import DeleteButton from "../DeleteButton/DeleteButton";



const ArticuloInsumoTable = () => {
    
    const[articulosInsumo, setArticulosInsumo]= useState<ArticuloInsumo[]>([]);
    
    const[isLoading, setIsLoading]=useState(true);
    
    
    const[refreshData, setRefreshData]=useState(false);

   
    useEffect(()=> {
        
        const fetchArticulosInsumo=async () => {
            const articulosInsumo = await ArticuloInsumoService.getArticulosInsumo();
            setArticulosInsumo(articulosInsumo);
            setIsLoading(false);
        };

        fetchArticulosInsumo();
    }, [refreshData]);
   
    console.log(JSON.stringify(articulosInsumo, null, 2));
    
  
    const initializableNewArticuloInsumo= (): ArticuloInsumo =>{
      return{
        id: 0,
        denominacion: "",
        precioCompra: 0,
        stockActual: 0,
        stockMinimo: 0,
        urlImagen: "",
        fechaAlta: "",
        fechaBaja: "",
        fechaModificacion: "",
      };
    };
    const  [articuloInsumo, setArticuloInsumo]= useState<ArticuloInsumo>(initializableNewArticuloInsumo);
 
    const[showModal, setShowModal]= useState(false);
    const[modalType, setModalType]= useState<ModalType>(ModalType.NONE);
    const[title, setTitle]= useState("");

  
    const handleClick= (newTitle: string, insu: ArticuloInsumo, modal:ModalType)=> {
      setTitle(newTitle);
      setModalType(modal);
      setArticuloInsumo(insu);
      setShowModal(true);
    };

  return (
    <>
    <Button onClick={()=> handleClick("Nuevo Articulo Insumo", initializableNewArticuloInsumo(),
    ModalType.CREATE)}> Nuevo Insumo </Button>
      {isLoading ? <Loader/>: (
        <Table hover>
          <thead>
            <tr>
              <th>Denominacion</th>
              <th>Precio de Compra</th>
              <th>Stock Actual</th>
              <th>Stock Minimo</th>
              <th>Imagen</th>
              <th>Fecha Alta</th>
              <th>Editar</th>
              <th>Borrar</th>
            </tr>
          </thead>
          <tbody>
            {articulosInsumo.map(articuloInsumo =>(
            
              <tr key={articuloInsumo.id}>
                <td>{articuloInsumo.denominacion}</td>
                <td>{articuloInsumo.precioCompra}</td>
                <td>{articuloInsumo.stockActual}</td>
                <td>{articuloInsumo.stockMinimo}</td>
                <td><img src={articuloInsumo.urlImagen} alt={articuloInsumo.denominacion} style={{width: '50px'}} /></td>
                <td>{articuloInsumo.fechaAlta}</td>
                

                <td><EditButton onClick={() => handleClick("Editar Articulo Insumo", articuloInsumo, ModalType.UPDATE)}/></td>
                <td><DeleteButton onClick={() => handleClick("Borrar Articulo Insumo", articuloInsumo, ModalType.DELETE)}/></td>


              </tr>
            ))}
          </tbody>
        </Table>
      )}

      {showModal && (
        <ArticuloInsumoModal
        show={showModal} 
        onHide={()=> setShowModal(false)}
        title={title}
        modalType={modalType}
        insu={articuloInsumo}
        refreshData={setRefreshData}
        />
      )}

    </>
  )
}

export default ArticuloInsumoTable