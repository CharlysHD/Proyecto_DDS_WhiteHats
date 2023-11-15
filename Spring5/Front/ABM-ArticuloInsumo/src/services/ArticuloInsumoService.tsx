import { ArticuloInsumo } from "../types/ArticuloInsumo";

const BASE_URL= 'https://example-service-thrid.onrender.com';

export const ArticuloInsumoService= {
    

    getArticulosInsumo:async (): Promise<ArticuloInsumo[]> => {
        const response= await fetch(`${BASE_URL}/api/v1/articuloinsumo`);
        const data= await response.json();

        return data;
    },
    
    getArticuloInsumo:async (id:number): Promise<ArticuloInsumo> => {
        const response= await fetch(`${BASE_URL}/api/v1/articuloinsumo/${id}`);
        const data= await response.json();
        return data;
    },

    createArticuloInsumo:async (articuloinsumo:ArticuloInsumo):Promise<ArticuloInsumo> => {
        const response= await fetch(`${BASE_URL}/api/v1/articuloinsumo`,{
            method: "POST",
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(articuloinsumo)
        });
        const data= await response.json();
        return data;
    },

    updateArticuloInsumo:async (id:number, articuloinsumo:ArticuloInsumo):Promise<ArticuloInsumo> => {
        const response= await fetch(`${BASE_URL}/api/v1/articuloinsumo/${id}` ,{
            method: "PUT",
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(articuloinsumo)
        });
        const data= await response.json();
        return data;
    },

    deleteArticuloInsumo:async (id:number):Promise<void> => {
        await fetch(`${BASE_URL}/api/v1/articuloinsumo/${id}` ,{
            method: "DELETE"
        });

    }
}