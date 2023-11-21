import { Producto } from '../types/Product';


const BASE_URL = 'https://example-service-fourth.onrender.com';
const token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";


export const ProductService = {

    getProducts: async (): Promise<Producto[]> => {
        const response = await fetch(`${BASE_URL}/api/v1/producto`);
        const data = await response.json();
        return data;
    },

    getProduct: async (id: number): Promise<Producto> => {
        const response = await fetch(`${BASE_URL}/api/v1/producto/${id}`);
        const data = await response.json();
        return data;
    },

    createProduct: async (producto: Producto): Promise<Producto> => {
        const response = await fetch(`${BASE_URL}/api/v1/producto`, {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            },
            body: JSON.stringify(producto)
        });
        const data = await response.json();
        return data;
    },

    updateProduct: async (id: number, producto: Producto): Promise<Producto> => {
        const response = await fetch(`${BASE_URL}/api/v1/producto/${id}`, {
            method: "PUT",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(producto)
        });
        const data = await response.json();
        return data;
    },

    deleteProduct: async (id: number): Promise<void> => {
        await fetch(`${BASE_URL}/api/v1/producto/${id}`, {
            method: "DELETE"
        });
    }

};
