import { EventEmitter, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Room } from '../model/Room.model';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private baseUrl = 'http://localhost:8082/api/v1/room';

  constructor(private http: HttpClient) { }

  getRoom(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  create(room: Room): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, room);
  }

  update(id: number, room: Room): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, room);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

  getList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
