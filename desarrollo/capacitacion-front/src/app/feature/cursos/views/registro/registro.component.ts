import { Component } from "@angular/core";
import { Curso } from "@feature/cursos/models/curso.model";

@Component({
    templateUrl: './registro.component.html',
    styleUrls: ['./registro.component.scss']
})
export class RegistroComponent {
    curso: Curso

    constructor() {}
}