import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Room } from 'src/app/shared/model/Room.model';
import { RoomService } from 'src/app/shared/service/room.service';

@Component({
  selector: 'app-update-room',
  templateUrl: './update-room.component.html',
  styleUrls: ['./update-room.component.scss']
})
export class UpdateRoomComponent implements OnInit {
  title: string = 'Atualizar reunião';
  formRoom!: FormGroup;
  id!: number;
  room!: Room;
  submitted = false;

  constructor(private roomService: RoomService, private modalService: NgbModal, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.formRoom = this.formBuilder.group({
      id: [this.room.id],
      name: [this.room.name, [Validators.required, Validators.min(2), Validators.maxLength(256)]],
      data: [this.room.data, [Validators.required]],
      starHour: [this.room.starHour, Validators.required],
      endHour: [this.room.endHour, [Validators.required]],
      description: [this.room.description, Validators.required],
    });
  }

  close() {
    const modalRef = this.modalService.dismissAll(UpdateRoomComponent);
  }

  onSubmit() {
    if (this.formRoom.invalid) {
      //alert('ERROR!!\n\n' + JSON.stringify(this.formRoom.value, null, 5))
      alert("Todos os campos são obrigatórios!")
      return;
    }
    this.room = this.formRoom.value;
    //console.log(this.room.id,  JSON.stringify(this.room , null, 5))
    this.update();
    location.reload();
    this.close();
  }

  update() {
    this.roomService.update(this.room.id, this.room)
      .subscribe(
        data => {
          //console.log(data),
        },
        error => {
          alert(error.message),
            console.log(error.message)
        })
  }
}
