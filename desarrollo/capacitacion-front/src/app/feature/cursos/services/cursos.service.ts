import { Injectable } from "@angular/core";
import { Curso } from "../models/curso.model";

@Injectable()
export class CursosService {
    public obtenerCamposAVisualizar(): (keyof Curso)[] {
        return ['codigo', 'nombre', 'descripcion', 'costo', 'horas', 'publicoObjetivo']
    }

    public obtenerListadoModalidades(): any[] {
        return [
            {
                valor: 'OnDemand'
            },
            {
                valor: 'Online'
            },
            {
                valor: 'Privado'
            } 
        ];
    }
}