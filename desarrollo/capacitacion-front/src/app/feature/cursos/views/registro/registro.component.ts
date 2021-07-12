import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { CursosApiService } from "@feature/cursos/services/cursos-api.service";
import { MatSnackBar } from "@angular/material";
import { Router } from "@angular/router";

@Component({
    templateUrl: './registro.component.html',
    styleUrls: ['./registro.component.scss']
})
export class RegistroComponent {
    public formRegistrarCurso: FormGroup 

    constructor(private readonly formBuilder: FormBuilder,
                private readonly cursoApiService: CursosApiService,
                private readonly snackBar: MatSnackBar,
                private readonly router: Router) {

        this.formRegistrarCurso = this.formBuilder.group({
            codigo: ['', Validators.required],
            nombre: ['', Validators.required],
            descripcion: [''],
            costo: ['', Validators.required],
            horas: ['', Validators.required],
            publicoObjetivo: [''],
            modalidad: ['', Validators.required]
        });
    }

    public manejarClicRegistrar(): void {
        this.cursoApiService.registrarCurso(this.formRegistrarCurso.value).subscribe(
            response => {
                this.snackBar.open('Curso registrado exitosamente', '', {
                    duration: 2000,
                    horizontalPosition: 'center',
                    verticalPosition: 'bottom'
                });
                this.router.navigate(['cursos']);
            }, 
            error => {
                this.snackBar.open(error.error.mensaje, '', {
                    duration: 2000,
                    horizontalPosition: 'center',
                    verticalPosition: 'bottom'
                });
            }
        );
    }
}