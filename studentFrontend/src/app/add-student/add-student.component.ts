import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from '../student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {

  "student": Student = new Student;

  constructor(private studentService: StudentService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveStudent(){
    this.studentService.addStudent(this.student).subscribe( data =>{
      console.log(data);
      this.goToSudentList();
    },
    error => console.log(error));
  }

  goToSudentList(){
    this.router.navigate(['/students']);
  }

  onSubmit(){
    console.log(this.student);
    this.saveStudent();

  }

}
