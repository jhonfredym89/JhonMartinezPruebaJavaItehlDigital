import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
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
    public modalidadSeleccionada: string = 'OnDemand'

    constructor(private readonly cursosApiService: CursosApiService,
                private readonly cursosService: CursosService,
                private readonly router: Router) {
    }

    public ngOnInit(): void {
        this.cursos$ = this.cursosApiService.listarPorModulo(this.modalidadSeleccionada);
        this.camposAVisualizar = this.cursosService.obtenerCamposAVisualizar();
        this.modalidades = this.cursosService.obtenerListadoModalidades();
    }

    public manejarSeleccionModulo(): void {
        console.log(this.modalidadSeleccionada);
        this.cursos$ = this.cursosApiService.listarPorModulo(this.modalidadSeleccionada);
    }

    public manejarClicNuevo(): void {
        this.router.navigate(['cursos/registro']);
    }
}