import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "@env/environment";
import { Observable } from "rxjs";
import { Curso } from "../models/curso.model";

@Injectable()
export class CursosApiService {
    private readonly BASE_URL: string;

    constructor(private readonly httpClient: HttpClient) {
        this.BASE_URL = `${environment.baseUrl}/v1/cursos`
    }

    public listarPorModulo(modulo: string): Observable<Curso[]> {
        return this.httpClient.get<Curso[]>(`${this.BASE_URL}/modalidad/${modulo}`)
    }

    public registrarCurso(curso: Curso): Observable<string> {
        return this.httpClient.post<string>(`${this.BASE_URL}`, curso);
    }
}