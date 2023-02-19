import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from 'src/app/entities/student';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-student-edit',
  templateUrl: './student-edit.component.html',
  styleUrls: ['./student-edit.component.css'],
})
export class StudentEditComponent implements OnInit {
  student: Student = new Student(0, '', '', '', '');
  message: string = '';

  constructor(
    private service: StudentService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}
  ngOnInit() {
    let id = this.activatedRoute.snapshot.params['id'];
    this.loadStudent(id);
  }

  loadStudent(id: number) {
    this.service.getOneStudent(id).subscribe({
      next: (data) => {
        this.student = data;
      },
      error: (err) => console.log(err),
      complete: () => console.info('Student received successfully'),
    });
  }

  updateStudent() {
    this.service.updateStudent(this.student).subscribe({
      next: (data) => {
        this.message = data;
        alert(this.message);
        this.router.navigate(['/all']);
      },
      error: (err) => console.log(err),
      complete: () => console.info('Student updated successfully'),
    });
  }
}
