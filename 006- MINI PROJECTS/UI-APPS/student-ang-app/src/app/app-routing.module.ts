import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentAddComponent } from './components/student-add/student-add.component';
import { StudentEditComponent } from './components/student-edit/student-edit.component';
import { StudentListComponent } from './components/student-list/student-list.component';

const routes: Routes = [
  { path: 'all', component: StudentListComponent },
  { path: 'create', component: StudentAddComponent },
  { path: 'edit/:id', component: StudentEditComponent },
  { path: '', redirectTo: 'all', pathMatch: 'full' },
  { path: '**', component: StudentListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
