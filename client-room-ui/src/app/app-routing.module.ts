import { ListRoomsComponent } from './features/dashboard/list-rooms/list-rooms.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '**', redirectTo: 'rooms', pathMatch: 'full' },
  { path: 'rooms', component: ListRoomsComponent }
  // {path: 'details/:id', component: DetailsRoomComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
