import { Component, OnInit } from "@angular/core";
import { Curso } from "@feature/cursos/models/curso.model";
import { CursosApiService } from "@feature/cursos/services/cursos-api.service";
import { CursosService } from "@feature/cursos/services/cursos.service";
import { Observable } from "rxjs";

@Component({
    templateUrl: './listado-modalidad.component.html',
    styleUrls: ['/listado-modalidad.component.scss']
})
export class ListadoModalidadComponent implements OnInit {
    public cursos$: Observable<Curso[]> | undefined;
    public camposAVisualizar: string[] | undefined;
    public modalidades: string[] | undefined;

    constructor(private readonly cursosApiService: CursosApiService,
                private readonly cursosService: CursosService) {
    }

    public ngOnInit(): void {
        this.cursos$ = this.cursosApiService.listarPorModulo('OnDemand');
        this.camposAVisualizar = this.cursosService.obtenerCamposAVisualizar();
        this.modalidades = this.cursosService.obtenerListadoModalidades();
    }

    public manejarSeleccionModulo(modulo: string): void {
        console.log(modulo);
    }
}