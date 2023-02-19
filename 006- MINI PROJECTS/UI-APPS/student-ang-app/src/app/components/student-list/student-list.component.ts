import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from 'src/app/entities/student';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css'],
})
export class StudentListComponent implements OnInit {
  students: Student[] = [];
  message: any = '';

  constructor(private service: StudentService, private router: Router) {}

  ngOnInit() {
    this.getAllStudents();
  }

  getAllStudents() {
    this.service.getAllStudents().subscribe({
      next: (data) => (this.students = data),
      error: (err) => console.log(err),
      complete: () => console.info('complete'),
    });
  }

  deleteStudent(id: number) {
    this.service.deleteStudent(id).subscribe({
      next: (data) => {
        console.log(data);
        this.message = data;
        this.getAllStudents();
      },
      error: (err) => console.log(err),
      complete: () => console.info('complete'),
    });
  }

  editStudent(id: number) {
    this.router.navigate(['/edit', id]);
  }
}
