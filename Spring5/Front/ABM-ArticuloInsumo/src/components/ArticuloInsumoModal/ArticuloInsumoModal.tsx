import { ArticuloInsumo } from "../../types/ArticuloInsumo";
import { Button, Form, FormLabel, Modal } from 'react-bootstrap';
import { ModalType } from "../../types/ModalTypes";
import * as Yup from 'yup'
import { useFormik } from "formik";
import { ArticuloInsumoService} from '../../services/ArticuloInsumoService';
import {toast} from 'react-toastify';

type ArticuloInsumoModalProps ={
    show: boolean;
    onHide: ()=> void;
    title: string;
    modalType: ModalType;
    insu: ArticuloInsumo;
    refreshData: React.Dispatch<React.SetStateAction<boolean>>;
}



const ArticuloInsumoModal = ({show, onHide, title, modalType, insu, refreshData}:ArticuloInsumoModalProps ) => {


  const handleSaveUpdate= async (ins:ArticuloInsumo) => {
    try {
      const isNew = ins.id===0;
      if (isNew) {
        await ArticuloInsumoService.createArticuloInsumo(ins);
      } else{
        await ArticuloInsumoService.updateArticuloInsumo(ins.id, ins);
      }
      toast.success(isNew ? "Articulo Insumo creado": "Articulo Insumo actualizado",{
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
      await ArticuloInsumoService.deleteArticuloInsumo(insu.id);
      toast.success("Articulo Insumo borrado",{
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
      denominacion: Yup.string().required('La descripcion es requerida'),
      precioCompra: Yup.number().min(0).required('El precio de compra es requerido'),
      stockActual: Yup.string().required('El stock actual es requerido'),
      stockMinimo: Yup.string().required('El stock minimo es requerido'),
      urlImagen: Yup.string().required('La URL de la imagen es requerida'),
      fechaAlta: Yup.string().required("La fecha de registro es requerida"),
    });
  };


  const formik = useFormik({
    initialValues: insu,
    validationSchema: validationSchema(),
    validateOnChange: true,
    validateOnBlur: true,
    onSubmit: (obj: ArticuloInsumo) => handleSaveUpdate(obj),
  });

  return (
    <>
    {modalType ===ModalType.DELETE ? (
      <>
      <Modal show={show} onHide={onHide} centered backdrop="static">

        <Modal.Header closeButton>
          <Modal.Title> {title} </Modal.Title>
        </Modal.Header>

        <Modal.Body>
          <p>¿Está seguro que desea eliminar el Insumo <br/>
          <strong> {insu.denominacion} </strong>?</p>
        </Modal.Body>

        <Modal.Footer>
          <Button variant="secondary" onClick={onHide}> Cancelar </Button>
          <Button variant="danger" onClick={handleDelete}> Eliminar </Button>
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
        
            {/* denominacion */}
              <Form.Group controlId='formDenominacion'>
                <FormLabel> Denominacion </FormLabel>
                <Form.Control 
                name="denominacion"
                type="text"
                value={formik.values.denominacion || ''}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                isInvalid={Boolean(formik.errors.denominacion && formik.touched.denominacion)}
                />
                <Form.Control.Feedback type='invalid'>
                  {formik.errors.denominacion}
                </Form.Control.Feedback>
              </Form.Group>
            
            {/* precio */}
              <Form.Group controlId='formPrecioCompra'>
                <FormLabel> PrecioCompra </FormLabel>
                <Form.Control 
                name="precioCompra"
                type="number"
                value={formik.values.precioCompra || ''}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                isInvalid={Boolean(formik.errors.precioCompra && formik.touched.precioCompra)}
                />
                <Form.Control.Feedback type='invalid'>
                  {formik.errors.precioCompra}
                </Form.Control.Feedback>
              </Form.Group>
            
            {/* stock Actual */}
              <Form.Group controlId='formStockActual'>
                <FormLabel> stock Actual </FormLabel>
                <Form.Control 
                name="stockActual"
                type="number"
                value={formik.values.stockActual || ''}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                isInvalid={Boolean(formik.errors.stockActual && formik.touched.stockActual)}
                />
                <Form.Control.Feedback type='invalid'>
                  {formik.errors.stockActual}
                </Form.Control.Feedback>
              </Form.Group>

          {/* stock Minimo */}
          <Form.Group controlId='formStockMinimo'>
                <FormLabel> stock Minimo </FormLabel>
                <Form.Control 
                name="stockMinimo"
                type="number"
                value={formik.values.stockMinimo || ''}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                isInvalid={Boolean(formik.errors.stockMinimo && formik.touched.stockMinimo)}
                />
                <Form.Control.Feedback type='invalid'>
                  {formik.errors.stockMinimo}
                </Form.Control.Feedback>
              </Form.Group>
            
            {/* imagen */}
              <Form.Group controlId='formurlImagen'>
                <FormLabel> Imagen </FormLabel>
                <Form.Control 
                name="urlImagen"
                type="text"
                value={formik.values.urlImagen || ''}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                isInvalid={Boolean(formik.errors.urlImagen && formik.touched.urlImagen)}
                />
                <Form.Control.Feedback type='invalid'>
                  {formik.errors.urlImagen}
                </Form.Control.Feedback>
              </Form.Group>


                 {/* fechaAlta */}
              <Form.Group controlId='formfechaAlta'>
                <FormLabel> Fecha de Registro Del Insumo </FormLabel>
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

export default ArticuloInsumoModal