import { FacturaService } from "../../services/FacturaService";
import { ModalType } from "../../types/ModalType";
import { Factura } from "../../types/Factura";
import { Button, Form, FormLabel, Modal } from "react-bootstrap";
import { toast } from "react-toastify";
import * as Yup from "yup";
import { useFormik } from "formik";

type FacturaModalProps = {
  show: boolean;
  onHide: () => void;
  title: string;
  modalType: ModalType;
  fac: Factura;
  refreshData: React.Dispatch<React.SetStateAction<boolean>>;
}

const FacturaModal = ({ show, onHide, title, modalType, fac, refreshData }: FacturaModalProps) => {


  //CREATE - UPDATE
  const handleSaveUpdate = async (fac: Factura) => {
    try {
      const isNew = fac.id === 0;


      if (isNew) {
        await FacturaService.createFactura(fac);
      } else {
        await FacturaService.updateFactura(fac.id, fac);
      }
      toast.success(isNew ? "Factura creada" : "Factura actualizada", {
        position: "top-center",
      });

      onHide();
      refreshData(prevState => !prevState);
    } catch (error) {
      console.error(error);
      toast.error("Ha ocurrido un error")
    }
  };

  const handleDelete = async () => {
    try {
      await FacturaService.deleteFactura(fac.id);
      toast.success("Factura borrado", {
        position: "top-center",
      });

      onHide();
      refreshData(prevState => !prevState);
    } catch (error) {
      console.error(error);
      toast.error("Ha ocurrido un error")
    }
  }


  //Yup
  const validationSchema = () => {
    return Yup.object().shape({
      id: Yup.number().integer().min(0),
      cantidad: Yup.number().min(0).required("El dato es requerido"),
      subtotal: Yup.number().min(0).required("El dato es requerido"),
      formaPago: Yup.string().required("El dato es requerido"),
      fechaFacturacion: Yup.string().required("El dato es requerido"),
      totalVenta: Yup.number().min(0).required("El dato es requerido"),
      
    });
  };

  //Formik
  const formik = useFormik({
    initialValues: fac,
    validationSchema: validationSchema(),
    validateOnChange: true,
    validateOnBlur: true,
    onSubmit: (obj: Factura) => handleSaveUpdate(obj),
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
              <p>¿Está seguro que desea eliminar la factura? <br />
                <strong> {fac.id} </strong>?</p>
            </Modal.Body>

            <Modal.Footer>
              <Button variant="secondary" onClick={onHide}> Cancelar </Button>
              <Button variant="danger" onClick={handleDelete}> Borrar </Button>
            </Modal.Footer>

          </Modal>
        </>
      ) : (
        < >
          <Modal show={show} onHide={onHide} centered backdrop="static" className="modal-xl" >
            <Modal.Header style={{backgroundColor:'#A52326', color:'white', justifyContent:'center'}}>
              <Modal.Title> {title}</Modal.Title>
            </Modal.Header>
            <Modal.Body>
              <Form onSubmit={formik.handleSubmit}>

                {/* Cantidad */}
                <Form.Group controlId='cantidad'>
                  <FormLabel> Cantidad </FormLabel>
                  <Form.Control
                    name="cantidad"
                    type="number"
                    value={formik.values.cantidad || ''}
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                    isInvalid={Boolean(formik.errors.cantidad && formik.touched.cantidad)}
                  />
                  <Form.Control.Feedback type='invalid'>
                    {formik.errors.cantidad}
                  </Form.Control.Feedback>
                </Form.Group>

                {/* Sub Total */}
                <Form.Group controlId='formsubtotal'>
                  <FormLabel> Sub Total</FormLabel>
                  <Form.Control
                    name="subtotal"
                    type="number"
                    value={formik.values.subtotal || ''}
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                    isInvalid={Boolean(formik.errors.subtotal && formik.touched.subtotal)}
                  />
                  <Form.Control.Feedback type='invalid'>
                    {formik.errors.subtotal}
                  </Form.Control.Feedback>
                </Form.Group>

                {/* Forma de pago */}
                <Form.Group controlId='formformaPago'>
                  <FormLabel> Forma de pago</FormLabel>
                  <Form.Control
                    name="formaPago"
                    type="string"
                    value={formik.values.formaPago || ''}
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                    isInvalid={Boolean(formik.errors.formaPago && formik.touched.formaPago)}
                  />
                  <Form.Control.Feedback type='invalid'>
                    {formik.errors.formaPago}
                  </Form.Control.Feedback>
                </Form.Group>

                {/* Forma de pago */}
                <Form.Group controlId='formfechaFacturacion'>
                  <FormLabel> Fecha de Facturacion</FormLabel>
                  <Form.Control
                    name="fechaFacturacion"
                    type="string"
                    value={formik.values.fechaFacturacion || ''}
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                    isInvalid={Boolean(formik.errors.fechaFacturacion && formik.touched.fechaFacturacion)}
                  />
                  <Form.Control.Feedback type='invalid'>
                    {formik.errors.fechaFacturacion}
                  </Form.Control.Feedback>
                </Form.Group>

                {/* Total Venta */}
                <Form.Group controlId='formtotalVenta'>
                  <FormLabel> Total Venta</FormLabel>
                  <Form.Control
                    name="totalVenta"
                    type="number"
                    value={formik.values.totalVenta || ''}
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                    isInvalid={Boolean(formik.errors.totalVenta && formik.touched.totalVenta)}
                  />
                  <Form.Control.Feedback type='invalid'>
                    {formik.errors.totalVenta}
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

export default FacturaModal