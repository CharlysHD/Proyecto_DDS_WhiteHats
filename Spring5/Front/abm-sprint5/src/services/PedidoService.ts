import { Pedido } from "../types/Pedido";


const BASE_URL = 'https://example-service-thrid.onrender.com';

export const PedidoService = {
	
    getPedidos: async (): Promise<Pedido[]> => {
        const response = await fetch(`${BASE_URL}/api/v1/pedido`);
        const data = await response.json();
        return data;
    },

    getPedido: async (id: number): Promise<Pedido> => {
        const response = await fetch(`${BASE_URL}/api/v1/pedido/${id}`);
                const data = await response.json();
                return data;
    },
        
    createPedido: async (pedido: Pedido): Promise<Pedido> => {
        const response = await fetch(`${BASE_URL}/api/v1/pedido`, {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(pedido)
        });
        const data = await response.json();
        return data;
    },

    updatePedido: async (id: number, pedido: Pedido): Promise<Pedido> => {
        const response = await fetch(`${BASE_URL}/api/v1/pedido/${id}`, {
            method: "PUT",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(pedido)
        });
            const data = await response.json();
        return data;
    },
        
    deletePedido: async (id: number): Promise<void> => {
        await fetch(`${BASE_URL}/api/v1/pedido/${id}`, {
            method: "DELETE"
        });
    }
        
};
