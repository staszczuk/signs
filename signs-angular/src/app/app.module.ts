import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FooterComponent} from './component/footer/footer.component';
import {HeaderComponent} from './component/header/header.component';
import {NavComponent} from './component/nav/nav.component';
import {HttpClientModule} from "@angular/common/http";
import {SignListComponent} from './sign/view/sign-list/sign-list.component';
import {SignService} from './sign/service/sign.service';
import {SignViewComponent} from './sign/view/sign-view/sign-view.component';
import {SignEditComponent} from './sign/view/sign-edit/sign-edit.component';
import {FormsModule} from "@angular/forms";
import {MainComponent} from "./component/main/main.component";
import {SigntypeListComponent} from "./signtype/view/signtype-list/signtype-list.component";
import {SignTypeService} from "./signtype/service/signtype.service";

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    SignListComponent,
    SignViewComponent,
    SignEditComponent,
    SigntypeListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    SignService,
    SignTypeService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

}
