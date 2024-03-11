import {Component} from '@angular/core';
import {SignTypeDetails} from "../../../signtype/model/signtype-details";
import {SignTypeService} from "../../../signtype/service/signtype.service";
import {ActivatedRoute, Router} from "@angular/router";
import {NgForOf, NgIf} from "@angular/common";
import {Signs} from "../../../sign/model/signs";
import {SignService} from "../../../sign/service/sign.service";
import {Signtype} from "../../model/signtype";
import {Sign} from "../../../sign/model/sign";

@Component({
  selector: 'app-signtype-view',
  standalone: true,
  imports: [
    NgIf,
    NgForOf
  ],
  templateUrl: './signtype-view.component.html',
  styleUrl: './signtype-view.component.css'
})
export class SigntypeViewComponent {
  signs: Signs | undefined;
  signType: SignTypeDetails | undefined;

  constructor(private signService: SignService, private service: SignTypeService, private route: ActivatedRoute, private router: Router) {

  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.signService.getSignsBySignType(params['uuid'])
        .subscribe(signs => this.signs = signs)
    });
    this.route.params.subscribe(params => {
      this.service.getSignType(params['uuid'])
        .subscribe(signType => this.signType = signType)
    });
  }

  onDelete(sign: Sign): void {
    this.signService.deleteSign(sign.id).subscribe(() => this.ngOnInit());
  }
}
