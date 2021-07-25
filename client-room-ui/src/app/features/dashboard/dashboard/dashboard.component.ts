import { CreateRoomComponent } from './../create-room/create-room.component';
import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Room } from 'src/app/shared/model/Room.model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  title = "";
  listRoom!: Room[];
  constructor(private modalService: NgbModal) { }

  ngOnInit(): void {
   
  }

  open() {
    const modalRef = this.modalService.open(CreateRoomComponent);
    modalRef.componentInstance.name = 'CreateRoom';
  }
}
