import { Component } from '@angular/core';
import { v4 as uuid } from 'uuid';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgForOf, NgIf} from "@angular/common";
import {SignForm} from "../../model/sign-form";
import {SignTypes} from "../../../signtype/model/signtypes";
import {SignService} from "../../service/sign.service";
import {ActivatedRoute, Router} from "@angular/router";
import {SignTypeService} from "../../../signtype/service/signtype.service";

@Component({
  selector: 'app-sign-add',
  standalone: true,
    imports: [
        FormsModule,
        NgForOf,
        NgIf,
        ReactiveFormsModule
    ],
  templateUrl: './sign-add.component.html',
  styleUrl: './sign-add.component.css'
})
export class SignAddComponent {
  sign: SignForm | undefined;
  signTypes: SignTypes | undefined;

  constructor(
    private signService: SignService,
    private signTypeService: SignTypeService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.sign = {
        color: "",
        name: "",
        shape: "",
        signType: ""
      };
      this.signTypeService.getSignTypes()
        .subscribe(signTypes => this.signTypes = signTypes);
    });
  }

  onSubmit(): void {
    this.signService.putSign("a8db4bfc-ba33-4b5e-b7d4-1b9de8160f9a", this.sign!)
      .subscribe(() => this.router.navigate(['/signs']));
  }
}
