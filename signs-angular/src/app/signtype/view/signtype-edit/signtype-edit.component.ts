import { Component } from '@angular/core';
import {SignTypeForm} from "../../../signtype/model/signtype-form";
import {SignTypes} from "../../model/signtypes";
import {SignTypeService} from "../../service/signtype.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-signtype-edit',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf,
    NgIf,
    ReactiveFormsModule
  ],
  templateUrl: './signtype-edit.component.html',
  styleUrl: './signtype-edit.component.css'
})
export class SigntypeEditComponent {
  uuid: string | undefined;
  signType: SignTypeForm | undefined;
  original: SignTypeForm | undefined;
  signTypes: SignTypes | undefined;

  constructor(
    private signTypeService: SignTypeService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.signTypeService.getSignTypes()
        .subscribe(professions => this.signTypes = professions);

      this.signTypeService.getSignType(params['uuid'])
        .subscribe(signType => {
          this.uuid = signType.id;
          this.signType = {
            codePrefix: signType.codePrefix,
            name: signType.name,
          };
          this.original = {...this.signType};
        });
    });
  }

  onSubmit(): void {
    this.signTypeService.putSign(this.uuid!, this.signType!)
      .subscribe(() => this.router.navigate(['/signtypes']));
  }

}
