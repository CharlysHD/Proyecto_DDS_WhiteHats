import { toast } from "react-toastify";
import { PedidoService } from "../../services/PedidoService";
import { Pedido } from "../../types/Pedido";
import { useFormik } from "formik";
import { ModalType } from "../../types/ModalType";
import { Button, Form, FormLabel, Modal } from "react-bootstrap";
import * as Yup from "yup";

type PedidoModalProps ={
    show: boolean;
    onHide: ()=> void;
    title: string;
    modalType: ModalType;
    ped: Pedido;
    refreshData: React.Dispatch<React.SetStateAction<boolean>>;
}

const PedidoModal = ({show, onHide, title, modalType, ped, refreshData}:PedidoModalProps ) => {

  const handleSaveUpdate= async (ped:Pedido) => {
    try {
      const isNew = ped.id===0;
      if (isNew) {
        await PedidoService.createPedido(ped);
      } else{
        await PedidoService.updatePedido(ped.id, ped);
      }
      toast.success(isNew ? "Pedido creado": "Pedido actualizado",{
        position: "top-center",
      });

      onHide();
      refreshData(prevState => !prevState);
    } catch (error) {
      console.error(error);
      toast.error("Ha ocurrido un error")
    }
  };

  const handleDelete=async () => {
    try {
      await PedidoService.deletePedido(ped.id);
      toast.success("Pedido borrado",{
        position:"top-center",
      });

      onHide();
      refreshData(prevState => !prevState);
    } catch (error) {
      console.error(error);
      toast.error("Ha ocurrido un error")
    }
  }

  const validationSchema= () => {
    return Yup.object().shape({
      id: Yup.number().integer().min(0),
      total: Yup.number().integer().min(0),
      totalCosto: Yup.number().integer().min(0),
      estado: Yup.string().required("El estado es requerido"),
      tipoEnvio: Yup.number().min(0).required("El tipo de envío es requerido"),
      formaPago: Yup.string().required("La forma de pago es requerido"),
      horaEstimadaFinalizacion: Yup.string().required("La hora es requerida"),
      fechaAlta: Yup.string().required("La fecha de registro es requerida"),
      fechaPedido: Yup.string().required("La fecha de registro es requerida"),
    });
  };

  const formik = useFormik({
    initialValues: ped,
    validationSchema: validationSchema(),
    validateOnChange: true,
    validateOnBlur: true,
    onSubmit: (obj: Pedido) => handleSaveUpdate(obj),
  });

  return (
    <>
    {modalType === ModalType.DELETE ? (
      <>
      <Modal show={show} onHide={onHide} centered backdrop="static">

        <Modal.Header closeButton>
          <Modal.Title> {title} </Modal.Title>
        </Modal.Header>

        <Modal.Body>
          <p>¿Está seguro que desea eliminar el Pedido <br/>
          <strong> {ped.id} </strong>?</p>
        </Modal.Body>

        <Modal.Footer>
          <Button variant="secondary" onClick={onHide}> Cancelar </Button>
          <Button variant="danger" onClick={handleDelete}> Borrar </Button>
        </Modal.Footer>

      </Modal>
      </>
    ):(
      <>
        <Modal show={show} onHide={onHide} centered backdrop="static" className="modal-xl">
          <Modal.Header>
            <Modal.Title> { title }</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <Form onSubmit={formik.handleSubmit}>

            {/* total */}
              <Form.Group controlId='formTotal'>
                <FormLabel> Total </FormLabel>
                <Form.Control 
                name="total"
                type="number"
                value={formik.values.total || ''}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                isInvalid={Boolean(formik.errors.total && formik.touched.total)}
                />
                <Form.Control.Feedback type='invalid'>
                  {formik.errors.total}
                </Form.Control.Feedback>
              </Form.Group>

              {/* totalCosto */}
              <Form.Group controlId='formTotalCosto'>
                <FormLabel> TotalCosto </FormLabel>
                <Form.Control 
                name="totalCosto"
                type="number"
                value={formik.values.totalCosto || ''}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                isInvalid={Boolean(formik.errors.totalCosto && formik.touched.totalCosto)}
                />
                <Form.Control.Feedback type='invalid'>
                  {formik.errors.totalCosto}
                </Form.Control.Feedback>
              </Form.Group>
            
            {/* estado */}
            <Form.Group controlId='formEstado'>
                <FormLabel> Email </FormLabel>
                <Form.Control 
                name="estado"
                type="text"
                value={formik.values.estado || ''}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                isInvalid={Boolean(formik.errors.estado && formik.touched.estado)}
                />
                <Form.Control.Feedback type='invalid'>
                  {formik.errors.estado}
                </Form.Control.Feedback>
              </Form.Group>

            {/* tipoEnvio */}
            <Form.Group controlId='formTipoEnvio'>
                <FormLabel> TipoEnvio </FormLabel>
                <Form.Control 
                name="tipoEnvio"
                type="text"
                value={formik.values.tipoEnvio || ''}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                isInvalid={Boolean(formik.errors.tipoEnvio && formik.touched.tipoEnvio)}
                />
                <Form.Control.Feedback type='invalid'>
                  {formik.errors.tipoEnvio}
                </Form.Control.Feedback>
              </Form.Group>

             {/* formaPago */}
             <Form.Group controlId='formFormaPago'>
                <FormLabel> FormaPago </FormLabel>
                <Form.Control 
                name="formaPago"
                type="text"
                value={formik.values.formaPago || ''}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                isInvalid={Boolean(formik.errors.formaPago && formik.touched.formaPago)}
                />
                <Form.Control.Feedback type='invalid'>
                  {formik.errors.formaPago}
                </Form.Control.Feedback>
              </Form.Group>

              {/* horaEstimadaFinalizacion */}
            <Form.Group controlId='formHoraEstimadaFinalizacion'>
                <FormLabel> HoraEstimadaFinalizacion </FormLabel>
                <Form.Control 
                name="horaEstimadaFinalizacion"
                type="number"
                value={formik.values.horaEstimadaFinalizacion || ''}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                isInvalid={Boolean(formik.errors.horaEstimadaFinalizacion && formik.touched.horaEstimadaFinalizacion)}
                />
                <Form.Control.Feedback type='invalid'>
                  {formik.errors.horaEstimadaFinalizacion}
                </Form.Control.Feedback>
              </Form.Group>

              {/* fechaAlta */}
            <Form.Group controlId='formfechaAlta'>
                <FormLabel> Fecha de Registro </FormLabel>
                <Form.Control 
                name="fechaAlta"
                type="text"
                value={formik.values.fechaAlta || ''}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                isInvalid={Boolean(formik.errors.fechaAlta && formik.touched.fechaAlta)}
                />
                <Form.Control.Feedback type='invalid'>
                  {formik.errors.fechaAlta}
                </Form.Control.Feedback>
              </Form.Group>

              {/* fechaPedido */}
            <Form.Group controlId='formfechaPedido'>
                <FormLabel> FechaPedido </FormLabel>
                <Form.Control 
                name="fechaPedido"
                type="text"
                value={formik.values.fechaPedido || ''}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                isInvalid={Boolean(formik.errors.fechaPedido && formik.touched.fechaPedido)}
                />
                <Form.Control.Feedback type='invalid'>
                  {formik.errors.fechaPedido}
                </Form.Control.Feedback>
              </Form.Group>

              <Modal.Footer className="mt-4">
                <Button variant="secondary" onClick={onHide}> Cancelar </Button>
                <Button variant="primary" type="submit" disabled={!formik.isValid}> Guardar </Button>
              </Modal.Footer>
            </Form>
          </Modal.Body>
        </Modal>
      </>
    )}
    </>
  )
}

export default PedidoModal