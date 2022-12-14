import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { AuthModule } from '@auth0/auth0-angular';

import { LoginComponent } from 'src/app/components/login/login.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { ChatroomComponent } from './view/chatroom/chatroom.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserProfileComponent,
    ChatroomComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    AuthModule.forRoot({
      domain: 'dev-tosc339w.auth0.com',
      clientId: 'VcOPxm1ZUm8IjWaXhakX1sZ1lfk43GtY'
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
