import { CoursesService } from './../service/courses.service';
import { Component, OnInit } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';
import { Course } from '../model/course';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from '../share/components/error-dialog/error-dialog.component';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit{

  courses$: Observable<Course[]>;

  displayedColumns = ['name', 'category'];

  constructor(
    private coursesService: CoursesService,
    public dialog: MatDialog
    ){
    this.courses$ = this.coursesService.list().pipe(
      catchError(error => {
        this.onError('Erro ao carregar cursos!');
        return of([])
      })
    );
  }

  onError(errorMsg: string){
    this.dialog.open(ErrorDialogComponent,
      {data: errorMsg});
  }

  ngOnInit(): void {

   }

}

