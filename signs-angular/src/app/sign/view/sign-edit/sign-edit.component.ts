import {Component, OnInit} from '@angular/core';
import {SignService} from '../../service/sign.service';
import {ActivatedRoute, Router} from '@angular/router';
import {SignForm} from '../../model/sign-form';
import {SignTypeService} from "../../../signtype/service/signtype.service";
import {SignTypes} from "../../../signtype/model/signtypes";

@Component({
  selector: 'app-sign-edit',
  templateUrl: './sign-edit.component.html',
  styleUrls: ['./sign-edit.component.css']
})
export class SignEditComponent implements OnInit {
  uuid: string | undefined;
  sign: SignForm | undefined;
  original: SignForm | undefined;
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
      this.signTypeService.getSignTypes()
        .subscribe(signTypes => this.signTypes = signTypes);

      this.signService.getSign(params['uuid'])
        .subscribe(sign => {
          this.uuid = sign.id;
          this.sign = {
            color: sign.color,
            name: sign.name,
            shape: sign.shape,
            signType: sign.signType.id
          };
          this.original = {...this.sign};
        });
    });
  }

  onSubmit(): void {
    this.signService.putSign(this.uuid!, this.sign!)
      .subscribe(() => this.router.navigate(['/signs']));
  }

}
