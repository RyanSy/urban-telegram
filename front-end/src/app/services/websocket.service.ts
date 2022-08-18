import { Injectable } from '@angular/core';
import * as SockJS from 'sockjs-client';
import Stomp from 'stompjs';

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {

  constructor() { }

  public stompClient;
  public msg = [];

  initializeWebSocketConnection(roomId: string) {
    const serverUrl = 'http://localhost:8081/socket';
    const ws = new SockJS(serverUrl);
    this.stompClient = Stomp.over(ws);
    const that = this;
    
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe('/message/' + roomId, (message) => {
        if(message.body) {
          that.msg.push(message.body);
        }
      });
    });
  }

  sendMessage(message, roomId: string){
    this.stompClient.send('/app/send/message/' + roomId, {}, message);
  }

}
