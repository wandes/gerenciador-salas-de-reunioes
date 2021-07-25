import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateRoomComponent } from './features/dashboard/create-room/create-room.component';
import { UpdateRoomComponent } from './features/dashboard/update-room/update-room.component';
import { FooterComponent } from './shared/footer/footer.component';
import { HeaderComponent } from './shared/header/header.component';
import { DashboardComponent } from './features/dashboard/dashboard/dashboard.component';
import { NavComponent } from './shared/nav/nav.component';
import { ListRoomsComponent } from './features/dashboard/list-rooms/list-rooms.component';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RoomService } from './shared/service/room.service';
import { registerLocaleData } from '@angular/common';
import localeBr from '@angular/common/locales/pt';

//registerLocaleData(localeBr, 'pt')
@NgModule({
  declarations: [
    AppComponent,
    CreateRoomComponent,
    ListRoomsComponent,
    UpdateRoomComponent,
    FooterComponent,
    HeaderComponent,
    DashboardComponent,
    NavComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [RoomService, 
    //{ provide: LOCALE_ID, useValue: 'pt' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
