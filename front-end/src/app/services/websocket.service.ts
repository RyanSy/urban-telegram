import { Injectable } from '@angular/core';
import * as SockJS from 'sockjs-client';
import Stomp from 'stompjs';

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {

  chatLog: string[] = [];
  disabled = true;

  private stompClient: any;

  constructor() { }

  setConnected(connected: boolean) {
    this.disabled = !connected;

    // clears chatLog
    if (connected)
      this.chatLog = [];
  }

  connect() {
    const socket = new SockJS("http://localhost:8080/chatroom");
    this.stompClient = Stomp.over(socket);

    const _this = this;
    this.stompClient.connect({}, (frame:any) => {
      _this.setConnected(true);
      console.log(`Connected: ${frame}`);

      _this.stompClient.subscribe('/topic/chat', (message: any) => {
        var username = JSON.parse(message.body).username;
        var userMessage = JSON.parse(message.body).message;
        _this.pushChatLog(`${username}: ${userMessage}`);
      });
    });
  }

  disconnect() {
    if (this.stompClient != null)
      this.stompClient.disconnect();
    
    this.setConnected(false);
    console.log('Disconnected!');
  }

  sendMessasge(username: string, message: string) {
    this.stompClient.send(
      '/chat/send',
      {},
      JSON.stringify({
        'username': username,
        'message': message
      })
    );
  }

  pushChatLog(message: string) {
    this.chatLog.push(message);
  }

}
