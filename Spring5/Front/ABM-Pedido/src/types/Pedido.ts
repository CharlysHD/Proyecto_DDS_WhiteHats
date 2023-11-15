export interface Pedido {
    id: number;
    total: number;
    totalCosto: number;
    estado: string;
    tipoEnvio: string;
    formaPago: string;
    horaEstimadaFinalizacion: string;
    fechaAlta: string;
    fechaModificacion: string;
    fechaBaja: string;
    fechaPedido: string;
}