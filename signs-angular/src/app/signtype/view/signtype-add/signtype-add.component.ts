import { Component } from '@angular/core';
import { v4 as uuid } from 'uuid';
import {SignTypeForm} from "../../model/signtype-form";
import {SignTypeService} from "../../service/signtype.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgIf} from "@angular/common";
@Component({
  selector: 'app-signtype-add',
  standalone: true,
  imports: [
    FormsModule,
    NgIf,
    ReactiveFormsModule
  ],
  templateUrl: './signtype-add.component.html',
  styleUrl: './signtype-add.component.css'
})
export class SigntypeAddComponent {
  signType: SignTypeForm | undefined;

  constructor(
    private signTypeService: SignTypeService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.signType = {
      codePrefix: "",
      name: "",
    };
  }

  onSubmit(): void {
    this.signTypeService.putSign(uuid(), this.signType!)
      .subscribe(() => this.router.navigate(['/signtypes']));
  }
}
