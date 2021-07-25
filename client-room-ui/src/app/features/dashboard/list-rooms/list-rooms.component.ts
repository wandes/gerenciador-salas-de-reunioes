import { Router } from '@angular/router';
import { UpdateRoomComponent } from './../update-room/update-room.component';
import { RoomService } from './../../../shared/service/room.service';
import { Component, Inject, Input, OnInit } from '@angular/core';
import { Room } from 'src/app/shared/model/Room.model';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-list-rooms',
  templateUrl: './list-rooms.component.html',
  styleUrls: ['./list-rooms.component.scss']
})

export class ListRoomsComponent implements OnInit {
  listRooms!: Room[];
  constructor(private roomService: RoomService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.listAll();
  }

  update(room: Room) {
    const modal: NgbModalRef = this.modalService.open(UpdateRoomComponent, { size: 'lg' });
    (<UpdateRoomComponent>modal.componentInstance).room = room;

  }

  delete(id: number) {
    this.roomService.delete(id)
      .subscribe(data => {
          this.listAll();
      }, error => console.log(error));
  }

  listAll() {
    this.roomService.getList()
      .subscribe(data => {
        this.listRooms = data;
        console.log(data)
      }, error => console.log(error));
  }
}
