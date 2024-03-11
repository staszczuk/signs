import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SignListComponent} from "./sign/view/sign-list/sign-list.component";
import {SignViewComponent} from "./sign/view/sign-view/sign-view.component";
import {SignEditComponent} from "./sign/view/sign-edit/sign-edit.component";
import {SigntypeListComponent} from "./signtype/view/signtype-list/signtype-list.component";
import {SigntypeViewComponent} from "./signtype/view/signtype-view/signtype-view.component";
import {SigntypeEditComponent} from "./signtype/view/signtype-edit/signtype-edit.component";
import {SigntypeAddComponent} from "./signtype/view/signtype-add/signtype-add.component";
import {SignAddComponent} from "./sign/view/sign-add/sign-add.component";

const routes: Routes = [
  {
    component: SignListComponent,
    path: "signs"
  },
  {
    component: SignAddComponent,
    path: "signs/add"
  },
  {
    component: SignViewComponent,
    path: "signs/:uuid"
  },
  {
    component: SignEditComponent,
    path: "signs/:uuid/edit"
  },
  {
    component: SigntypeListComponent,
    path: "signtypes"
  },
  {
    component: SigntypeAddComponent,
    path: "signtypes/add"
  },
  {
    component: SigntypeViewComponent,
    path: "signtypes/:uuid"
  },
  {
    component: SigntypeEditComponent,
    path: "signtypes/:uuid/edit"
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
