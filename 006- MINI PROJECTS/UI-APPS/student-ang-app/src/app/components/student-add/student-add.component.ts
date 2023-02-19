import { Component } from '@angular/core';
import { Student } from 'src/app/entities/student';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-student-add',
  templateUrl: './student-add.component.html',
  styleUrls: ['./student-add.component.css'],
})
export class StudentAddComponent {
  student: Student = new Student(0, '', '', '', '');
  message: string = '';

  constructor(private service: StudentService) {}

  createStudent() {
    this.service.createStudent(this.student).subscribe({
      next: (data) => {
        this.message = data;
        this.student = new Student(0, '', '', '', '');
      },
      error: (err) => {
        console.log(err);
      },
      complete: () => {
        console.log('complete');
      },
    });
  }
}
