import { Injectable } from "@angular/core";
import { Curso } from "../models/curso.model";

@Injectable()
export class CursosService {
    public obtenerCamposAVisualizar(): string[] {
        return ['codigo', 'nombre', 'descripcion', 'costo', 'horas', 'publicoObjetivo', 'acciones']
    }

    public obtenerListadoModalidades(): string[] {
        return ['OnDemand', 'Online', 'Privado'];
    }
}