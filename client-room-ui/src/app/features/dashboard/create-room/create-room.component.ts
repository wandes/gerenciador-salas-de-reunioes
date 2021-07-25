import { ListRoomsComponent } from './../list-rooms/list-rooms.component';
import { RoomService } from './../../../shared/service/room.service';
import { Room } from './../../../shared/model/Room.model';
import { ChangeDetectionStrategy, Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-room',
  templateUrl: './create-room.component.html',
  styleUrls: ['./create-room.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CreateRoomComponent implements OnInit,OnDestroy {

  formRoom!: FormGroup;
  componentRef: any;
  title = "Nova reunião";
  _room: Room = new Room();
  submitted = false;

  constructor(private router:Router, private route:ActivatedRoute,
    private roomService: RoomService, private formBuilder: FormBuilder,private modalService: NgbModal) { }

  ngOnInit(): void {
    this._room = new Room();
    this.formRoom = this.formBuilder.group({
      name: ['', [Validators.required, Validators.min(2), Validators.maxLength(256)]],
      data: ['',[Validators.required]],
      starHour: ['',Validators.required],
      endHour: ['',[Validators.required]],
      description: ['',Validators.required],
    });
  }
  
  ngOnDestroy(): void {
    
  }

  close() {
    const modalRef = this.modalService.dismissAll(CreateRoomComponent);
  }

  onSubmit() {
    if(this.formRoom.invalid){
      //alert('ERROR!!\n\n' + JSON.stringify(this.formRoom.value, null, 5))
      alert("Todos os campos são obrigatórios!")
      return;
    }
    this._room = this.formRoom.value;
    this.save();
    location.reload();
    this.close();
  }

  refreshComponent(){
    console.log("refresh")
    // this.router.navigate(['rooms'])
 }
  save() {
    this.roomService.create(this._room)
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
