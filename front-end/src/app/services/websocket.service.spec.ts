import { TestBed } from '@angular/core/testing';

import { WebsocketService } from './websocket.service';

describe('WebsocketService', () => {
  let service: WebsocketService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WebsocketService);
  });

  it('#should be created', () => {
    expect(service).toBeTruthy();
  });

  it('#initializeWebSocketConnection', () => {
    const mockService = jasmine.createSpyObj('WebsocketService',['initializeWebSocketConnect']);

    mockService.initializeWebSocketConnection('101');

    expect(mockService.initializeWebSocketConnect).toHaveBeenCalled();
  });

  it('#sendMessage', () => {
    const mockService = jasmine.createSpyObj('WebsocketService', ['sendMessage']);

    mockService.sendMessage("message","101");

    expect(mockService.sendMessage).toHaveBeenCalled();
  })
});
