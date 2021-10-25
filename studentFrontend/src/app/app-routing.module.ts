import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddStudentComponent } from './add-student/add-student.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { StudentListComponent } from './student-list/student-list.component';
import { UpdateStudentComponent } from './update-student/update-student.component';

const routes: Routes = [
  {path:'students', component: StudentListComponent},
  {path: '', redirectTo: 'students', pathMatch: 'full'},
  {path:'add-student', component: AddStudentComponent},
  {path:'update-student/:id', component: UpdateStudentComponent},
  {path: 'student-details/:id', component: StudentDetailsComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
