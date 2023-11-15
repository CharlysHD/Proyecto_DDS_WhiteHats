export interface Factura {
    id: number;
    cantidad: number;
    subtotal: number;
    totalVenta: number;
    mpPreferenceId: number;
    mpPaymentType: number;
    mpPaymentId: number;
    mpMerchantOrderId: number;
    formaPago: string;
    fechaFacturacion: string;
    fechaBaja: string;
    fechaModificacion: string;
    fechaAlta: string;
}