import { useFormik } from "formik"
import { MDBBtn } from "mdb-react-ui-kit";
import { Container } from "react-bootstrap";
import * as Yup from 'yup';

const validationSchema = Yup.object({
    name: Yup.string().required('El nombre es requerido'),
    email: Yup.string().required('El email es requerido').email('Email no válido'),
    password: Yup.string().required('La contraseña es requerida').min(8, 'La contraseña debe tener 8 caracteres mínimo'),
})

export const Form = () => {
  
  const formik = useFormik ({
    
    // Lo que necesita el formulario
    initialValues: {
        name: '',
        email: '',
        password: '',

    },

    // Validación con YUP
    validationSchema: validationSchema,

    // Un alert
    onSubmit: (values) => {
        alert(JSON.stringify(values, null, 2));
    },
  })
  
    return (
    <>
        <Container className="d-flex jsutify-content-center align-items-center">
            <div className="border rounded-3 p-5 mt-5">
                <h1>Formulario de registro</h1>
                <h5 className="text-center">con Formik y Yup!</h5>
                <form onSubmit={formik.handleSubmit}>

                    {/* Nombre */}
                    <div className="mb-3 mt-3">
                        <label htmlFor="name" className="form-label">Nombre</label>
                        <input type="text" className="form-control" id="name" onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.name} />
                        {formik.touched.name && formik.errors.name ? (
                            <div className="text-danger"> {formik.errors.name} </div>
                        ) : null}
                    </div>

                    {/* Email */}
                    <div className="mb-3 mt-3">
                        <label htmlFor="email" className="form-label">Email</label>
                        <input type="text" className="form-control" id="email" onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.email} />
                        {formik.touched.email && formik.errors.email ? (
                            <div className="text-danger"> {formik.errors.email} </div>
                        ) : null}
                    </div>

                    {/* Password */}
                    <div className="mb-3 mt-3">
                        <label htmlFor="password" className="form-label">Password</label>
                        <input type="text" className="form-control" id="password" onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.password} />
                        {formik.touched.password && formik.errors.password ? (
                            <div className="text-danger"> {formik.errors.password} </div>
                        ) : null}
                    </div>

                    {/* Button */}
                    <div className="text-end">
                        <MDBBtn outline className='mx-2' color='dark' type="submit">
                            Submit
                        </MDBBtn>
                    </div>
                </form>
            </div>
        </Container>
    </>
  )
}